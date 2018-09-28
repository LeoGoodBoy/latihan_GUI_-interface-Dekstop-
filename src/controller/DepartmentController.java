/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentDAO;
import java.sql.Connection;
import java.util.List;
import model.Department;
import model.Employee;
import model.Location;

/**
 *
 * @author Martin
 */
public class DepartmentController {
    private DepartmentDAO ddao;
    private SerbaGunaController serbaGunaController;

    public DepartmentController(Connection koneksi) {
        this.ddao = new DepartmentDAO(koneksi);
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
    
    public String simpanUpdateDepartment(String departmentId, String departmentName, String managerId, String locationId, boolean isSave) {
        Employee managerID = new Employee(Integer.parseInt(managerId));
        Location locationID = new Location(Integer.parseInt(locationId));
        Department department = new Department(Integer.parseInt(departmentId), departmentName, managerID, locationID);
        if (isSave) {
            return serbaGunaController.getMessage(ddao.simpanDepartment(department));
        } else {
            return serbaGunaController.getMessage(ddao.updateDepartment(department));
        }
    }
    
    public String hapusDepartment(String departmentId){
        return serbaGunaController.getMessage(ddao.hapusDepartment(departmentId));
    }
    
    public List<Department> viewDepartment(){
        return ddao.getAllData();
    }
    
    public List<Department> searchDepartment(String category, String cari){
        return ddao.search(category, cari);
    }
    
    public List<Department> viewDepartmentNames(){
        return ddao.getIdName();
    }
    
}
