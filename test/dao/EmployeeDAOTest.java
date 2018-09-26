/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import model.Employee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.Koneksi;

/**
 *
 * @author Nande
 */
public class EmployeeDAOTest {
    
    public EmployeeDAOTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void tesGetAllData(){
        System.out.println("Get All Data Employee");
        Connection koneksi = new Koneksi().getKoneksi();
        EmployeeDAO edao = new EmployeeDAO(koneksi);
        List<Employee> employee = edao.getAllData();
        assertNotNull(employee);
    }
}
