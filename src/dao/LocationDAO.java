/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Country;
import model.Department;
import model.Location;

/**
 *
 * @author chochong
 */
public class LocationDAO {
    private Connection koneksi;
    private CountryDAO cdao;

    public LocationDAO() {
    }
    
    public LocationDAO(Connection koneksi) {
        this.koneksi = koneksi;
        this.cdao = new CountryDAO(koneksi);
    }
    
    public boolean eksekusi(String sql) {
        boolean hasil = false;
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            statment.execute();
            hasil = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return hasil;
    }
    
    public int autoId() {
        return this.getData("select max(LOCATION_ID)+100 LOCATION_ID, max(STREET_ADDRESS) STREET_ADDRESS, "
                + "max(POSTAL_CODE) POSTAL_CODE, max(CITY) CITY, max(STATE_PROVINCE) STATE_PROVINCE, "
                + "max(COUNTRY_ID) COUNTRY_ID from locations").get(0).getLocation_id();
    }

    public List<Location> getData(String sql) {
        List<Location> locations = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = koneksi.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location location = new Location();
                location.setLocation_id(resultSet.getInt("LOCATION_ID"));
                location.setStreet_address(resultSet.getString("STREET_ADDRESS"));
                location.setPostal_code(resultSet.getString("POSTAL_CODE"));
                location.setCity(resultSet.getString("CITY"));
                location.setState_province(resultSet.getString("STATE_PROVINCE"));
                Country country = cdao.getById(resultSet.getString("COUNTRY_ID")).get(0);
                location.setCountry_id(country);
                locations.add(location);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return locations;
    }
    
    
    public boolean simpanLocation(Location location) {
        int locationId = this.autoId(); 
        System.out.println(location.getCountry_id()==null);
        System.out.println(locationId);
        return this.eksekusi("insert into locations values ("
                + locationId
                + ",'"  + location.getStreet_address()
                + "','" + location.getPostal_code()
                + "','" + location.getCity()
                + "','" + location.getState_province()
                + "','"  + location.getCountry_id().getCountryId()+ "')");
    }
    
    
//   public boolean simpanLocation(String street_address, String postal_code, String city, String state_province, String country_id) {
//        int locationId = this.autoId();
//        return this.eksekusi("insert into locations values (" + locationId 
//                +",'" + street_address
//                +"','" + postal_code
//                +"','" + city
//                +"','" + state_province
//                +"','" + country_id
//                +"') ORDER BY location_id");
//    }
    
    public boolean updateLocation(Location location) {
        return this.eksekusi("update locations set street_address='"+location.getStreet_address()
                +"', POSTAL_CODE='"+location.getPostal_code()
                +"', CITY='"+location.getCity()
                +"', STATE_PROVINCE='"+location.getState_province()
                +"', COUNTRY_ID='"+location.getCountry_id().getCountryId()
                +"' where location_id=" + location.getLocation_id());
    }
    
    public boolean hapusLocation(int locationId) {
        return this.eksekusi("delete from locations where location_id ='" + locationId + "'");
    }
    
    public List<Location> searchLocation(String category, String cari) {
        return this.getData("select * from locations where regexp_like(" + category + ",'" + cari + "','i') order by 1");
    }
    
    public List<Location> getAllDataLocation() {
        return this.getData("select * from locations order by 1");
    }

    
    public List<Location> getById(int id) {
        return this.getData("select * from locations where location_id = " + id);
    }
}
