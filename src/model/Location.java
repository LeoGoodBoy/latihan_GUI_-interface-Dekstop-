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
public class Location {
    private int location_id;
    private String Street_address;
    private String postal_code;
    private String city;
    private String state_province;
    private Country country_id;

    public Location() {
    }

    public Location(int location_id, String Street_address, String postal_code, String city, String state_province, Country country_id) {
        this.location_id = location_id;
        this.Street_address = Street_address;
        this.postal_code = postal_code;
        this.city = city;
        this.state_province = state_province;
        this.country_id = country_id;
    }

    /**
     * @return the location_id
     */
    public int getLocation_id() {
        return location_id;
    }

    /**
     * @param location_id the location_id to set
     */
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    /**
     * @return the Street_address
     */
    public String getStreet_address() {
        return Street_address;
    }

    /**
     * @param Street_address the Street_address to set
     */
    public void setStreet_address(String Street_address) {
        this.Street_address = Street_address;
    }

    /**
     * @return the postal_code
     */
    public String getPostal_code() {
        return postal_code;
    }

    /**
     * @param postal_code the postal_code to set
     */
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state_province
     */
    public String getState_province() {
        return state_province;
    }

    /**
     * @param state_province the state_province to set
     */
    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    /**
     * @return the country_id
     */
    public Country getCountry_id() {
        return country_id;
    }

    /**
     * @param country_id the country_id to set
     */
    public void setCountry_id(Country country_id) {
        this.country_id = country_id;
    }
    
    

}
