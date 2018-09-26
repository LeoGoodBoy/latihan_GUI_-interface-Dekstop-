/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CountryController;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Country;
import tools.Koneksi;

/**
 *
 * @author chochong
 */
public class CountryView extends javax.swing.JInternalFrame {
    
    private SerbaGunaView serbaGuna;
    
    private CountryController controller;

    /**
     * Creates new form CountryView
     */
    public CountryView() {
        initComponents();
        controller = new CountryController(new Koneksi().getKoneksi());
        serbaGuna = new SerbaGunaView();
        bindingCountries(controller.viewCountry());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCountryId = new javax.swing.JTextField();
        txtCountryName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRegionId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSimpanCountry = new javax.swing.JButton();
        btnUpdateCountry = new javax.swing.JButton();
        btnDeleteCountry = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCountry = new javax.swing.JTable();
        txtSearchCountry = new javax.swing.JTextField();
        cmbKategoriCountry = new javax.swing.JComboBox<>();
        btnSearchCountry = new javax.swing.JButton();

        setTitle("Master Country");
        setToolTipText("ini master country");

        jLabel1.setText("ID COUNTRY");

        txtCountryId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCountryIdActionPerformed(evt);
            }
        });

        txtCountryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCountryNameActionPerformed(evt);
            }
        });

        jLabel2.setText("NAMA COUNTRY");

        jLabel3.setText("ID REGION");

        btnSimpanCountry.setText("SIMPAN");
        btnSimpanCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanCountryActionPerformed(evt);
            }
        });

        btnUpdateCountry.setText("UPDATE");
        btnUpdateCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCountryActionPerformed(evt);
            }
        });

        btnDeleteCountry.setText("DELETE");
        btnDeleteCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCountryActionPerformed(evt);
            }
        });

        btnExit.setText("KELUAR");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tblCountry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCountryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCountry);

        txtSearchCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchCountryKeyReleased(evt);
            }
        });

        cmbKategoriCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Country Id", "Conutry Name", "Region ID" }));

        btnSearchCountry.setText("SEARCH");
        btnSearchCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCountryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCountryName, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbKategoriCountry, 0, 176, Short.MAX_VALUE)
                            .addComponent(txtSearchCountry))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSimpanCountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateCountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteCountry)
                        .addGap(137, 137, 137)
                        .addComponent(btnSearchCountry)
                        .addGap(209, 209, 209)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCountryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKategoriCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteCountry)
                    .addComponent(btnUpdateCountry)
                    .addComponent(btnSimpanCountry)
                    .addComponent(btnSearchCountry))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCountryIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCountryIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCountryIdActionPerformed

    private void txtCountryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCountryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCountryNameActionPerformed

    private void btnSimpanCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanCountryActionPerformed
        // TODO add your handling code here:
        String pesan = controller.saveOrUpdateCountry(txtCountryId.getText(),
                txtCountryName.getText(), txtRegionId.getText(), true);
        serbaGuna.tampilPesan(this, pesan, "Pesan Simpan");
        bindingCountries(controller.viewCountry());
    }//GEN-LAST:event_btnSimpanCountryActionPerformed

    private void btnUpdateCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCountryActionPerformed
        // TODO add your handling code here:
        String pesan = controller.saveOrUpdateCountry(txtCountryId.getText(),
                txtCountryName.getText(), txtRegionId.getText(), false);
        serbaGuna.tampilPesan(this, pesan, "Pesan Update");
        bindingCountries(controller.viewCountry());
    }//GEN-LAST:event_btnUpdateCountryActionPerformed

    private void btnDeleteCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCountryActionPerformed
        // TODO add your handling code here:

        String pesan = controller.hapusCountry(txtCountryId.getText());
        serbaGuna.tampilPesan(this, pesan, "Pesan Delete");
        bindingCountries(controller.viewCountry());
    }//GEN-LAST:event_btnDeleteCountryActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void tblCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCountryMouseClicked
        // TODO add your handling code here:
        int row = tblCountry.getSelectedRow();
        txtCountryId.setText(tblCountry.getValueAt(row, 1).toString());
        txtCountryName.setText(tblCountry.getValueAt(row, 2).toString());
        txtRegionId.setText(tblCountry.getValueAt(row, 3).toString());
        edit();
    }//GEN-LAST:event_tblCountryMouseClicked

    private void txtSearchCountryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCountryKeyReleased
        // TODO add your handling code here:
//        if (txtSearchCountry.getText().equals("")) {
//                bindingCountries(controller.viewCountry());
//            }
//        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
//            bindingCountries(controller.searchCountry(cmbKategoriCountry.getSelectedItem().toString(), txtSearchCountry.getText()));
//        }
    }//GEN-LAST:event_txtSearchCountryKeyReleased

    private void btnSearchCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCountryActionPerformed
        // TODO add your handling code here:
//        List<Country> countrys = controller.searchCountry(cmbKategoriCountry.getSelectedItem().toString(), txtSearchCountry.getText());
//        bindingCountries(countrys);
    }//GEN-LAST:event_btnSearchCountryActionPerformed

    private void bindingCountries(List<Country> countrys){
        String [] header = {"No","Country Id","Country Name","Region Id"};
        String [][] data = new String[countrys.size()][header.length];
        for (int i = 0; i < countrys.size(); i++) {
            data [i][0] = (i+1)+"";
            data [i][1] = countrys.get(i).getCountryId();
            data [i][2] = countrys.get(i).getCountryName();
            data [i][3] = countrys.get(i).getRegion().getRegionId() + "";       
        }
        tblCountry.setModel(new DefaultTableModel(data, header));
        reset();
    }
    
    private void edit(){
        txtCountryId.setEnabled(false);
        btnSimpanCountry.setEnabled(false);
        btnUpdateCountry.setEnabled(true);
        btnDeleteCountry.setEnabled(true);
    }
    
    private void reset(){
        txtCountryId.setText("");
        txtCountryId.setEnabled(true);
        txtCountryName.setText("");
        txtRegionId.setText("");
        btnDeleteCountry.setEnabled(false);
        btnSearchCountry.setEnabled(true);
        btnUpdateCountry.setEnabled(false);
        btnSimpanCountry.setEnabled(true);
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteCountry;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearchCountry;
    private javax.swing.JButton btnSimpanCountry;
    private javax.swing.JButton btnUpdateCountry;
    private javax.swing.JComboBox<String> cmbKategoriCountry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCountry;
    private javax.swing.JTextField txtCountryId;
    private javax.swing.JTextField txtCountryName;
    private javax.swing.JTextField txtRegionId;
    private javax.swing.JTextField txtSearchCountry;
    // End of variables declaration//GEN-END:variables


    
}
