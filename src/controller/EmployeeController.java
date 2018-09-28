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
    private String temp;

    public EmployeeController() {
    }

    public EmployeeController(Connection koneksi) {
        this.koneksi = koneksi;
        this.edao = new EmployeeDAO(koneksi);
        this.serbaGunaController = new SerbaGunaController();
        this.jdao = new JobDAO(koneksi);
        this.ddao = new DepartmentDAO(koneksi);
    }

    public List<Employee> viewEmployee() {
        return edao.getAllData();
    }

    public List<Employee> searchEmployee(String category, String cari) {
        return edao.search(category, cari);
    }

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

    public String hapusEmployee(String employeeId) {
        return this.serbaGunaController.getMessage(edao.deleteEmployee(Integer.parseInt(employeeId)));
    }

    public void loadCmbManager(JComboBox cmb) {
        List<Employee> employees = edao.getAllData();
        for (Employee employee : employees) {
            cmb.addItem(employee.getEmployeeId() + " - " + employee.getLastName());
        }
    }

    public void loadCmbJob(JComboBox cmb) {
        jdao = new JobDAO(koneksi);
        List<Job> jobs = jdao.getAllDatas();
        for (Job job : jobs) {
            cmb.addItem(job.getJobId() + " - " + job.getJobTitle());
        }
    }

    public void loadCmbDepartment(JComboBox cmb) {
        ddao = new DepartmentDAO(koneksi);
        List<Department> departments = ddao.getAllData();
        for (Department department : departments) {
            cmb.addItem(department.getDepartmentId() + " - " + department.getDepartmentName());
        }
    }
    public int getNextId(){
        return edao.getNextId();
    }
    
    public List<Employee> viewManager(){
        return edao.getIdManagerName();
    }
    
    public int getIdManager(String employeeId, String lastName){
        return edao.getByLastName(employeeId, lastName).getEmployeeId();
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
    
    
}
