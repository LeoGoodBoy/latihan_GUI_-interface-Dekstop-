/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JobDAO;
import java.sql.Connection;
import java.util.List;
import model.Job; 

/**
 * Deklarasi kelas JobController yang berguna sebagai penghubung antara kelas JobDao dan JobView
 * Lalu menginisiasi kelas JobDao dan SerbaGunaController
 * @author 680183
 */
public class JobController {
    private JobDAO jdao;
    private SerbaGunaController serbaGunaController;
    /**
     * Method konstruktor untuk koneksi
     * @param Koneksi 
     */
    public JobController(Connection Koneksi) {
        this.jdao = new JobDAO(Koneksi);
        this.serbaGunaController = new SerbaGunaController();
    }
    /**
     * Sebagai method controller untuk menyimpan data baru ataupun melakukan update data.
     * @param job_id
     * @param job_title
     * @param min_salary
     * @param max_salary
     * @param isEdit
     * @return pesan
     */
    public String saveOrUpdateJob(String job_id, String job_title, String min_salary, String max_salary, boolean isEdit){
        Job job = new Job(job_id, job_title,Integer.parseInt(min_salary),Integer.parseInt(max_salary));
        if (isEdit) return serbaGunaController.getMessage(jdao.updateJob(job));
        else return serbaGunaController.getMessage(jdao.simpanJob(job));     
    }
//    public String simpanJob(String jobId, String jobTitle, int minSalary, int maxSalary){
//        return this.serbaGunaController.getMessage(jdao.simpanJob(jobId, jobTitle, minSalary, maxSalary));
//    }
//    public String updateJob(String jobId, String jobTitle, int minSalary, int maxSalary){
//        Job job = new Job(jobId, jobTitle, minSalary, maxSalary);
//        return this.serbaGunaController.getMessage(jdao.updateJob(job));
//    }
    /**
     * Sebagai method controller untuk menghapus data dari tabel Job
     * @param jobId
     * @return pesan
     */
    public String hapusJob(String jobId){
        return this.serbaGunaController.getMessage(jdao.deleteJob(jobId));
    }
    /**
     * sebagai method controller untuk mengambil data dari tabel lalu menampilkannya
     * @return semua data dari tabel Jobs
     */
    public List<Job> viewJob(){
        return jdao.getAllDatas();
    }
    /**
     * sebagai method controller untuk mencari data job 
     * @param category
     * @param cari
     * @return data tabel Jobs dari hasil pencarian berdasarkan kategori dan kata kunci
     */
    public List<Job> searchJob(String category, String cari){
        return jdao.searchJob(category, cari);
    }
    
}
