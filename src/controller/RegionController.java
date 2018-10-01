/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RegionDAO;
import java.sql.Connection;
import java.util.List;
import model.Region;

/**
 *
 * @author chochong
 */
public class RegionController {
    private RegionDAO rdao;
    private SerbaGunaController serbaGunaController;

   /**
    * merupakan constructor dari kelas regionController yang memiliki parameter yang bertipe connection dan bernama koneksi
    * didalam method ini berisi instansiasi dari kelas regionDAO dan kelas serbagunaController
    * @param koneksi 
    */
    public RegionController(Connection koneksi) {
        this.rdao = new RegionDAO(koneksi);
        this.serbaGunaController = new SerbaGunaController();
    }

    /**
     * method simpanRegion bertipe string yang digunakan untuk melakukan penyimpanan data region baru kedalam database
     * @param regionName digunakan untuk menampung nilai sementara dari regionName
     * @return  mengembalikan pesan dari hasil proses penyimpanan dalam method yang bernama simapnRegion
     */
    public String simpanRegion(String regionName) {
        return serbaGunaController.getMessage(rdao.simpanRegion(regionName));
    }
    
    /**
     * method updateRegion bertipe String yang digunakan untuk melakukan update data region yang sudah tersimpan didalam database
     * @param regionId digunakan untuk menampung nilai sementara dari region Id
     * @param regionName digunakan untuk menampung nilai sementara dari region name
     * @return mengembalikan pesan dari hasil proses update dalam method yang bernama updateRegion
     */
    public String updateRegion(String regionId, String regionName){
        Region region = new Region(Integer.parseInt(regionId), regionName);
        return serbaGunaController.getMessage(rdao.updateRegion(region));
    }
    
    /**
     * method hapusRegion bertipe String digunakan untuk menghapus data region berdasarkan idregion yang diinputkan
     * @param regionId nilai dari idregion yang diinputkan akan menjadi kunci dalam proses penghapusan data region
     * @return mengembalikan pesan dari hasil proses yang dilakukan didalam method hapusRegion
     */
    public String hapusRegion(String regionId){
        int region = Integer.parseInt(regionId);
        return serbaGunaController.getMessage(rdao.hapusRegion(region));
    }
    
    /**
     * method viewRegion bertipe list digunakan untuk menampilkan seluruh data dari region
     * @return mengembalikan nilai dari hasil method getAllData yang terdapat dalam kelas RegionDAO
     */
    public List<Region> viewRegion(){
        return rdao.getAllData();
    }
    
    /**
     * method searchRegion bertipe List dan memiliki parameter yang bernama catergory dan cari
     * @param category digunakan untuk menampung nilai dari combobox yang dipilih
     * @param cari digunakan untuk menampung nilai dari text field yang diinputkan
     * @return mengembalikan nilai dari hasil proses method search yang memiliki parameter category dan parameter cari
     */
    public List<Region> searchRegion(String category, String cari){
        return rdao.search(category, cari);
    }
    
}
