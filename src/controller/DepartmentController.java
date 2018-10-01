/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.LocationDAO;
import java.sql.Connection;
import java.util.List;
import javax.swing.JComboBox;
import model.Department;
import model.Employee;
import model.Location;

/**
 *
 * @author Martin
 */
public class DepartmentController {
    private DepartmentDAO ddao;
    private EmployeeDAO edao;
    private LocationDAO ldao;
    private SerbaGunaController serbaGunaController;

    public DepartmentController(Connection koneksi) {
        this.ddao = new DepartmentDAO(koneksi);
        this.edao = new EmployeeDAO(koneksi);
        this.ldao = new LocationDAO(koneksi);
        this.serbaGunaController = new SerbaGunaController();
    }
    
//     public String simpanDepartment(String departmentName, String managerId, String locationId) {
//        Employee managerID = new Employee(Integer.parseInt(managerId));
//        Location locationID = new Location(Integer.parseInt(locationId));
//        Department department = new Department(departmentName, managerID, locationID);
//        return serbaGunaController.getMessage(ddao.simpanDepartment(department));
//    }
//    
//    public String updateDepartment(String departmentId, String departmentName, String managerId, String locationId){
//        Employee managerID = new Employee(Integer.parseInt(managerId));
//        Location locationID = new Location(Integer.parseInt(locationId));
//        Department department = new Department(Integer.parseInt(departmentId), departmentName, managerID, locationID);
//        return serbaGunaController.getMessage(ddao.updateDepartment(department));
//    }
    
    /**
     * Method untuk melakukan simpan atau update data
     * @param departmentId Id department
     * @param departmentName Nama department
     * @param managerId Id manager
     * @param locationId Id location
     * @param isSave kondisi IsSave
     * @return mengembalikan isi pesan simpan atau update
     */
    public String simpanUpdateDepartment(String departmentId, String departmentName, String managerId, String locationId, boolean isSave) {
        Employee managerID = new Employee(Integer.parseInt(managerId.substring(0, 3)));
        Location locationID = new Location(Integer.parseInt(locationId.substring(0, 4)));
        Department department = new Department(Integer.parseInt(departmentId), departmentName, managerID, locationID);
        if (isSave) {
            return serbaGunaController.getMessage(ddao.simpanDepartment(department));
        } else {
            return serbaGunaController.getMessage(ddao.updateDepartment(department));
        }
    }
    
    /**
     * Untuk menampilkan pesan saat mengeksekusi hapus
     * @param departmentId Id department
     * @return mengembalikan isi pesan hapus
     */
    public String hapusDepartment(String departmentId){
        return serbaGunaController.getMessage(ddao.hapusDepartment(departmentId));
    }
    
    /**
     * Menampilkan seluruh data department
     * @return mengembalikan seluruh data department
     */
    public List<Department> viewDepartment(){
        return ddao.getAllData();
    }
    
    /**
     * Untuk melakukan pencarian data department
     * @param category Jenis data atau kolo, yang ingin dicari
     * @param cari data yang ingin dicari
     * @return mengembalikan data yang ingin dicari
     */
    public List<Department> searchDepartment(String category, String cari){
        return ddao.search(category, cari);
    }
    
    /**
     * Untuk melihat nama department
     * @return mengembalikan method getIdName pada departmentDAO
     */    
    public List<Department> viewDepartmentNames(){
        return ddao.getIdName();
    }
    
    /**
     * Memasukan department_name pada combo box
     * @param cmb Objek dari JComboBox
     */
    public  void loadCmbDepartmentName(JComboBox cmb){
        List<Department> departments = ddao.getAllData();
        for (Department department : departments) {
            cmb.addItem(department.getDepartmentName());
        }
    }
    
    /**
     * Memasukan employee_id dan last_name pada combo box
     * @param cmb Objek dari JComboBox
     */
    public  void loadCmbManagerId(JComboBox cmb){
        List<Employee> employees = edao.getIdManagerName();
        for (Employee employee : employees) {
            cmb.addItem(employee.getEmployeeId() + " - " + employee.getLastName());
        }
    }
    
    /**
     * Memasukan location_id dan city pada combo box
     * @param cmb Objek dari JComboBox
     */
    public  void loadCmbLocationId(JComboBox cmb){
        List<Location> locations = ldao.getLocationIdAndCity(0);
        for (Location location : locations) {
            cmb.addItem(location.getLocation_id() + " - " + location.getCity());
        }
    }
    
}
