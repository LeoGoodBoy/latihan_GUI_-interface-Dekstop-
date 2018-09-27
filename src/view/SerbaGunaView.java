/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author chochong
 */
public class SerbaGunaView {
    public void tampilPesan(Component component, String pesan, String judul){
        JOptionPane.showMessageDialog(component, pesan, judul, JOptionPane.INFORMATION_MESSAGE);
    }
}
