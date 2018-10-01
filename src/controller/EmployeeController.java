/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.JobDAO;
import java.sql.Connection;
import java.util.List;
import javax.swing.JComboBox;
import model.Department;
import model.Employee;
import model.Job;

/**
 *
 * @author Nande
 */
public class EmployeeController {

    EmployeeDAO edao;
    SerbaGunaController serbaGunaController;
    private JobDAO jdao;
    Connection koneksi;
    JobController jobController;
    DepartmentController departmentController;
    private DepartmentDAO ddao;

    public EmployeeController() {
    }

    
    public EmployeeController(Connection koneksi) {
        this.koneksi = koneksi;
        this.edao = new EmployeeDAO(koneksi);
        this.serbaGunaController = new SerbaGunaController();
        this.jdao = new JobDAO(koneksi);
        this.ddao = new DepartmentDAO(koneksi);
    }

    /**
     * Digunakan untuk mendapatkan semua data Employee
     * @return List Employee
     */
    public List<Employee> viewEmployee() {
        return edao.getAllData();
    }

    /**
     * Digunakan untuk mencari data Employee berdasarkan kolom yang dipilih dan kata pencariannya
     * @param category nama kolom yang dipilih
     * @param cari kata pencariannya
     * @return List Employee
     */
    public List<Employee> searchEmployee(String category, String cari) {
        return edao.search(category, cari);
    }

    /**
     * Digunakan untuk menyimpan data Employee baru
     * @param employeeId employeeId 
     * @param firstName firstName
     * @param lastName lastName
     * @param email email
     * @param phoneNumber phoneNumber
     * @param hireDate  hireDate
     * @param jobId nama job
     * @param salary salary
     * @param commission commission
     * @param managerId id manager
     * @param departmentId nama department
     * @param isUpdate checker is update
     * @return Sukses atau Gagal
     */
    public String simpanOrUpdateEmployee(String employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId, String salary, String commission, String managerId, String departmentId,  boolean isUpdate) {
        Job job = jdao.getByJobTitle(jobId);
        Employee manager = new Employee(Integer.parseInt(managerId));
        Department department = ddao.getByDepartmentName(departmentId);

        Employee employee = new Employee(Integer.parseInt(employeeId), firstName, lastName, email, phoneNumber, hireDate, job, Integer.parseInt(salary), Float.parseFloat(commission), department, manager);
        if (isUpdate) {
            return this.serbaGunaController.getMessage(edao.updateEmployee(employee));
        } else {
            return this.serbaGunaController.getMessage(edao.simpanEmployee(employee));
        }
    }

//    public String updateEmployee(String employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId, String salary, String commission, String departmentId, String managerId) {
//        
//        Job job = jdao.getByJobTitle(jobId);
//        Employee manager = edao.getByLastName(lastName);
//        Department department = ddao.getByDepartmentName(departmentId);
//        Employee employee = new Employee(Integer.parseInt(employeeId), firstName, lastName, email, phoneNumber, hireDate, job, Integer.parseInt(salary), Float.parseFloat(commission), department, manager);
//        return this.serbaGunaController.getMessage(edao.updateEmployee(employee));
//    }

    /**
     * Digunakan untuk menghapus sebuah data employee
     * @param employeeId employeeId
     * @return Sukses atau Gagal
     */
    public String hapusEmployee(String employeeId) {
        return this.serbaGunaController.getMessage(edao.deleteEmployee(Integer.parseInt(employeeId)));
    }

    /**
     * Diguanakan untuk mengisi model dari cmbManager
     * @param cmb combo box manager
     */
    public void loadCmbManager(JComboBox cmb) {
        List<Employee> employees = edao.getAllData();
        for (Employee employee : employees) {
            cmb.addItem(employee.getEmployeeId() + " - " + employee.getLastName());
        }
    }

    /**
     * Digunakan untuk mengisi model dari cmbJob
     * @param cmb combo box job
     */
    public void loadCmbJob(JComboBox cmb) {
        jdao = new JobDAO(koneksi);
        List<Job> jobs = jdao.getAllDatas();
        for (Job job : jobs) {
            cmb.addItem(job.getJobId() + " - " + job.getJobTitle());
        }
    }

    /**
     * Digunakan untuk mengisi model dari cmbDepartment
     * @param cmb combo box department
     */
    public void loadCmbDepartment(JComboBox cmb) {
        ddao = new DepartmentDAO(koneksi);
        List<Department> departments = ddao.getAllData();
        for (Department department : departments) {
            cmb.addItem(department.getDepartmentId() + " - " + department.getDepartmentName());
        }
    }
    
    /**
     * Digunakan untuk mendapatkan employee_id selanjutnya dari yang sudah ada
     * @return id baru
     */
    public int getNextId(){
        return edao.getNextId();
    }
    
    /**
     * Digunakan untuk menampilkan semua data Employee
     * @return List Employee
     */
    public List<Employee> viewManager(){
        return edao.getIdManagerName();
    }
    
    /**
     * Digunakan untuk mendapatkan employee_id dari manager
     * @param employeeId employeeId
     * @param lastName lastname
     * @return untuk get last name
     */
    public int getIdManager(String employeeId, String lastName){
        return edao.getByLastName(employeeId, lastName).getEmployeeId();
    }
    
}
