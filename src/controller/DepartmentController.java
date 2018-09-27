/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentDAO;
import java.sql.Connection;

/**
 *
 * @author Martin
 */
public class DepartmentController {
    private DepartmentDAO ddao;

    public DepartmentController(Connection koneksi) {
        this.ddao = new DepartmentDAO(koneksi);
    }
    
    
}
