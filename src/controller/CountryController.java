/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CountryDAO;
import dao.RegionDAO;
import java.sql.Connection;
import java.util.List;
import javax.swing.JComboBox;
import model.Country;
import model.Region;

/**
 *
 * @author chochong
 */
public class CountryController {
private SerbaGunaController serbaGunaController;
    private CountryDAO cdao;
    private RegionDAO rdao;

    /**
     * Buat koneksi
     * digunakan untuk pendeklarian dan pemanggilan class yang dibutuhkan dalam class ini, tentunya yang membutuhkan koneksi
     * @param koneksi untuk parameter koneksi
     */
    public CountryController(Connection koneksi) {
        this.cdao = new CountryDAO(koneksi);
        this.serbaGunaController  = new SerbaGunaController();
        this.rdao = new RegionDAO(koneksi);
    }

//    public String simpanCountry(String country_id, String country_name, String region_id) {
//        String pesan = "gagal";
//        Region region = new Region(Integer.parseInt(region_id));
//        Country country = new Country(country_id, country_name, region);
//        if (cdao.simpanCountry(country)) {
//            pesan = "sukses";
//        }
//        return pesan;
//
//    }
//    public String simpanCountry(String country_id, String country_name, String region_id) {
//        Region region = new Region(Integer.parseInt(region_id));
//        Country country = new Country(country_id, country_name, region);
//        return this.getMessage(cdao.simpanCountry(country));
//    }

    /**
     * dok hapus country 
     * untuk melakukan hapus country berdasarkan id atau country_id
     * sukses atau agal eksekusi akan di tampilkan melalui fungtion serbagunacontroller
     * @param country_id mengambil inpputan bertipe string
     * @return pesan berhasil atau gagal
     */
    public String hapusCountry(String country_id) {
        return serbaGunaController.getMessage(cdao.hapusCountry(country_id));
    }

//    public String updateCountry(String country_id, String country_name, String region_id) {
//        Region region = new Region(Integer.parseInt(region_id));
//        Country country = new Country(country_id, country_name, region);
//        return this.getMessage(cdao.updateCountry(country));
//    }
    /**
     * fungtion ini difungsikan untuk melakukan simpan dan update sekaligus, hanya saja tambah parameter isSave bertipe boolean
     * @param country_id untuk get country_id
     * @param country_name untuk get country_name
     * @param region_id untuk get region_id
     * @param isSave untuk get true or false
     * @return pesan berhasil atau gagal
     */
    public String saveOrUpdateCountry(String country_id, String country_name, String region_id, boolean isSave) {
        Region region = new Region(Integer.parseInt(region_id));
        Country country = new Country(country_id, country_name, region);
        if (isSave) return serbaGunaController.getMessage(cdao.simpanCountry(country));
        else return serbaGunaController.getMessage(cdao.updateCountry(country));
            
    }
    
    /**
     * untuk menampilkan list dari country hasil dari search
     * @param category untuk get kategori atau nama kolomnya
     * @param cari untuk get apa yang hendak dicari
     * @return mengambil kategori dan cari
     */
    public List<Country> searchCountry(String category, String cari){
        return cdao.searchCountry(category, cari);
    }
    
    /**
     * untuk menampilkan keseluruhan dari isi tabel countries join regions
     * @return untuk mengambil keseluruhan data
     */
    public List<Country> viewCountry(){
        return cdao.getAllData();
    }

    /**
     * untuk select combobox yang dipilih berdasarkan data dari tabel region
     * @param cmb untuk mengambil data comboboxnya
     */
    public  void loadCmb(JComboBox cmb){
        List<Region> regions = rdao.getAllData();
        for (Region region : regions) {
            cmb.addItem(region.getRegionId()+" - "+region.getRegionName());
        }
    }
            
}
