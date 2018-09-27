/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
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
 * @author X453MA
 */
public class JobDAOTest {
    
    public JobDAOTest() {
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
    public void getData() {
        System.out.println("Get Data From Job");
        Connection koneksi = new Koneksi().getKoneksi();
        JobDAO jdao = new JobDAO(koneksi);
        String jobId = "AD_PRES";
        assertNotNull(jdao.getData("SELECT * from jobs where job_id='" + jobId + "'"));
    }
    

    @Test
    public void getAllDatas() {
        System.out.println("Get All Datas From Jobs Table");
        Connection koneksi = new Koneksi().getKoneksi();
        JobDAO jdao = new JobDAO(koneksi);
        assertNotNull(jdao.getAllDatas());
    }

    @Test
    public void getById() {
        System.out.println("Get Data From Jobs Table By job_id");
        Connection koneksi = new Koneksi().getKoneksi();
        JobDAO jdao = new JobDAO(koneksi);
        String jobId = "AC_ACCOUNT";
        assertNotNull(jdao.getById(jobId));
    }

    @Test
    public void searchJob() {
        System.out.println("Search Job By Category");
        Connection koneksi = new Koneksi().getKoneksi();
        JobDAO jdao = new JobDAO(koneksi);
        String category = "job_title";
        String cari = "Sales Manager";
        assertNotNull(jdao.searchJob(category, cari));
    }

    @Test
    public void eksekusi() {
        System.out.println("Eksekusi query boolean");
        Connection koneksi = new Koneksi().getKoneksi();
        JobDAO jdao = new JobDAO(koneksi);
        String sql = "SELECT * FROM JOBS";
        assertTrue(jdao.eksekusi(sql));
    }

    @Test
    public void simpanJob() {
        System.out.println("Insert New Data to Jobs Table");
        Connection koneksi = new Koneksi().getKoneksi();
        JobDAO jdao = new JobDAO(koneksi);
        String jobId = "AOS", jobTitle = "Agent on Site";
        int maxSalary = 13000, minSalary = 15000;
        assertTrue(jdao.simpanJob(jobId, jobTitle, maxSalary, minSalary));
    }

    @Test
    public void deleteJob() {
        System.out.println("Delete Job By Id");
        Connection koneksi = new Koneksi().getKoneksi();
        JobDAO jdao = new JobDAO(koneksi);
        String jobId = "AOI";
        assertTrue(jdao.deleteJob(jobId));
    }

    @Test
    public void updateJob() {
        System.out.println("Update job");
        Connection koneksi = new Koneksi().getKoneksi();
        JobDAO jdao = new JobDAO(koneksi);
        String jobId = "AOA", jobTitle = "Agent of Areas";
        int maxSalary = 1250, minSalary = 14598;
        Job job = new Job(jobId, jobTitle, minSalary, maxSalary);
        assertTrue(jdao.updateJob(job));
    }
}
