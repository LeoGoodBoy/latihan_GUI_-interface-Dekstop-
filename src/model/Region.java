/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author chochong
 */
public class Region {
    private int regionId;
    private String regionName;
    private List<Country> country;

    public Region() {
    }

    public Region(int regionId) {
        this.regionId = regionId;
    }

    public Region(int regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }
    
    public Region(int regionId, String regionName, List<Country> country) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.country = country;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }
    
    
}
