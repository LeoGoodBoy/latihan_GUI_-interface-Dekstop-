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
import model.Location;
import model.Department;
import model.Employee;

/**
 *
 * @author Martin
 */
public class DepartmentDAO {
    private Connection koneksi;

    public DepartmentDAO() {
    }

    public DepartmentDAO(Connection koneksi) {
        this.koneksi = koneksi;
    }
    
    public List<Department> getData(String sql) {
        List<Department> departments = new ArrayList<>();
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            ResultSet resultSet = statment.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setEmployee(new Employee(resultSet.getInt("manager_id")));
                department.setLocation(new Location(resultSet.getInt("location_id")));
                departments.add(department);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return departments;
    }

    /**
     * getAllData digunakan untuk mengambil semua data dari tabel region
     *
     * @return mengirimkan nilai kedalam method getData menggunakan query yang
     * dijadikan parameter
     */
    public List<Department> getAllData() {
        return this.getData("SELECT * FROM DEPARTMENTS ORDER BY 1");
    }
    
    public int autoId() {
        return this.getData("SELECT MAX(region_id)+10 region_id,MAX(region_name)region_name FROM DEPARTMENTS").get(0).getDepartmentId();
    }
    
    public boolean eksekusi(String sql) {
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            statment.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean simpanDepartmnet(Department department){
        return this.eksekusi("INSERT INTO DEPARTMENTS VALUES ('"+department.getDepartmentId()+"','"+department.getDepartmentName()+"',"
                +department.getEmployee().getManager().getEmployeeId()+"','" + department.getLocation().getLocation_id() +"')");
    }
    
    public boolean hapusDepartment(String id){
        return this.eksekusi("DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID ='"+id+"'");
    }
    
    public boolean updateDepartment(Department department) {
        return this.eksekusi("UPDATE DEPARTMENTS SET DEPARTMENT_NAME = '" + department.getDepartmentName()
                + "', MANAGER_ID = '" + department.getEmployee().getManager().getEmployeeId()
                + "', LOCATION_ID = '" + department.getLocation().getLocation_id()
                + "' WHERE DEPARTMENT_ID = '" + department.getDepartmentId() +"'");
    }
    
}
