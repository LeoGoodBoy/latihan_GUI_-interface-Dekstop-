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
    
    private boolean eksekusi(String sql){
        boolean hasil = false;
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            statment.executeQuery();
            hasil = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return hasil;
    }
    
    private int getNextId(){
        int id = this.getData("SELECT * FROM employees where rownum = 1 order by 1 desc").get(0).getEmployeeId();
        id++;
        return id;
    }
    
    public boolean simpanEmployee(Employee employee){
        String query = "INSERT INTO employees VALUES(" + this.getNextId() + ", '" 
                + employee.getFirstName() +"', '" + employee.getLastName() + "', '"
                + employee.getEmail() + "', '"+ employee.getPhoneNumber() + "',to_date('"
                + employee.getHireDate() + "', 'mm/dd/yyyy'), '" + employee.getJob().getJobId() +"', "
                + employee.getSalary() + ", " + employee.getCommissionPct() + ", " 
                + employee.getManager().getEmployeeId() + ", " 
                + employee.getDepartment().getDepartmentId()+ ")";
        
        return this.eksekusi(query);
    }
    
    public boolean updateEmployee(Employee employee){
        String query = "UPDATE employees SET first_name = '" 
                + employee.getFirstName() +"', last_name = '" + employee.getLastName() + "',"
                + "email = '" + employee.getEmail() + "', phone_number = '"+ employee.getPhoneNumber() + "', "
                + "hire_date = to_date('" + employee.getHireDate() + "', 'mm/dd/yyyy') , job_id = '" + employee.getJob().getJobId() +"', "
                + "salary = "+ employee.getSalary() + ", commission_pct =  " + employee.getCommissionPct() + ", " 
                + "manager_id = " +employee.getManager().getEmployeeId() + ", department_id = " 
                + employee.getDepartment().getDepartmentId() + " WHERE employee_id = " + employee.getEmployeeId();
        return this.eksekusi(query);
    }
    
    public boolean deleteEmployee(int id){
        return this.eksekusi("DELETE FROM employees WHERE employee_id =" + id);
    }
    
    public List<Employee> search(String category, String cari) {
        return this.getData("select * from employees where regexp_like(" + category + ",'" + cari + "','i') order by 1");
    }
}
