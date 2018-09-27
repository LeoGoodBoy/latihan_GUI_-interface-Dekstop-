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
        controller.loadCmb(cmbRegionId); 
        txtCountryId.setText("hmmmmmm");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCountry = new javax.swing.JTable();
        txtSearchCountry = new javax.swing.JTextField();
        cmbKategoriCountry = new javax.swing.JComboBox<>();
        btnSearchCountry = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCountryId = new javax.swing.JTextField();
        txtCountryName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRegionId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbRegionId = new javax.swing.JComboBox<>();
        btnSimpanCountry = new javax.swing.JButton();
        btnUpdateCountry = new javax.swing.JButton();
        btnDeleteCountry = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Master Country");
        setToolTipText("ini master country");

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

        cmbKategoriCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Country_Id", "Country_Name", "Region_ID" }));
        cmbKategoriCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriCountryActionPerformed(evt);
            }
        });

        btnSearchCountry.setText("FIND");
        btnSearchCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCountryActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(239, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Country Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Bold", 1, 12), new java.awt.Color(0, 0, 204))); // NOI18N

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

        txtRegionId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegionIdActionPerformed(evt);
            }
        });

        jLabel3.setText("ID REGION");

        cmbRegionId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRegionIdActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(44, 44, 44)
                        .addComponent(txtRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186)
                        .addComponent(btnSimpanCountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateCountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteCountry))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(554, 554, 554)
                        .addComponent(cmbRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(txtCountryName, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(txtCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtCountryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteCountry)
                    .addComponent(btnUpdateCountry)
                    .addComponent(btnSimpanCountry))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbKategoriCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchCountry)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKategoriCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCountry))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        if (txtSearchCountry.getText().equals("")) {
                bindingCountries(controller.viewCountry());
            }
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            bindingCountries(controller.searchCountry(cmbKategoriCountry.getSelectedItem().toString(), txtSearchCountry.getText()));
        }
    }//GEN-LAST:event_txtSearchCountryKeyReleased

    private void btnSearchCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCountryActionPerformed
        // TODO add your handling code here:
        List<Country> countrys = controller.searchCountry(cmbKategoriCountry.getSelectedItem().toString(), txtSearchCountry.getText());
        bindingCountries(countrys);
    }//GEN-LAST:event_btnSearchCountryActionPerformed

    private void txtRegionIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegionIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegionIdActionPerformed

    private void cmbRegionIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRegionIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRegionIdActionPerformed

    private void cmbKategoriCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKategoriCountryActionPerformed

    private void bindingCountries(List<Country> countrys){
        String [] header = {"No","Country Id","Country Name","Region Name"};
        String [][] data = new String[countrys.size()][header.length];
        for (int i = 0; i < countrys.size(); i++) {
            data [i][0] = (i+1)+"";
            data [i][1] = countrys.get(i).getCountryId();
            data [i][2] = countrys.get(i).getCountryName();
            data [i][3] = countrys.get(i).getRegion().getRegionName()+ "";       
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
    private javax.swing.JButton btnSearchCountry;
    private javax.swing.JButton btnSimpanCountry;
    private javax.swing.JButton btnUpdateCountry;
    private javax.swing.JComboBox<String> cmbKategoriCountry;
    private javax.swing.JComboBox<String> cmbRegionId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCountry;
    private javax.swing.JTextField txtCountryId;
    private javax.swing.JTextField txtCountryName;
    private javax.swing.JTextField txtRegionId;
    private javax.swing.JTextField txtSearchCountry;
    // End of variables declaration//GEN-END:variables


    
}
