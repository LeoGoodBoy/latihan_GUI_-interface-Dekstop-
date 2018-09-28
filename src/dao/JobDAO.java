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

    public JobDAO() {

    }

    public JobDAO(Connection koneksi) {
        this.koneksi = koneksi;
    }

    /**
     * @return the koneksi
     */
    public Connection getKoneksi() {
        return koneksi;
    }

    /**
     * @param koneksi the koneksi to set
     */
    public void setKoneksi(Connection koneksi) {
        this.koneksi = koneksi;
    }

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

    public List<Job> getAllDatas() {
        return this.getData("SELECT * FROM jobs");
    }

    public List<Job> getById(String jobId) {
        return this.getData("SELECT * from jobs where job_id='" + jobId + "'");
    }

    public List<Job> searchJob(String category, String cari) {
        return this.getData("SELECT * FROM jobs WHERE regexp_like(" + category
                + ",'" + cari + "','i') order by 1");
    }

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

    public boolean simpanJob(String jobId, String jobTitle, int minSalary, int maxSalary) {
        return this.eksekusi("INSERT INTO jobs VALUES ('" + jobId + "', '" + jobTitle
                + "', " + minSalary + ", " + maxSalary + ")");
    }

    public boolean deleteJob(String jobId) {
        return this.eksekusi("DELETE FROM jobs WHERE job_id='" + jobId + "'");
    }

    public boolean updateJob(Job job) {
        return this.eksekusi("UPDATE jobs set job_title = '" + job.getJobTitle()
                + "', min_salary = " + job.getMinSalary() + ", max_salary = "
                + job.getMaxSalary() + " where job_id='" + job.getJobId() + "'");
    }
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
