/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
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
public class RegionDAOTest {
    
    Connection koneksi = new Koneksi().getKoneksi();
    RegionDAO rdao = new RegionDAO(koneksi);
    
    public RegionDAOTest() {
        
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
     * Test of getData method, of class RegionDAO.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        String sql = "select * from regions order by 1";  
        List<Region> regions = rdao.getData(sql);
        assertNotNull(regions);
    }

    /**
     * Test of getAllData method, of class RegionDAO.
     */
    @Test
    public void testGetAllData() {
        System.out.println("getAllData");
        List<Region> result = rdao.getAllData();
        assertNotNull(result);
    }
//
    /**
     * Test of getById method, of class RegionDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 2;
        List<Region> result = rdao.getById(id);
        assertNotNull(result);
    }
//
    /**
     * Test of search method, of class RegionDAO.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        List<Region> result = rdao.search("Region_name", "me");
        assertNotNull(result);
    }
//
    /**
     * Test of eksekusi method, of class RegionDAO.
     */
    @Test
    public void testEksekusi() {
        System.out.println("eksekusi");
        String sql = "select * from regions order by 1";
        RegionDAO instance = new RegionDAO();
        boolean expResult = true;
        boolean result = rdao.eksekusi(sql);
        assertNotNull(result);
    }
//
    /**
     * Test of autoId method, of class RegionDAO.
     */
    @Test
    public void testAutoId() {
        System.out.println("autoId");
        int expResult = 0;
        int result = rdao.autoId();
        assertNotNull(result);
    }
//
    /**
     * Test of simpanRegion method, of class RegionDAO.
     */
    @Test
    public void testSimpanRegion() {
        System.out.println("simpanRegion");
        boolean expResult = true;
        boolean result = rdao.simpanRegion("Kamboja");
        assertNotNull(result);
    }
//
    /**
     * Test of updateRegion method, of class RegionDAO.
     */
    @Test
    public void testUpdateRegion() {
        System.out.println("updateRegion");
        Region region = new Region(5, "Sinagakure");
        boolean result = rdao.updateRegion(region);
        assertTrue(result);
    }
//
    /**
     * Test of hapusRegion method, of class RegionDAO.
     */
    @Test
    public void testHapusRegion() {
        System.out.println("hapusRegion");
        int id = 0;
        boolean result = rdao.hapusRegion(id);
        assertTrue(result);
    }
    
}
