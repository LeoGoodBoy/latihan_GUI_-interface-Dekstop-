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
    private int departmentId,managerId,locationId;
    private String departmentName;

    public Department() {
    }

    public Department(int departmentId) {
        this.departmentId = departmentId;
    }

    public Department(int departmentId, int managerId) {
        this.departmentId = departmentId;
        this.managerId = managerId;
    }

    public Department(int departmentId, int managerId, int locationId) {
        this.departmentId = departmentId;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    public Department(int departmentId, int managerId, int locationId, String departmentName) {
        this.departmentId = departmentId;
        this.managerId = managerId;
        this.locationId = locationId;
        this.departmentName = departmentName;
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
     * @return the managerId
     */
    public int getManagerId() {
        return managerId;
    }

    /**
     * @param managerId the managerId to set
     */
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    /**
     * @return the locationId
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
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
       
}
