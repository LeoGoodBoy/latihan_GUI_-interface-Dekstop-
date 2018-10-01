/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nande
 */
public class Job {

    private String jobId;
    private String jobTitle;
    private int minSalary;
    private int maxSalary;

    /**
     * Constructor default kelas Job
     */
    public Job() {

    }
    
    /**
     * Constructor kelas model Job dengan parameter String jobId
     * @param jobId - parameter jobId pada tabel Job
     */
    public Job(String jobId) {
        this.jobId = jobId;
    }

    /**
     * Constructor kelas model Job dengan parameter jobId dan jobTitle
     * @param jobId - parameter jobId pada tabel Job
     * @param jobTitle  - parameter jobTitle pada tabel Job
     */
    public Job(String jobId, String jobTitle) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
    }

    /**
     * Constructor kelas model Job dengan parameter jobId, jobTitle, minSalary, maxSalary
     * @param jobId - parameter jobId pada tabel Job
     * @param JobTitle - parameter jobTitle pada tabel Job
     * @param minSalary - parameter minSalary pada tabel Job
     * @param maxSalary - parameter maxSalary pada tabel Job
     */
    public Job(String jobId, String JobTitle, int minSalary, int maxSalary) {
        this.jobId = jobId;
        this.jobTitle = JobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    /** Fungsi getter untuk mendapatkan nilai jobId
     * @return the jobId mengembalikan nilai jobId
     */
    public String getJobId() {
        return jobId;
    }

    /** Fungsi setter untuk set nilai dari jobId
     * @param jobId - jobId yang akan di set
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /** Fungsi getter untuk mendapatkan nilai jobTitle
     * @return the jobTitle mengembalikkan nilai jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /** Fungsi setter untuk melakukan set pada nilai jobTitle
     * @param jobTitle - jobTitle yang akan di set
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /** Fungsi getter untuk mendapatkan nilai minSalary
     * @return the minSalary mengembalikan nilai minSalary
     */
    public int getMinSalary() {
        return minSalary;
    }

    /** Fungsi untuk melakukan set pada nilai minSalary
     * @param minSalary - minSalary yang akan di set 
     */
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    /** Fungsi getter untuk mendapatkan nilai maxSalary
     * @return the maxSalary mengembalikan nilai maxSalary
     */
    public int getMaxSalary() {
        return maxSalary;
    }

    /** Fungsi setter untuk melakukan set nilai maxSalary
     * @param maxSalary - maxSalary yang akan di set
     */
    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
}
