/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private JobDAO jdao;
    private DepartmentDAO ddao;

    public EmployeeDAO() {
    }

    public EmployeeDAO(Connection koneksi) {
        this.koneksi = koneksi;
    }

    private Employee getDataIdName(String query) {
        Employee employee = new Employee(); 
        try{
            try (PreparedStatement statement = koneksi.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    employee.setEmployeeId(resultSet.getInt("employee_id"));
                    employee.setLastName(resultSet.getString("last_name"));
                }
                resultSet.close();
                statement.close();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return employee;
    }

    private List<Employee> getData(String query) {
        List<Employee> employees = new ArrayList<>();
        try {
            try (PreparedStatement statement = koneksi.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    jdao = new JobDAO(koneksi);
                    
                    String jobId = jdao.getById(resultSet.getString("job_id")).get(0).getJobId();
                    String jobTitle = jdao.getById(resultSet.getString("job_id")).get(0).getJobTitle();
                    Job job = new Job(jobId, jobTitle);
                    int managerId = 0;
                    String lastName = "";
                    int lengt = this.getById(resultSet.getInt("manager_id")).size();
                    if (lengt > 0) {
                        managerId = this.getIdName(resultSet.getInt("manager_id")).getEmployeeId();
                        lastName = this.getIdName(resultSet.getInt("manager_id")).getLastName();
                    }
                    Employee manager;
                    
                    if (managerId == 0) {
                        manager = new Employee();
                    } else {
                        manager = new Employee(managerId, lastName);
                    }
                    
                    ddao = new DepartmentDAO(koneksi);
                    
                    int dId = 0;
                    String dName = "";
                    lengt = ddao.getIdNameById(resultSet.getInt("department_id")).size();
                    if(lengt > 0){
                        dId = ddao.getIdNameById(resultSet.getInt("department_id")).get(0).getDepartmentId();
                        dName = ddao.getIdNameById(resultSet.getInt("department_id")).get(0).getDepartmentName();
                    }
                        
                    Department department;
                    if(dId == 0) department = new Department();
                    else department = new Department(dId, dName);
                    
                    employee.setEmployeeId(resultSet.getInt("employee_id"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setEmail(resultSet.getString("email"));
                    employee.setPhoneNumber(resultSet.getString("phone_number"));
                    employee.setHireDate(resultSet.getDate("hire_date").toString());
                    employee.setJob(job);
                    employee.setSalary(resultSet.getInt("salary"));
                    employee.setCommissionPct(resultSet.getFloat("commission_pct"));
                    employee.setManager(manager);
                    
                    employee.setDepartment(department);
                    employees.add(employee);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return employees;
    }

    public List<Employee> getAllData(){
        return this.getData("SELECT * FROM employees order by 1");
    }

    private boolean eksekusi(String sql) {
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

    public int getNextId(){
        int id = this.getData("SELECT * FROM employees where rownum = 1 order by 1 desc").get(0).getEmployeeId();
        id++;
        return id;
    }

    public List<Employee> getById(int id)  {
        return this.getData("select * from employees where employee_id = " + id);
    }
    
    public Employee getIdName(int employeeId){
        return this.getDataIdName("select * from employees where employee_id = " + employeeId);
    }

    public boolean simpanEmployee(Employee employee) {
        String query = "INSERT INTO employees VALUES(" + employee.getEmployeeId() + ", '"
                + employee.getFirstName() + "', '" + employee.getLastName() + "', '"
                + employee.getEmail() + "', '" + employee.getPhoneNumber() + "',to_date('"
                + employee.getHireDate() + "', 'mm/dd/yyyy'), '" + employee.getJob().getJobId() + "', "
                + employee.getSalary() + ", " + employee.getCommissionPct() + ", "
                + employee.getManager().getEmployeeId() + ", "
                + employee.getDepartment().getDepartmentId() + ")";
        return this.eksekusi(query);
    }

    public boolean updateEmployee(Employee employee) {
        String query = "UPDATE employees SET first_name = '"
                + employee.getFirstName() + "', last_name = '" + employee.getLastName() + "',"
                + "email = '" + employee.getEmail() + "', phone_number = '" + employee.getPhoneNumber() + "', "
                + "hire_date = to_date('" + employee.getHireDate() + "', 'mm/dd/yyyy') , job_id = '" + employee.getJob().getJobId() + "', "
                + "salary = " + employee.getSalary() + ", commission_pct =  " + employee.getCommissionPct() + ", "
                + "manager_id = " + employee.getManager().getEmployeeId() + ", department_id = "
                + employee.getDepartment().getDepartmentId() + " WHERE employee_id = " + employee.getEmployeeId();
        return this.eksekusi(query);
    }

    public boolean deleteEmployee(int id) {
        return this.eksekusi("DELETE FROM employees WHERE employee_id =" + id);
    }

    public List<Employee> search(String category, String cari) {
        return this.getData("select * from employees where regexp_like(" + category + ",'" + cari + "','i') order by 1");
    }
    public Employee getByLastName(String employeeId, String lastName){
        Employee employee = new Employee();
        String query = "SELECT employee_id FROM employees where employee_id = "+ employeeId +" and last_name ='" + lastName +"'";
        try{
            PreparedStatement statment = koneksi.prepareStatement(query);
            ResultSet resultSet = statment.executeQuery();
            while(resultSet.next()){
                employee.setEmployeeId(resultSet.getInt("employee_id"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return employee;
    }
    public List<Employee> getIdManagerName(){
        List<Employee> employees = new ArrayList<>();
        try{
            try (PreparedStatement statement = koneksi.prepareStatement("SELECT employee_id, last_name FROM employees"); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setEmployeeId(resultSet.getInt("employee_id"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employees.add(employee);
                }
                resultSet.close();
//                statement.close();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return employees;
    }
}
