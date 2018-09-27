/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import model.Country;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class CountryDAOTest {
    
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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.kenapa ya?");
    }

    /**
     * Test of setKoneksi method, of class CountryDAO.
     */
    @Test
    public void testSetKoneksi() {
        System.out.println("setKoneksi");
        Connection koneksi = null;
        CountryDAO instance = new CountryDAO();
        instance.setKoneksi(koneksi);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//
    /**
     * Test of getData method, of class CountryDAO.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        String sql = "select * from employees";
        CountryDAO instance = new CountryDAO();
        List<Country> expResult = null;
        List<Country> result = instance.getData(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of getAllData method, of class CountryDAO.
//     */
//    @Test
//    public void testGetAllData() {
//        System.out.println("getAllData");
//        CountryDAO instance = new CountryDAO();
//        List<Country> expResult = null;
//        List<Country> result = instance.getAllData();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getById method, of class CountryDAO.
//     */
//    @Test
//    public void testGetById() {
//        System.out.println("getById");
//        int id = 0;
//        CountryDAO instance = new CountryDAO();
//        List<Country> expResult = null;
//        List<Country> result = instance.getById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchCountry method, of class CountryDAO.
//     */
//    @Test
//    public void testSearchCountry() {
//        System.out.println("searchCountry");
//        String category = "";
//        String cari = "";
//        CountryDAO instance = new CountryDAO();
//        List<Country> expResult = null;
//        List<Country> result = instance.searchCountry(category, cari);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eksekusi method, of class CountryDAO.
//     */
//    @Test
//    public void testEksekusi() {
//        System.out.println("eksekusi");
//        String sql = "";
//        CountryDAO instance = new CountryDAO();
//        boolean expResult = false;
//        boolean result = instance.eksekusi(sql);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of simpanCountry method, of class CountryDAO.
//     */
//    @Test
//    public void testSimpanCountry() {
//        System.out.println("simpanCountry");
//        Country country = null;
//        CountryDAO instance = new CountryDAO();
//        boolean expResult = false;
//        boolean result = instance.simpanCountry(country);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of hapusCountry method, of class CountryDAO.
//     */
//    @Test
//    public void testHapusCountry() {
//        System.out.println("hapusCountry");
//        String id = "ID";
//        CountryDAO instance = new CountryDAO();
//        boolean expResult = true;
//        boolean result = instance.hapusCountry(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.KENAPA YA?");
//    }
//
//    /**
//     * Test of updateCountry method, of class CountryDAO.
//     */
//    @Test
//    public void testUpdateCountry() {
//        System.out.println("updateCountry");
//        Country country = null;
//        CountryDAO instance = new CountryDAO();
//        boolean expResult = false;
//        boolean result = instance.updateCountry(country);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
