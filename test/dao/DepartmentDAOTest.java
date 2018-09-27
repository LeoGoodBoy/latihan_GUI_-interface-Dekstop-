/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import model.Department;
import model.Employee;
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
public class DepartmentDAOTest {
    
    Connection koneksi = new Koneksi().getKoneksi();
    DepartmentDAO dAO = new DepartmentDAO(koneksi);
    
    public DepartmentDAOTest() {
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
     * Test of getData method, of class DepartmentDAO.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        String sql = "SELECT * FROM DEPARTMENTS ORDER BY 1";        
        List<Department> departments = dAO.getData(sql);
        assertNotNull(departments);
    }

    /**
     * Test of getAllData method, of class DepartmentDAO.
     */
    @Test
    public void testGetAllData() {
        System.out.println("getAllData");
        List<Department> departments = dAO.getAllData();
        assertNotNull(departments);
    }
//
    /**
     * Test of autoId method, of class DepartmentDAO.
     */
    @Test
    public void testAutoId() {
        System.out.println("autoId");
        int result = dAO.autoId();
        assertNotNull(result);
    }
//
    /**
     * Test of eksekusi method, of class DepartmentDAO.
     */
    @Test
    public void testEksekusi() {
        System.out.println("eksekusi");
        String sql = "";
        boolean expResult = true;
        boolean result = dAO.eksekusi(sql);
        assertNotNull(result);
    }
//
    /**
     * Test of simpanDepartment method, of class DepartmentDAO.
     */
    @Test
    public void testSimpanDepartment() {
        System.out.println("simpanDepartment");
        Employee employee = new Employee(100);
        Location location = new Location(1700);
        Department department = new Department("Marketing", employee, location);
       // boolean expResult = true;
        boolean result = dAO.simpanDepartment(department);
        //assertEquals(expResult, result);
        assertTrue(result);
    }

    /**
     * Test of hapusDepartment method, of class DepartmentDAO.
     */
    @Test
    public void testHapusDepartment() {
        System.out.println("hapusDepartment");
        String id = "";
        boolean expResult = true;
        boolean result = dAO.hapusDepartment(id);
        assertNotNull(result);
    }
//
    /**
     * Test of updateDepartment method, of class DepartmentDAO.
     */
    @Test
    public void testUpdateDepartment() {
        System.out.println("updateDepartment");
        Employee employee = new Employee(100);
        Location location = new Location(1700);
        Department department = new Department("Marketing", employee, location);
        boolean result = dAO.updateDepartment(department);
        assertTrue(result);
    }
//
    /**
     * Test of search method, of class DepartmentDAO.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        List<Department> result = dAO.search("Department_name", "a");
        assertNotNull(result);
    }
    
}
