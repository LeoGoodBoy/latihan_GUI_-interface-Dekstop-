/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author chochong
 */
public class SerbaGunaController { 
    public String getMessage(boolean cek){
        String pesan = "Gagal";
        if (cek)pesan = "Berhasil";
        
        return pesan;
    }
}
