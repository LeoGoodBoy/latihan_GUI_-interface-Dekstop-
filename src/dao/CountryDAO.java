/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Country;


/**
 *
 * @author chochong
 */
public class CountryDAO {
    private Connection koneksi;

    public CountryDAO() {
    }

    public CountryDAO(Connection koneksi) {
        this.koneksi = koneksi;
    }

    public Connection getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(Connection koneksi) {
        this.koneksi = koneksi;
    }
    
    public List<Country> getData(String sql){
        List<Country> countrys = new ArrayList<>();
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            ResultSet resultSet = statment.executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
                country.setCountryId(resultSet.getString("COUNTRY_ID"));
                country.setCountryName(resultSet.getString("COUNTRY_NAME"));
                countrys.add(country);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return countrys;
    }
    
    /**
     * getAllData digunakan untuk mengambil semua data dari tabel region
     * @return mengirimkan nilai kedalam method getData menggunakan query yang dijadikan parameter
     */
    public List<Country> getAllData(){
        return this.getData("select * from countries order by 1");
    }
    
    /**
     * getById digunakan untuk mengambil data dari tabel region berdasarkan id tertentu
     * @param id digunakan sebagai kunci utama dalam melakukan pencarian
     * @return mengirimkan nilai kedalam method getData menggunakan query yang dijadikan parameter
     */
    public List<Country> getById(int id){
        return this.getData("select region_id, region_name from countries where region_id = '"+id+"'");
    }
    
    /**
     * search digunakan untuk mengambil data dari tabel region berdasarkan id tertentu
     * @param category digunakan sebagai kunci utama dalam melakukan pencarian
     * @param cari digunakan sebagai kunci utama dalam melakukan pencarian
     * @return mengirimkan nilai kedalam method getData menggunakan query yang dijadikan parameter
     */
    public List<Country> search(String category, String cari){
        return this.getData("select * from countries where regexp_like("+category+",'"+cari+"','i') order by 1");
                
    }
    
    public boolean eksekusi(String sql){
        boolean hasil = false;
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            statment.executeQuery();
            hasil = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return hasil;
    }
    
    public boolean simpanCountry(Country country){
        return this.eksekusi("insert into COUNTRIES values ('"
                +country.getCountryId()+"','"+country.getCountryName()+"',"
                +country.getRegion().getRegionId()+")");
    }
    
    public boolean hapusCountry(String id){
        return this.eksekusi("delete from COUNTRIES where country_id ='"+id+"'");
    }
    
    public boolean updateCountry(Country country) {
        return this.eksekusi("update countries set country_name='" + country.getCountryName()
                + "', region_id="+ country.getRegion().getRegionId()
                + " where country_id='" + country.getCountryId() +"'");
    }
    
}
