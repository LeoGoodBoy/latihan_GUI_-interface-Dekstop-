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
     * @param Koneksi import dari Connection
     */
    public JobController(Connection Koneksi) {
        this.jdao = new JobDAO(Koneksi);
        this.serbaGunaController = new SerbaGunaController();
    }
    /**
     * Sebagai method controller untuk menyimpan data baru ataupun melakukan update data.
     * @param job_id get job id tipe data String
     * @param job_title get job title tipe data String
     * @param min_salary get min salary tipe data String
     * @param max_salary get max salary tipe data String
     * @param isEdit kondisi, tipe data Boolean
     * @return pesan, mengembalikan isi pesan save atau update
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
     * @param jobId get jobid tipe data String
     * @return pesan, mengembalikan isi pesan hapus
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
     * @param category get kategori tipe data String
     * @param cari get cari dari search tipe data String
     * @return data tabel Jobs dari hasil pencarian berdasarkan kategori dan kata kunci
     */
    public List<Job> searchJob(String category, String cari){
        return jdao.searchJob(category, cari);
    }
    
}
