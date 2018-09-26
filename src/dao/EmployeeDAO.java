/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import model.Department;
import model.Employee;
import model.Job;

/**
 *
 * @author Nande
 */
public class EmployeeDAO {
    private Connection koneksi;

    public EmployeeDAO() {
    }

    public EmployeeDAO(Connection koneksi) {
        this.koneksi = koneksi;
    }
    
    private List<Employee> getData(String query){
        List<Employee> employees = new ArrayList<>();
        try{
            PreparedStatement statement = koneksi.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Employee employee =  new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setHireDate(resultSet.getDate("hire_date").toString());
                employee.setJob(new Job(resultSet.getString("job_id")));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setCommissionPct(resultSet.getFloat("commission_pct"));
                employee.setManager(new Employee(resultSet.getInt("manager_id")));
                employee.setDepartment(new Department(resultSet.getInt("department_id")));
                employees.add(employee);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return employees;
    }
    
    public List<Employee> getAllData(){
        return this.getData("SELECT * FROM employees order by 1");
    }
    
}
