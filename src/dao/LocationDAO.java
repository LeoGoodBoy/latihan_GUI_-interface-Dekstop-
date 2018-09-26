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
import model.Location;

/**
 *
 * @author chochong
 */
public class LocationDAO {
    private Connection koneksi;

    public LocationDAO(Connection koneksi) {
        this.koneksi = koneksi;
    }
    
    
    public boolean eksekusi(String sql) {
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            statment.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return true;
    }
    
    public int autoId() {
        return this.getData("select max(location_id)+1 location_id,max(location_name)"
                + "location_name from locations").get(0).getLocation_id();
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
                location.setCountry_id(new Country(resultSet.getString("COUNTRY_ID")));
                locations.add(location);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return locations;
    }
    
    public boolean simpanLocation(String regName) {
        int id = this.autoId();
        return this.eksekusi("insert into locations values (" + id + ",'" + regName + "')");
    }
}
