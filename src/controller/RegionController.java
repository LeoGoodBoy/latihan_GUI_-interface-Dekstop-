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

   
    public RegionController(Connection koneksi) {
        this.rdao = new RegionDAO(koneksi);
        this.serbaGunaController = new SerbaGunaController();
    }

    public String simpanRegion(String regionName) {
        return serbaGunaController.getMessage(rdao.simpanRegion(regionName));
    }
    
    public String updateRegion(String regionId, String regionName){
        Region region = new Region(Integer.parseInt(regionId), regionName);
        return serbaGunaController.getMessage(rdao.updateRegion(region));
    }
    
    public String hapusRegion(String regionId){
        int region = Integer.parseInt(regionId);
        return serbaGunaController.getMessage(rdao.hapusRegion(region));
    }
    
    public List<Region> viewRegion(){
        return rdao.getAllData();
    }
    
}
