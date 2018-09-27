/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import model.Country;
import model.Region;
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
public class CountryDAOTest {
    
    Connection koneksi = new Koneksi().getKoneksi();
    CountryDAO cdao = new CountryDAO(koneksi);
    
    public CountryDAOTest() {
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
     * Test of getKoneksi method, of class CountryDAO.
     */
    @Test
    public void testGetKoneksi() {
        System.out.println("getKoneksi");
        CountryDAO instance = new CountryDAO();
        Connection expResult = null;
        Connection result = instance.getKoneksi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKoneksi method, of class CountryDAO.
     */
    @Test
    public void testSetKoneksi() {
        System.out.println("setKoneksi");
        Connection koneksi = null;
        cdao.setKoneksi(koneksi);
    }
//
    /**
     * Test of getData method, of class CountryDAO.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        String sql = "select * from countries order by 1";
        List<Country> countrys = cdao.getData(sql);
        assertNotNull(countrys);
    }
//
    /**
     * Test of getAllData method, of class CountryDAO.
     */
    @Test
    public void testGetAllData() {
        System.out.println("get All Data Countries");
        List<Country> countrys =  cdao.getAllData();
        assertNotNull(countrys);
    }

    /**
     * Test of eksekusi method, of class CountryDAO.
     */
    @Test
    public void testEksekusi() {
        System.out.println("eksekusi");
        String sql = "select * from countries order by 1";
        boolean expResult = true;
        boolean result = cdao.eksekusi(sql);
        assertEquals(expResult, result);
    }

     /**
     * Test of searchCountry method, of class CountryDAO.
     */
    @Test
    public void testSearchCountry() {
        System.out.println("searchCountry");
        List<Country> countrys = cdao.searchCountry("Country_id", "AB");
        assertNotNull(countrys);
    }
    
    /**
     * Test of simpanCountry method, of class CountryDAO.
     */
    @Test
    public void testSimpanCountry() {
        System.out.println("simpanCountry");
        Region region = new Region(3);
        Country country = new Country("AD", "ADANG", region);
        boolean expResult = true;
        boolean result = cdao.simpanCountry(country);
        assertEquals(expResult, result);
    }

    /**
     * Test of hapusCountry method, of class CountryDAO.
     */
    @Test
    public void testHapusCountry() {
        System.out.println("hapusCountry");
        String id = "ID";
        boolean expResult = true;
        boolean result = cdao.hapusCountry(id);
        assertEquals(expResult, result);
    }
//
    /**
     * Test of updateCountry method, of class CountryDAO.
     */
    @Test
    public void testUpdateCountry() {
        System.out.println("updateCountry");
        Region region = new Region(3);
        Country country = new Country("AB", "ABANG", region);
        boolean expResult = true;
        boolean result = cdao.updateCountry(country);
        assertEquals(expResult, result);
    }
    
}
