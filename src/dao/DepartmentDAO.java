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
import model.Region;

/**
 *
 * @author Martin
 */
public class DepartmentDAO {

    private Connection koneksi;
    private LocationDAO ldao;
    private EmployeeDAO edao;

    public DepartmentDAO() {
    }

    public DepartmentDAO(Connection koneksi) {
        this.koneksi = koneksi;
        this.ldao = new LocationDAO(koneksi);
        this.edao = new EmployeeDAO(koneksi);
    }
    
/**
 * Mengambil data yang diinginkan dari database
 * @param sql query yang ingin dijalankan
 * @return list deparment
 */
    public List<Department> getData(String sql) {
        List<Department> departments = new ArrayList<>();
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            ResultSet resultSet = statment.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                int managerId = resultSet.getInt("MANAGER_ID");
                if (managerId != 0) {
                    Employee employee = edao.getById(managerId).get(0);
                    department.setEmployee(employee);
                }
                Location location = ldao.getById(resultSet.getInt("location_id")).get(0);
                department.setLocation(location);
                departments.add(department);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return departments;
    }

    /**
     * Mengambil data berdasarkan Id dari database
     * @param sql query yang ingin dijalankan
     * @return list department
     */
    public List<Department> getDataById(String sql) {
        List<Department> departments = new ArrayList<>();
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            ResultSet resultSet = statment.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                departments.add(department);
            }
            resultSet.close();
            statment.close();
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

    /**
     * Melakukan penambahan Id berdasarkan Id terakhir
     * @return mengembalikan query untuk dijalankan di getData
     */
    public int autoId() {
        return this.getData("SELECT MAX(department_id)+10 department_id, MAX(department_name) department_name, MAX(manager_id) manager_id, MAX(location_id) location_id FROM DEPARTMENTS").get(0).getDepartmentId();
    }

    /**
     * untuk mengeksekusi query
     * @param sql query yang ingin dijalankan
     * @return boolean
     */
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

    /**
     * Mengambil data berdasarkan Id
     * @param id Id yang ingin dicari
     * @return mengembalikan query untuk mencari data berdasarkan Id ke method eksekusi
     */
    public List<Department> getById(int id) {
        return this.getData("select * from departments where department_id = " + id + "");
    }

    /**
     * Mengambil Name berdasarkan Id
     * @param id Id yang ingin dicari
     * @return mengembaikan query untuk mencari Name berdasarkan Id ke method eksekusi
     */
    public List<Department> getIdNameById(int id) {
        return this.getDataById("SELECT department_id, department_name from departments where department_id = " + id);
    }

    /**
     * Untuk menyimpan data yang dimasukan user
     * @param department Objek dari department
     * @return mengembalikan query untuk menyimpan data ke method eksekusi
     */
    public boolean simpanDepartment(Department department) {
        int id = autoId();
        return this.eksekusi("INSERT INTO DEPARTMENTS VALUES (" + id + ",'" + department.getDepartmentName() + "',"
                + department.getEmployee().getEmployeeId() + "," + department.getLocation().getLocation_id() + ")");
    }

    /**
     * Untuk menghapus data
     * @param id Id yang ingin dicari
     * @return mengembalikan query untuk menghapus berdasarkan Id ke method eksekusi
     */
    public boolean hapusDepartment(String id) {
        return this.eksekusi("DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID ='" + id + "'");
    }

    /**
     * Untuk memperbarui data yang ada
     * @param department Objek dari department
     * @return mengembalikan query untuk memperbarui data ke method eksekusi
     */
    public boolean updateDepartment(Department department) {
        return this.eksekusi("UPDATE DEPARTMENTS SET DEPARTMENT_NAME = '" + department.getDepartmentName()
                + "', MANAGER_ID = " + department.getEmployee().getEmployeeId()
                + ", LOCATION_ID = " + department.getLocation().getLocation_id()
                + " WHERE DEPARTMENT_ID = " + department.getDepartmentId());
    }

    /**
     * Untuk melakukan pencarian pada data
     * @param category jenis kolom atau data yang ingin dicari
     * @param cari data yang ingin dicari
     * @return mengembalikan query untuk melakukan pencarian data ke method eksekusi
     */
    public List<Department> search(String category, String cari) {
        return this.getData("SELECT * FROM DEPARTMENTS WHERE REGEXP_LIKE(" + category + ",'" + cari + "','i') order by 1");
    }
    
    
    /**
     * Mengambil department_id dari database berdasarkan department_name
     * @param departmentName nama department yang ingin dicari
     * @return mengembalikan objek department
     */
    public Department getByDepartmentName(String departmentName){
        Department department = new Department();
        String query = "SELECT department_id FROM departments where department_name ='" + departmentName +"'";
        try{
            PreparedStatement statment = koneksi.prepareStatement(query);
            ResultSet resultSet = statment.executeQuery();
            while(resultSet.next()){
                department.setDepartmentId(resultSet.getInt("department_id"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return department;
    }
    
    /**
     * Mengambil Id dan Name dari database
     * @return mengembalikan query untuk mengambil Id dan Name ke method eksekusi
     */
    public List<Department> getIdName(){
        return this.getDataById("SELECT department_id, department_name FROM departments");
    }
   
}
