/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import model.Country;
import model.Location;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.Koneksi;

/**
 *
 * @author Lenovo
 */
public class LocationDAOTest {
    
    Connection koneksi = new Koneksi().getKoneksi();
    LocationDAO lao = new LocationDAO(koneksi);
    public LocationDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of eksekusi method, of class LocationDAO.
     */
    @Test
    public void testEksekusi() {
        System.out.println("eksekusi");
        LocationDAO instance = new LocationDAO();
        Connection expResult = null;
        Connection result = instance.getKoneksi();
        assertEquals(expResult, result);
    }

    /**
     * Test of autoId method, of class LocationDAO.
     */
    @Test
    public void testAutoId() {
        System.out.println("autoId");
        int result = lao.autoId();
        assertNotNull(result);
    }

    /**
     * Test of getData method, of class LocationDAO.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        List<Location> locations = lao.getAllDataLocation();
        assertNotNull(locations);
    }

    /**
     * Test of simpanLocation method, of class LocationDAO.
     */
    @Test
    public void testSimpanLocation() {
        System.out.println("simpanLocation");
        Country country = new Country("AU");
        Location location = new Location(0, "Street_address", "postal_code", "city", "state_province", country);
        boolean result = lao.simpanLocation(location);
        assertTrue(result);
    }

    /**
     * Test of updateLocation method, of class LocationDAO.
     */
    @Test
    public void testUpdateLocation() {
        System.out.println("updateLocation");
        Country country = new Country("AU");
        Location location = new Location(0, "Street_address", "postal_code", "city", "state_province", country);
        boolean result = lao.updateLocation(location);
        assertTrue(result);
    }

    /**
     * Test of hapusLocation method, of class LocationDAO.
     */
    @Test
    public void testHapusLocation() {
        System.out.println("hapusLocation");
        int locationId = 1000;
        boolean expResult = true;
        boolean result = lao.hapusLocation(locationId);
        assertNotNull(result);
    }

    /**
     * Test of searchLocation method, of class LocationDAO.
     */
    @Test
    public void testSearchLocation() {
        System.out.println("searchLocation");
        List<Location> result = lao.searchLocation("location_id", "1000");
        assertNotNull(result);
    }

    /**
     * Test of getAllDataLocation method, of class LocationDAO.
     */
    @Test
    public void testGetAllDataLocation() {
        System.out.println("getAllDataLocation");
        List<Location> departments = lao.getAllDataLocation();
        assertNotNull(departments);
    }
    
}
