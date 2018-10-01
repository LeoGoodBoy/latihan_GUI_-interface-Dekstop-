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
import model.Region;

/**
 *
 * @author chochong
 */
public class RegionDAO {

    private Connection koneksi;

    /**
     * adalah constructor dari kelas RegionDAO yang tidak memiliki parameter
     */
    public RegionDAO() {
    }

    /**
     * adalah constructor daru kelas RegionDAO yang memiliki parameter bertipe koneksi
     * @param koneksi adalah paramter lokal yang digunakan untuk menampung nilai
     * yang akan dikirim kedalam method, dan akan digunakan untuk mengisi nilai
     * dari varabel lokal dari kelas RegionDAO
     */
    public RegionDAO(Connection koneksi) {
        this.koneksi = koneksi;
    }

    /**
     * merupakan method yang dapat digunakan untuk pembanggilan data dari
     * database
     * @param sql digunakan untuk menampung data sementara yang menjadi petokan
     * konci pencarian data dari dalam database, parameter sql bertipe string
     * dan berisi bahasa query
     * @return mengembalikan nilai dari objek regions yang digunakan untuk
     * menampung nilai yang dicari dan mengirimkan nilai tersebut ke kelas yang
     * memanggil data tersebut.
     */
    public List<Region> getData(String sql) {
        List<Region> regions = new ArrayList<>();
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            ResultSet resultSet = statment.executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                region.setRegionId(resultSet.getInt("region_id"));
                region.setRegionName(resultSet.getString("region_name"));
                regions.add(region);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return regions;
    }

    /**
     * getAllData digunakan untuk mengambil semua data dari tabel region
     * @return mengirimkan nilai kedalam method getData menggunakan query yang
     * dijadikan parameter
     */
    public List<Region> getAllData() {
        return this.getData("select * from regions order by 1");
    }

    /**
     * getById digunakan untuk mengambil data dari tabel region berdasarkan id
     * tertentu
     * @param id digunakan sebagai kunci utama dalam melakukan pencarian
     * @return mengirimkan nilai kedalam method getData menggunakan query yang
     * dijadikan parameter
     */
    public List<Region> getById(int id) {
        return this.getData("select region_id, region_name from regions where region_id = '" + id + "'");
    }

    /**
     * search digunakan untuk mengambil data dari tabel region berdasarkan id
     * tertentu
     * @param category digunakan sebagai kunci utama dalam melakukan pencarian
     * @param cari digunakan sebagai kunci utama dalam melakukan pencarian
     * @return mengirimkan nilai kedalam method getData menggunakan query yang
     * dijadikan parameter
     */
    public List<Region> search(String category, String cari) {
        return this.getData("select * from regions where regexp_like(" + category + ",'" + cari + "','i') order by 1");
    }

    /**
     * method eksekusi yang digunakan untuk melakukan eksekusi query yang
     * disimpan kedalam parameter yang bernama sql bertipe String
     * @param sql bertipe String yang digunakan untuk menampung query
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
     * auto id digunakan hanya untuk tabel regions, berfungsi untuk melakukan
     * pemanggilan id terbesar dari tabel region dan menambahkannya dengan 1
     * "max(region_id)+1"
     * @return bertipe interger
     */
    public int autoId() {
        return this.getData("select max(region_id)+1 region_id,max(region_name)"
                + "region_name from regions").get(0).getRegionId();
    }

    /**
     * digunakan untuk melakukan proses penyimpana data region baru kedalam database 
     *didalam method ini melakukan pembanggilan method lain yang diantaranya adalah method autoId
     * @param regName digunakan untuk menampung sementara nilai nama region yang akan disimpan kedalam database
     * @return mengembalikan nilai dari hasil proses method yang bernama eksekusi yang diisi dengan parameter string yang berisi 
     * query insert
     */
    public boolean simpanRegion(String regName) {
        int id = this.autoId();
        return this.eksekusi("insert into regions values (" + id + ",'" + regName + "')");
    }

    /**
     * merupakan method yang digunakan untuk melakukan update dan bertipe boolean
     * @param region merupakan parameter objek yang berisi nilai dari kelas region
     * @return mengembalikan nilai dari eksekusi proses method eksekusi yang memiliki parameter bertipe string yang 
     * diisi dengan query
     */
    public boolean updateRegion(Region region) {
        return this.eksekusi("update regions set region_name='" + region.getRegionName()
                + "' where region_id=" + region.getRegionId());

    }

    /**
     *merupakan method yang digunakan untuk menghapus data region dan memiliki parameter yang bernama id dan bertipe interger
     * @param id digunakan untuk menampung nilai sementara dari id yang akan menjadi kunci utama dalam proses penghapusan
     * @return mengembalikan nilai dari hasil proses method eksekusi
     */
    public boolean hapusRegion(int id) {
        return this.eksekusi("delete from regions where region_id =" + id + "");
    }

}
