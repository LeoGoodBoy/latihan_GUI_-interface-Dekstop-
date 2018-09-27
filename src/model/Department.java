/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nande
 */
public class Department {
    private int departmentId;
    private String departmentName;
    private Employee employee;
    private Location location;

    public Department() {
    }

    public Department(int departmentId) {
        this.departmentId = departmentId;
    }

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Department(String departmentName, Employee employee, Location location) {
        this.departmentName = departmentName;
        this.employee = employee;
        this.location = location;
    }

    public Department(int departmentId, String departmentName, Employee employee) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employee = employee;
    }

    public Department(int departmentId, String departmentName, Employee employee, Location location) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employee = employee;
        this.location = location;
    }

    /**
     * @return the departmentId
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
     
    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }
       
}
