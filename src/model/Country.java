/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author chochong
 */
public class Country {
    private String countryId;
    private String countryName;
    private Region region;

    /**
     * untuk konstraktor country secara umum
     */
    public Country() {
    }

    /**
     * untuk kontraktor country id
     * @param countryId bertipe string karena di tabelnya bertipe varchar2
     */
    public Country(String countryId) {
        this.countryId = countryId;
    }

    /**
     * untuk kontraktor country_id dan country_name
     * @param countryId bertipe string karena di tabelnya bertipe varchar2
     * @param countryName bertipe string karena di tabelnya bertipe varchar2
     */
    public Country(String countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    /**
     * untuk kontraktor country_id, country_name, region dari class region
     * @param countryId bertipe string karena di tabelnya bertipe varchar2
     * @param countryName bertipe string karena di tabelnya bertipe varchar2
     * @param region ambil class region
     */
    public Country(String countryId, String countryName, Region region) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.region = region;
    }

    /** 
     * get country_id
     * @return 
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * untuk setcountry_id
     * @param countryId 
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     * untuk get country_name
     * @return 
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * untuk setcountryName
     * @param countryName 
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * untuk getregion
     * @return 
     */
    public Region getRegion() {
        return region;
    }

    /**
     * untuk setRegion
     * @param region 
     */
    public void setRegion(Region region) {
        this.region = region;
    }
    
    
}
