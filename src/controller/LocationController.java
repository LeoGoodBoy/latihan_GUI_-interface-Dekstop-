/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CountryDAO;
import dao.LocationDAO;
import java.sql.Connection;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import model.Country;
import model.Location;

/**
 *
 * @author chochong
 */
public class LocationController {

    private LocationDAO ldao;
    private CountryDAO cdao;
    private SerbaGunaController serbaGunaController;

    /**
     * adalah constructor LocationController memiliki parameter yang bernama koneksi, didalam constructor ini terdapat
     * instansiasi dari kelas LocationDAO, instansiasi dari kelas SerbaGunaController dan kelas CountryDAO
     * @param koneksi adalah parameter yang bertipe Connection dari kelas java
     */
    public LocationController(Connection koneksi) {
        this.ldao = new LocationDAO(koneksi);
        this.serbaGunaController = new SerbaGunaController();
        this.cdao = new CountryDAO(koneksi);
    }

    /**
     * method simpanLOcation bertipe string digunakan untuk menyimpan lokasi baru yang akan diinputkan kedalam database
     * @param street_address digunakan untuk menampung nilai dari txtfield street_address untuk mengeksekusi proses penyimpanan
     * @param postal_code digunakan untuk menampung nilai dari txtfield postal code untuk mengeksekusi proses penyimpanan
     * @param city digunakan untuk menampung nilai dari txtfield city  untuk mengeksekusi proses penyimpanan
     * @param state_province digunakan untuk menampung nilai dari txtfield state province untuk mengeksekusi proses penyimpanan
     * @param country_id digunakan untuk menampung nilai dari txtfield country id untuk mengeksekusi proses penyimpanan
     * @return mengembalikan nilai dari hasil eksekusi yang dilakukan didalam method simpanLocation
     */
    public String simpanLocation(String street_address, String postal_code,
            String city, String state_province, String country_id) {
        Country country = new Country(country_id);
        Location location = new Location(0, street_address, postal_code, city, state_province, country);
        return serbaGunaController.getMessage(ldao.simpanLocation(location));
    }

    /**
     * method updateLocation bertipe String digunakan untuk mengupdate data yang sudah tersimpan didalam database
     * @param locationId digunakan untuk menampung nilai sementara untuk mengeksekusi proses update
     * @param street_address digunakan untuk menampung nilai sementara untuk mengeksekusi proses update
     * @param postal_code digunakan untuk menampung nilai sementara untuk mengeksekusi proses update
     * @param city digunakan untuk menampung nilai sementara untuk mengeksekusi proses update
     * @param state_province digunakan untuk menampung nilai sementara untuk mengeksekusi proses update
     * @param country_id digunakan untuk menampung nilai sementara untuk mengeksekusi proses update
     * @return mengembalikan nilai dari hasil eksekusi yang dilakukan didalam method updateLocation
     */
    public String updateLocation(String locationId, String street_address, String postal_code,
            String city, String state_province, String country_id) {
        Country country = new Country(country_id);
        Location location = new Location(Integer.parseInt(locationId), street_address, postal_code, city, state_province, country);
        return serbaGunaController.getMessage(ldao.updateLocation(location));
    }

    /**
     * method hapusLOcation digunakan untuk menghapus data yang sudah tersimpan didalam database berdasarkan nilai dari parameter lokal yang berna,a locationId
     * @param locationId digunakan untuk menampung nilai sementara, nilai tersebut akan dijadikan kunci utama dalam melakukan penghapusan
     * @return menampilkan pesan berhasil atau gagal dari method get Message dari kelas serbagunaController  dari hasil proses hapusLocation
     * 
     */
    public String hapusLocation(String locationId) {
        int location = Integer.parseInt(locationId);
        return serbaGunaController.getMessage(ldao.hapusLocation(location));
    }

    /**
     * method viewLocation bertipe List digunakan untuk menampilan semua data dari tabel location
     * @return mengembalikan hasil dari proses getAllDataLocation
     */
    public List<Location> viewLocation() {
        return ldao.getAllDataLocation();
    }

    /**
     * method seearchLocaton bertipe List igunakan untuk melakukan pencarian data dari tabel location 
     * @param category digunakan untuk menyimpan nilai dari combobox data dari jenis pencarian yang akan dilakukan
     * @param cari digunakan untuk menyimpan nilai dari kunci pencarian yang berasal dari text field
     * @return  get lokasi yang dicari
     */
    public List<Location> searchLocation(String category, String cari) {
        if ("country_name".equals(category)) {
            return ldao.searchByName(category, cari);
        }else{
            return ldao.searchLocation(category, cari);
        }
    }
    
    /**
     * method loadCmb bertipe void digunakan untuk menampilkan nilai dari country_id dan country_name kedalam combo box
     * @param cmb digunakan untuk menumpan sementara nilai dari combo box yang akan ditampilkan nilainya
     */
    public void loadCmb(JComboBox cmb){
        List<Country> countrys = cdao.getAllData();
        for (Country country : countrys) {
            cmb.addItem(country.getCountryId()+" - "+country.getCountryName());
        }
    }
    
    /**
     * method loadMaxId bertipe void digunakan untuk menampilkan nilai max dari id dan menampilkan nilai tersebut kedalam field tertentu
     * @param txt digunakan untuk menyimpan nama field tertentu yang akan ditampilkan
     */
    public void loadMaxId(JTextField txt){
        String t = ldao.autoId()+"";
        txt.setText(t);
    }

}
