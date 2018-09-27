/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LocationDAO;
import java.sql.Connection;
import java.util.List;
import model.Country;
import model.Location;

/**
 *
 * @author chochong
 */
public class LocationController {

    private LocationDAO ldao;
    private SerbaGunaController serbaGunaController;

    public LocationController(Connection koneksi) {
        this.ldao = new LocationDAO(koneksi);
        this.serbaGunaController = new SerbaGunaController();
    }

    public String simpanUpdateLocation(String location_id, String street_address, String postal_code, String city, String state_province, String country_id, boolean isSave) {
        Country country = new Country(country_id);
        Location location = new Location(Integer.parseInt(location_id), street_address, postal_code, city, state_province, country);
        if (isSave) {
            return serbaGunaController.getMessage(ldao.simpanLocation(location));
        } else {
            return serbaGunaController.getMessage(ldao.updateLocation(location));
        }
    }
    public String hapusLocation(String locationId) {
        int location = Integer.parseInt(locationId);
        return serbaGunaController.getMessage(ldao.hapusLocation(location));
    }

    public List<Location> viewLocation() {
        return ldao.getAllDataLocation();
    }

    public List<Location> searchLocation(String category, String cari) {
        return ldao.searchLocation(category, cari);
    }

}
