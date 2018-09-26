/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chochong
 */
public class KoneksiTest {
    @Test
    public void testGetKoneksi() {
        Koneksi instance = new Koneksi();
        System.out.println("melakukan test koneksi");
        assertNotNull(instance.getKoneksi());
    }   
}
