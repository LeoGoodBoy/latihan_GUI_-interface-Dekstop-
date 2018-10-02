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
 
    /**
     * membuat konstraktor country dao
     * @param koneksi untuk membuat koneksi, yang selanjuntya tinggal di set n get
     */
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
    
    /**
     * fungtion untuk melakukan eksekusi query
     * @param sql paremeter yang dibutuhkan untuk mendapatkan data country
     * @return List Country
     */
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
                Region region = rdao.getById(resultSet.getInt(3)).get(0);
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
      //return this.getData("select * from countries where regexp_like(" + category + ",'" + cari + "','i') order by "+category+""); 
       return this.getData("select c.country_id, c.country_name, r.region_id, r.region_name "
               + "from countries c left join regions r on c.region_id = r.region_id "
               + "where regexp_like(" + category + ",'" + cari + "','i') order by "+category+""); 
        //return this.getData("select c.country_id, c.country_name, r.region_name from countries c join regions r on c.region_id = r.region_id where "+category+" like '"+cari+"%' order by "+category+"");
    }

    /**
     * fungtion eksekusi bertipe boolean 
     * @param sql paremeter yang dibutuhkan untuk mendapatkan data country
     * sesuai dengan query database
     * @return hsail, mengembalikan nilai boolean untuk setiap eksekusi fungsi
     */
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
    
    /**
     * function simpan untuk melakukan query simpan dari data inputan.
     * @param country untuk mengambil atribut dari class country
     * @return 
     */
    public boolean simpanCountry(Country country){
        String query = "insert into COUNTRIES values ('"
                +country.getCountryId()+"','"+country.getCountryName()+"',"
                +country.getRegion().getRegionId()+")";
        return this.eksekusi(query);
    }
    
    /**
     * function hapus country untuk query hapus dari data imputan berupa get id bertipe string
     * @param id karena di tabelnya country_id bertipe varchar2
     * @return 
     */
    public boolean hapusCountry(String id){
        return this.eksekusi("delete from COUNTRIES where country_id ='"+id+"'");
    }
    
    /**
     * funcytion untuk updatecountry untuk query uppdate dari data inputan berupa get atribut dari country
     * @param country
     * @return 
     */
    public boolean updateCountry(Country country) {
        return this.eksekusi("update countries set country_name='" + country.getCountryName()
                + "', region_id="+ country.getRegion().getRegionId()
                + " where country_id='" + country.getCountryId() +"'");
    }
    
    /**
     * function getbyid untuk melakukan query select countries berdasarkan get id bertipe string
     * @param id karena varchar2
     * @return 
     */
    public List<Country> getById(String id) {
        return this.getData("select * from countries where country_id = '" + id + "'");
    }
    
}
