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
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import model.Country;
import model.Region;
import tools.Koneksi;

/**
 *
 * @author chochong
 */
public class CountryController {

    private SerbaGunaController serbaGunaController;
    private CountryDAO cdao;
    private RegionDAO rdao;

    public CountryController(Connection koneksi) {
        this.cdao = new CountryDAO(koneksi);
        this.serbaGunaController = new SerbaGunaController();
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
    public String hapusCountry(String country_id) {
        return serbaGunaController.getMessage(cdao.hapusCountry(country_id));
    }

//    public String updateCountry(String country_id, String country_name, String region_id) {
//        Region region = new Region(Integer.parseInt(region_id));
//        Country country = new Country(country_id, country_name, region);
//        return this.getMessage(cdao.updateCountry(country));
//    }
    public String saveOrUpdateCountry(String country_id, String country_name, String region_id, boolean isSave) {
        Region region = new Region(Integer.parseInt(region_id));
        Country country = new Country(country_id, country_name, region);
        if (isSave) {
            return serbaGunaController.getMessage(cdao.simpanCountry(country));
        } else {
            return serbaGunaController.getMessage(cdao.updateCountry(country));
        }

    }

    public List<Country> searchCountry(String category, String cari) {
        return cdao.searchCountry(category, cari);
    }

    public List<Country> viewCountry() {
        return cdao.getAllData();
    }

    public void loadCmbRegionId(JComboBox cmb) {
        List<Region> regions = rdao.getAllData();
        regions.forEach((region) -> {
            cmb.addItem(region.getRegionId()+" - "+region.getRegionName());
        });
    }
}
