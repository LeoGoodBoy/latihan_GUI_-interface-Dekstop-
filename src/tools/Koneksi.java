/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author chochong
 */
public class Koneksi {
    private Connection koneksi = null;
    
    public Connection getKoneksi(){
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setServerName("localhost");
            ods.setDriverType("thin");
            ods.setPortNumber(1521);
            ods.setServiceName("XE");
            ods.setUser("system");
            ods.setPassword("eksis234");
            koneksi = ods.getConnection();
            koneksi.createStatement().executeQuery("alter session set current_schema=hr");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }  
        return koneksi;
        
    }
}
