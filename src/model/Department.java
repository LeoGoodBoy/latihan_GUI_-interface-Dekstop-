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

    /**
     * constructor dari kelas department yang tidak memiliki parameter
     */
    public Department() {
    }

    /**
     * constructor dari kelas department yang memiliki parameter departmentId
     * @param departmentId parameter bertipe integer
     */
    public Department(int departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * constructor dari kelas department yang memiliki parameter departmentId dan departmentName
     * @param departmentId parameter bertipe integer
     * @param departmentName parameter bertipe string
     */
    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    /**
     * constructor dari kelas department yang memiliki parameter departmentName, employee, location
     * @param departmentName parameter bertipe String
     * @param employee parameter bertipe object
     * @param location parameter bertipe object
     */
    public Department(String departmentName, Employee employee, Location location) {
        this.departmentName = departmentName;
        this.employee = employee;
        this.location = location;
    }

    /**
     * constructor dari kelas department yang memiliki parameter departmentId, departmentName, employee
     * @param departmentId parameter bertipe integer
     * @param departmentName parameter bertipe string
     * @param employee parameter bertipe object
     */
    public Department(int departmentId, String departmentName, Employee employee) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employee = employee;
    }

    /**
     * constructor dari kelas department yang memiliki parameter departmentId, departmentName, employee, location
     * @param departmentId parameter bertipe integer
     * @param departmentName parameter bertipe string 
     * @param employee parameter beripe object
     * @param location parameter bertipe object
     */
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
