/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import dao.CountryDAO;
import dao.RegionDAO;
import java.util.Scanner;
import model.Region;

/**
 *
 * @author chochong
 */
public class cetak {
    public static void main(String[] args) {
        RegionDAO rdao = new RegionDAO(new Koneksi().getKoneksi());
        CountryDAO cdao = new CountryDAO(new Koneksi().getKoneksi());
//        System.out.println("TAMPIL SEMUA");
//        for (Region region : rdao.getAllData()) {
//            System.out.println(region.getRegionId() + "-" + region.getRegionName());
//        }
//        
//        System.out.println("");
//        Scanner scp = new Scanner(System.in);
//        System.out.print("masukkan kunci pencarian = ");
//        String category = scp.next();
//        System.out.print("masukkan kunci pencarian = ");
//        String key = scp.next();
//        for (Region region : rdao.search(category, key)) {
//            System.out.println(region.getRegionId() + "-" + region.getRegionName());
//        }
//        
//        System.out.println("");
//        System.out.print("masukkan id = ");
//        int id = scp.nextInt();
//        for (Region region : rdao.getById(id)) {
//            System.out.println(region.getRegionId() + "-" + region.getRegionName());
//        }
        
        
        System.out.println(rdao.simpanRegion("kalimandua"));
//        rdao.hapusRegion(12);
//        
//        cdao.simpanCountry("KL", "INDONESE", 1);
//        cdao.hapusCountry("KL");
    }
}
