/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Job;

/**
 *
 * @author X453MA
 */
public class JobDAO {

    private Connection koneksi;
    
    /**
     * Constructor default kelas JobDAO
     */
    public JobDAO() {

    }

    /**
     * Constructor kelas JobDAO dengan parameter Connection
     * @param koneksi - parameter yang digunakan untuk melakukan koneksi dengan database
     */
    public JobDAO(Connection koneksi) {
        this.koneksi = koneksi;
    }

    /**
     * Fungsi getter untuk mendapatkan nilai koneksi
     * @return the koneksi - mengembalikan nilai koneksi
     */
    public Connection getKoneksi() {
        return koneksi;
    }

    /**
     * Fungsi setter untuk koneksi
     * @param koneksi - parameter untuk set koneksi
     */
    public void setKoneksi(Connection koneksi) {
        this.koneksi = koneksi;
    }

    /**
     * Fungsi untuk mendapatkan data job berupa List sesuai dengan query yang
     * ada pada parameter
     * @param query - paremeter yang dibutuhkan untuk mendapatkan data job
     * sesuai dengan query
     * @return List job - mengembalikan data pada tabel Job berupa List 
     * yang sesuai dengan query
     */
    public List<Job> getData(String query) {
        List<Job> jobs = new ArrayList<>();
        try {
            PreparedStatement statment = koneksi.prepareStatement(query);
            ResultSet resultSet = statment.executeQuery();
            while (resultSet.next()) {
                Job job = new Job();
                job.setJobId(resultSet.getString("job_id"));
                job.setJobTitle(resultSet.getString("job_title"));
                job.setMinSalary(resultSet.getInt("min_salary"));
                job.setMaxSalary(resultSet.getInt("max_salary"));
                jobs.add(job);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return jobs;
    }

    /**
     * Fungsi untuk mendapatkan semua data yang ada pada tabel Job dengan
     * memanggil fungsi getData()
     * @return List job - mendapatkan semua data yang ada pada tabel Job 
     * berupa List Job
     */
    public List<Job> getAllDatas() {
        return this.getData("SELECT * FROM jobs");
    }

    /**
     * Fungsi untuk mendapatkan id pada tabel Job dengan parameter job_id yang
     * ingin dicari
     * @param jobId - parameter yang dibutuhkan untuk mendapatkan data sesuai
     * dengan job_id
     * @return List Job - mendapatkan semua data yang ada pada tabel Job berupa
     * List Job dengan memanggil fungsi getData()
     */
    public List<Job> getById(String jobId) {
        return this.getData("SELECT * from jobs where job_id='" + jobId + "'");
    }

    /**
     * Fungsi untuk mencari data pada tabel Job sesuai dengan category dan cari
     * yang diinputkan
     * @param category - kategori pada tabel Job (job_id, job_title, max_salary
     * atau min_salary)
     * @param cari - kata kunci untuk kategori yang dicari
     * @return mengembalikan nilai List Job sesuai dengan kategori dan kata kunci cari
     */
    public List<Job> searchJob(String category, String cari) {
        return this.getData("SELECT * FROM jobs WHERE regexp_like(" + category
                + ",'" + cari + "','i') order by 1");
    }

    /**
     * Fungsi untuk mendapatkan data job berupa List sesuai dengan query yang
     * ada pada parameter
     * @param sql - paremeter yang dibutuhkan untuk mendapatkan data job
     * sesuai dengan query database
     * @return mengembalikan nilai boolean untuk setiap eksekusi fungsi
     */
    public boolean eksekusi(String sql) {
        boolean hasil = false;
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            statment.executeQuery();
            hasil = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return hasil;
    }

//    public boolean simpanJob(String jobId, String jobTitle, int minSalary, int maxSalary) {
//        return this.eksekusi("INSERT INTO jobs VALUES ('" + jobId + "', '" + jobTitle
//                + "', " + minSalary + ", " + maxSalary + ")");
//    }
    
    /**
     * Fungsi untuk melakukan simpan data job baru pada tabel Job
     * @param job - parameter berupa objek job yang berisi job_id, job_title,
     * min_salary, dan max_salary
     * @return mengembalikan nilai boolean dengan memanggil fungsi eksekusi()
     * dengan parameter sesuai dengan query. Apabila INSERT berhasil dilakukan
     * akan mengembalikan nilai true. Dan apabila tidak berhasil dilakukan maka
     * akan mengembalikan nilai false.
     */
    public boolean simpanJob(Job job) {
        return this.eksekusi("INSERT INTO jobs VALUES ('" + job.getJobId() + "', '" + job.getJobTitle()
                + "', " + job.getMinSalary() + ", " + job.getMaxSalary()+ ")");
    }

    /**
     * Fungsi untuk melakukan delete pada data tabel job sesuai dengan job_id
     * @param jobId - parameter untuk mendapatkan data yang akan delete berdasarkan job_id
     * @return mengembalikan nilai boolean dengan memanggil fungsi eksekusi()
     * dengan parameter sesuai dengan query. Apabila DELETE berhasil dilakukan
     * akan mengembalikan nilai true. Dan apabila tidak berhasil dilakukan maka
     * akan mengembalikan nilai false.
     */
    public boolean deleteJob(String jobId) {
        return this.eksekusi("DELETE FROM jobs WHERE job_id='" + jobId + "'");
    }

    /**
     * Fungsi untuk melakukan update pada data tabel job sesuai dengan job_id
     * @param job - parameter untuk mendapatkan data yang akan update berdasarkan
     * objek job yang dipilih
     * @return mengembalikan nilai boolean dengan memanggil fungsi eksekusi()
     * dengan parameter sesuai dengan query. Apabila UPDATE berhasil dilakukan
     * akan mengembalikan nilai true. Dan apabila tidak berhasil dilakukan maka
     * akan mengembalikan nilai false.
     */
    public boolean updateJob(Job job) {
        return this.eksekusi("UPDATE jobs set job_title = '" + job.getJobTitle()
                + "', min_salary = " + job.getMinSalary() + ", max_salary = "
                + job.getMaxSalary() + " where job_id='" + job.getJobId() + "'");
    }
    
    /**
     * Fungsi untuk mendapatkan nilai job_id pada tabel Job dengan parameter job_title
     * @param jobTitle - parameter untuk mendapatkan data pada tabel job_id
     * @return mengembalikan objek job yang sesuai dengan job_title pada parameter
     */
    public Job getByJobTitle(String jobTitle){
        Job job = new Job();
        String query = "SELECT job_id FROM JOBS where job_title ='" + jobTitle +"'";
        try{
            PreparedStatement statment = koneksi.prepareStatement(query);
            ResultSet resultSet = statment.executeQuery();
            while(resultSet.next()){
                job.setJobId(resultSet.getString("job_id"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return job;
    }
}
