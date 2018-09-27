/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmployeeDAO;
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
    
    public List<Employee> viewEmployee(){
        return edao.getAllData();
    }
    
    public List<Employee> searchEmployee(String category, String cari){
        return edao.search(category, cari);
    }
    
    public String simpanEmployee(String salary, String commission, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId, String departmentId, String managerId){
        Job job = new Job(jobId);
        Department department = new Department(Integer.parseInt(departmentId));
        Employee manager = new Employee(Integer.parseInt(managerId));
        Employee employee = new Employee(Integer.parseInt(salary), Float.parseFloat(commission), firstName, lastName, email, phoneNumber, hireDate, job, department, manager);
        return this.serbaGunaController.getMessage(edao.simpanEmployee(employee));
    }
    
    
    
}
