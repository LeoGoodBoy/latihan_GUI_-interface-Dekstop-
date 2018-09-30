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
import model.Region;


/**
 *
 * @author chochong
 */
public class CountryDAO {
    private Connection koneksi;
    private RegionDAO rdao;
    /**
     * 
     */
    public CountryDAO() {
    }

    public CountryDAO(Connection koneksi) {
        this.koneksi = koneksi;
        this.rdao = new RegionDAO(koneksi);
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
                country.setCountryId(resultSet.getNString(1));
                country.setCountryName(resultSet.getNString(2));               
               // country.setRegion(new Region(resultSet.getInt("REGION_ID")));
               int rId = 0;
               String rName = "";
               int lenght = rdao.getById(resultSet.getInt("Region_id")).size();
               if (lenght > 0 ){
                   rId = rdao.getById(resultSet.getInt("region_id")).get(0).getRegionId();
                   rName = rdao.getById(resultSet.getInt("region_id")).get(0).getRegionName();
               }
               Region region;
               if(rId == 0) region = new Region();
               else region = new Region(rId, rName);
                       
                //Region region = rdao.getById(resultSet.getInt(3)).get(0);
                //System.out.println(region.getRegionId());
                country.setRegion(region);
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
    
    /**
     * search digunakan untuk mengambil data dari tabel region berdasarkan id tertentu
     * @param category digunakan sebagai kunci utama dalam melakukan pencarian
     * @param cari digunakan sebagai kunci utama dalam melakukan pencarian
     * @return mengirimkan nilai kedalam method getData menggunakan query yang dijadikan parameter
     */
    public List<Country> searchCountry(String category, String cari){
      return this.getData("select * from countries where regexp_like(" + category + ",'" + cari + "','i') order by "+category+""); 
       //return this.getData("select c.country_id, c.country_name, r.region_name from countries c join regions r on c.region_id = r.region_id where regexp_like(" + category + ",'" + cari + "','i') order by "+category+""); 
       // return this.getData("select c.country_id, c.country_name, r.region_name from countries c join regions r on c.region_id = r.region_id where "+category+" like '"+cari+"%' order by "+category+"");
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
        String query = "insert into COUNTRIES values ('"
                +country.getCountryId()+"','"+country.getCountryName()+"',"
                +country.getRegion().getRegionId()+")";
        return this.eksekusi(query);
    }
    
    public boolean hapusCountry(String id){
        return this.eksekusi("delete from COUNTRIES where country_id ='"+id+"'");
    }
    
    public boolean updateCountry(Country country) {
        return this.eksekusi("update countries set country_name='" + country.getCountryName()
                + "', region_id="+ country.getRegion().getRegionId()
                + " where country_id='" + country.getCountryId() +"'");
    }
    
    public List<Country> getById(String id) {
        return this.getData("select * from countries where country_id = '" + id + "'");
    }
    
}
