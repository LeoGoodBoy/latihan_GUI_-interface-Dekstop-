/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author chochong
 */
public class HrForm extends javax.swing.JFrame {

    /**
     * Creates new form HrForm
     */
    public HrForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpHr = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniCountry = new javax.swing.JMenuItem();
        mniRegion = new javax.swing.JMenuItem();
        mniLocation = new javax.swing.JMenuItem();
        mniJob = new javax.swing.JMenuItem();
        mniDepartment = new javax.swing.JMenuItem();
        mniEmployee = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dpHrLayout = new javax.swing.GroupLayout(dpHr);
        dpHr.setLayout(dpHrLayout);
        dpHrLayout.setHorizontalGroup(
            dpHrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        dpHrLayout.setVerticalGroup(
            dpHrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        mniCountry.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mniCountry.setText("Country");
        mniCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCountryActionPerformed(evt);
            }
        });
        jMenu1.add(mniCountry);

        mniRegion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mniRegion.setText("Region");
        mniRegion.setToolTipText("");
        mniRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRegionActionPerformed(evt);
            }
        });
        jMenu1.add(mniRegion);

        mniLocation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mniLocation.setText("Location");
        mniLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLocationActionPerformed(evt);
            }
        });
        jMenu1.add(mniLocation);

        mniJob.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        mniJob.setText("Job");
        mniJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniJobActionPerformed(evt);
            }
        });
        jMenu1.add(mniJob);

        mniDepartment.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mniDepartment.setText("Department");
        mniDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDepartmentActionPerformed(evt);
            }
        });
        jMenu1.add(mniDepartment);

        mniEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mniEmployee.setText("Employee");
        mniEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEmployeeActionPerformed(evt);
            }
        });
        jMenu1.add(mniEmployee);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpHr)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpHr)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegionActionPerformed
        // TODO add your handling code here:
        RegionView regionView = new RegionView();
        regionView.show();
        dpHr.add(regionView); 
//        this.getParent().add(regionView);
//        regionView.setVisible(true);
    }//GEN-LAST:event_mniRegionActionPerformed

    private void mniCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCountryActionPerformed
        // TODO add your handling code here:
        CountryView countryView = new CountryView();
        countryView.show();
        dpHr.add(countryView);
    }//GEN-LAST:event_mniCountryActionPerformed

    private void mniLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLocationActionPerformed
        // TODO add your handling code here:
        LocationView locationView = new LocationView();
        locationView.show();
        dpHr.add(locationView);
    }//GEN-LAST:event_mniLocationActionPerformed

    private void mniJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniJobActionPerformed
        // TODO add your handling code here:
        JobView jobView = new JobView();
        jobView.show();
        dpHr.add(jobView);
    }//GEN-LAST:event_mniJobActionPerformed

    private void mniDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDepartmentActionPerformed
        // TODO add your handling code here:
        DepartmentView departmentView = new DepartmentView();
        departmentView.show();
        dpHr.add(departmentView);
    }//GEN-LAST:event_mniDepartmentActionPerformed

    private void mniEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEmployeeActionPerformed
        EmployeeView employeeView = new EmployeeView();
        employeeView.show();
        dpHr.add(employeeView);
    }//GEN-LAST:event_mniEmployeeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HrForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HrForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HrForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HrForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpHr;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mniCountry;
    private javax.swing.JMenuItem mniDepartment;
    private javax.swing.JMenuItem mniEmployee;
    private javax.swing.JMenuItem mniJob;
    private javax.swing.JMenuItem mniLocation;
    private javax.swing.JMenuItem mniRegion;
    // End of variables declaration//GEN-END:variables
}
