/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmployeeDAO;
import java.sql.Connection;
import java.util.List;
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

    public EmployeeController() {
    }

    public EmployeeController(Connection koneksi) {
        this.edao = new EmployeeDAO(koneksi);
        this.serbaGunaController = new SerbaGunaController();
    }
    
    public List<Employee> viewEmployee(){
        return edao.getAllData();
    }
    
    public List<Employee> searchEmployee(String category, String cari){
        return edao.search(category, cari);
    }
    
    public String simpanEmployee( String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId, String salary, String commission, String departmentId, String managerId){
        Job job = new Job(jobId);
        Department department = new Department(Integer.parseInt(departmentId));
        Employee manager = new Employee(Integer.parseInt(managerId));
        Employee employee = new Employee(Integer.parseInt(salary), Float.parseFloat(commission), firstName, lastName, email, phoneNumber, hireDate, job, department, manager);
        return this.serbaGunaController.getMessage(edao.simpanEmployee(employee));
    }
    
    public String updateEmployee(String employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId,String salary, String commission, String departmentId, String managerId){
        Job job = new Job(jobId);
        Department department = new Department(Integer.parseInt(departmentId));
        Employee manager = new Employee(Integer.parseInt(managerId));
        String[]  dates = new String[3];
        dates = hireDate.split("-");
//        hireDate = dates[1] + "/" + dates[2] + "/" + dates[0];
        Employee employee = new Employee(Integer.parseInt(employeeId), firstName, lastName, email, phoneNumber, hireDate, job , Integer.parseInt(salary), Float.parseFloat(commission), department, manager);
        return this.serbaGunaController.getMessage(edao.updateEmployee(employee));
    }
    
    public String hapusEmployee(String employeeId){
        return this.serbaGunaController.getMessage(edao.deleteEmployee(Integer.parseInt(employeeId)));
    }
    
}
