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
    private DepartmentDAO ddao;

    public EmployeeController() {
    }

    public EmployeeController(Connection koneksi) {
        this.koneksi = koneksi;
        this.edao = new EmployeeDAO(koneksi);
        this.serbaGunaController = new SerbaGunaController();
    }

    public List<Employee> viewEmployee() {
        return edao.getAllData();
    }

    public List<Employee> searchEmployee(String category, String cari) {
        return edao.search(category, cari);
    }

    public String simpanOrUpdateEmployee(String employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId, String salary, String commission, String departmentId, String managerId, boolean isUpdate) {
        Job job = new Job(jobId);
        Department department = new Department(Integer.parseInt(departmentId));
        Employee manager = new Employee(Integer.parseInt(managerId));

        Employee employee = new Employee(Integer.parseInt(employeeId), firstName, lastName, email, phoneNumber, hireDate, job, Integer.parseInt(salary), Float.parseFloat(commission), department, manager);
        if (isUpdate) {
            return this.serbaGunaController.getMessage(edao.updateEmployee(employee));
        } else {
            return this.serbaGunaController.getMessage(edao.simpanEmployee(employee));
        }
    }

    public String updateEmployee(String employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId, String salary, String commission, String departmentId, String managerId) {
        Job job = new Job(jobId);
        Department department = new Department(Integer.parseInt(departmentId));
        Employee manager = new Employee(Integer.parseInt(managerId));

        Employee employee = new Employee(Integer.parseInt(employeeId), firstName, lastName, email, phoneNumber, hireDate, job, Integer.parseInt(salary), Float.parseFloat(commission), department, manager);
        return this.serbaGunaController.getMessage(edao.updateEmployee(employee));
    }

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

}
