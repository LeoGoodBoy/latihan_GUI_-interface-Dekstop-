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
 *
 * @author 680183
 */
public class JobController {
    private JobDAO jdao;
    private SerbaGunaController serbaGunaController;

    public JobController(Connection Koneksi) {
        this.jdao = new JobDAO(Koneksi);
        this.serbaGunaController = new SerbaGunaController();
    }
    
    public String simpanJob(String jobId, String jobTitle, int minSalary, int maxSalary){
        return this.serbaGunaController.getMessage(jdao.simpanJob(jobId, jobTitle, minSalary, maxSalary));
    }
    
    public String updateJob(String jobId, String jobTitle, int minSalary, int maxSalary){
        Job job = new Job(jobId, jobTitle, minSalary, maxSalary);
        return this.serbaGunaController.getMessage(jdao.updateJob(job));
    }
    
    public String hapusJob(String jobId){
        return this.serbaGunaController.getMessage(jdao.deleteJob(jobId));
    }
    
    public List<Job> viewJob(){
        return jdao.getAllDatas();
    }
    
    public List<Job> searchJob(String category, String cari){
        return jdao.searchJob(category, cari);
    }
    
}
