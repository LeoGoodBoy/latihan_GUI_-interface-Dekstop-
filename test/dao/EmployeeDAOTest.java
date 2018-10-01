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
import model.Job;
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
        List<Employee> employees = edao.getAllData();
        assertNotNull(employees);
    }
    
    @Test
    public void tesSearch(){
        System.out.println("Search Data");
        Connection koneksi = new Koneksi().getKoneksi();
        EmployeeDAO edao = new EmployeeDAO(koneksi);
        List<Employee> employees = edao.search("employee_id", "100");
        assertNotNull(employees);
    }
    
    
//    public void tesAddEmployee(){
//        System.out.println("Add Employee Data");
//        Connection koneksi = new Koneksi().getKoneksi();
//        EmployeeDAO edao = new EmployeeDAO(koneksi);
//        Job job = new Job("IT_PROG");
//        Department department = new Department(60);
//        Employee manager = new Employee(103);
//        Employee employee = new Employee(5000, (float)0.2, "Kurnia", "Sandy", "windingz3", "0878282", "06/25/2018", job, department, manager);
//        assertTrue(edao.simpanEmployee(employee));
//    }
    
    @Test
    public void tesUpdateEmployee(){
        System.out.println("Update Employee Data");
        Connection koneksi = new Koneksi().getKoneksi();
        EmployeeDAO edao = new EmployeeDAO(koneksi);
        Job job = new Job("IT_PROG");
        Department department = new Department(60);
        Employee manager = new Employee(103);
        Employee employee = new Employee(210,  "Kurnia", "Sandy", "windingz2", "0878282", "06/25/2018", job, 6000, (float)0.2, department, manager);
        assertTrue(edao.updateEmployee(employee));
    }
    
    public void tesDelete(){
        System.out.println("Delete Employee Data");
        Connection koneksi = new Koneksi().getKoneksi();
        EmployeeDAO edao = new EmployeeDAO(koneksi);
        assertTrue(edao.deleteEmployee(207));
    }
}
