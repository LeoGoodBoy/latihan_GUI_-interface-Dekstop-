/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DepartmentController;
import controller.EmployeeController;
import controller.JobController;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import tools.Koneksi;

/**
 *
 * @author Nande
 */
public class EmployeeViewSimple extends javax.swing.JInternalFrame {

    /**
     * Creates new form EmployeeViewSimple
     */
    EmployeeController controller;
    JobController jobController;
    DepartmentController departmentController;
    SerbaGunaView serbaGunaView;
    Vector cmbItems;
    List<Pair<String, String>> listCmb;
    Vector listJob;
    private Vector listDepartment;
    private Vector listmanager;
    private List<List<String>> listManagerId;
    String idManager;
    public EmployeeViewSimple() {
        initComponents();
        this.controller = new EmployeeController(new Koneksi().getKoneksi());
        this.serbaGunaView = new SerbaGunaView();
        this.cmbItems = new Vector();
        listManagerId = new ArrayList<>();
        bindingEmployee(controller.viewEmployee());
        setNewEmployeeId();
        listCmb = new ArrayList<>();
        setCmbCategory();
        this.jobController = new JobController(new Koneksi().getKoneksi());
        this.getCmbJob();
        this.setCmbJob();
        this.departmentController = new DepartmentController(new Koneksi().getKoneksi());
        this.getCmbDepartment();
        this.setCmbDepartment();
        this.getCmbManager();
        this.setCmbManager();
        
//        pnlDetails.setBorder(BorderFactory.createTitledBorder("Region Details"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cmbCategory = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        pnlDetails = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEmployeeId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dcHireDate = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCommissionPct = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        cmbJobId = new javax.swing.JComboBox<>();
        cmbManager = new javax.swing.JComboBox<>();
        cmbDepartment = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnDrop = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(700, 650));

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        pnlDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Details"));

        jLabel1.setText("Employee ID");

        txtEmployeeId.setEditable(false);

        jLabel2.setText("First Name");

        jLabel6.setText("Hire Date");

        jLabel5.setText("Phone Number");

        jLabel4.setText("Email");

        jLabel3.setText("Last Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber)
                    .addComponent(txtEmail)
                    .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(txtFirstName)
                    .addComponent(dcHireDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(dcHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Job");

        jLabel8.setText("Salary");

        jLabel9.setText("Commission PCT");

        jLabel10.setText("Manager");

        jLabel11.setText("Department");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbJobId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbManager, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCommissionPct, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbJobId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCommissionPct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDrop.setText("Drop");
        btnDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDropActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(btnDrop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnDrop)))
        );

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        boolean isUpdate = false;
        if (!txtEmployeeId.isEnabled()) {
            isUpdate = true;
        }
        serbaGunaView.tampilPesan(this, controller.simpanOrUpdateEmployee(txtEmployeeId.getText(), txtFirstName.getText(),
                txtLastName.getText(), txtEmail.getText(), txtPhoneNumber.getText(), formatDate(),
                cmbJobId.getSelectedItem().toString(), txtSalary.getText(), txtCommissionPct.getText(),
                this.getIdManager(), cmbDepartment.getSelectedItem().toString(), isUpdate), "Pesan");
        txtEmployeeId.setEditable(true);
        setNewEmployeeId();
        reset();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDropActionPerformed
        // TODO add your handling code here:
        String pesan = controller.hapusEmployee(txtEmployeeId.getText());
        this.serbaGunaView.tampilPesan(this, pesan, "Pesan Delete");
        bindingEmployee(controller.viewEmployee());
        txtEmployeeId.setEnabled(true);
        setNewEmployeeId();
    }//GEN-LAST:event_btnDropActionPerformed

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        // TODO add your handling code here:
        int row = tblEmployee.getSelectedRow();
        String sdate = tblEmployee.getValueAt(row, 6).toString();
        txtEmployeeId.setText(tblEmployee.getValueAt(row, 1).toString());
        txtFirstName.setText(tblEmployee.getValueAt(row, 2).toString());
        txtLastName.setText(tblEmployee.getValueAt(row, 3).toString());
        txtEmail.setText(tblEmployee.getValueAt(row, 4).toString());
        txtPhoneNumber.setText(tblEmployee.getValueAt(row, 5).toString());
        try {
            dcHireDate.setDate(new SimpleDateFormat("yyyy-mm-dd").parse(sdate));
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeViewSimple.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmbJobId.setSelectedItem(tblEmployee.getValueAt(row, 7).toString());
        txtSalary.setText(tblEmployee.getValueAt(row, 8).toString());
        txtCommissionPct.setText(tblEmployee.getValueAt(row, 9).toString());
        cmbManager.setSelectedItem(tblEmployee.getValueAt(row, 10).toString());
        cmbDepartment.setSelectedItem(tblEmployee.getValueAt(row, 11).toString());
        txtEmployeeId.setEnabled(false);
        controller.setTemp(txtLastName.getText());
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        List<Employee> employees = controller.searchEmployee(listCmb.get(this.getIndex(cmbCategory.getSelectedItem().toString())).getKey(), txtCari.getText());
        bindingEmployee(employees);
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        if (txtCari.getText().equals("")) {
            bindingEmployee(controller.viewEmployee());
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            bindingEmployee(controller.searchEmployee(listCmb.get(this.getIndex(cmbCategory.getSelectedItem().toString())).getKey(), txtCari.getText()));
        }
    }//GEN-LAST:event_txtCariKeyReleased
    private String formatDate() {
        String hasil = "";
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        hasil = sdf.format(dcHireDate.getDate());
        return hasil;
    }

    private void bindingEmployee(List<Employee> employees) {
        String[] header = {"No", "Employee ID", "First Name", "Last Name", "Email", "Phone Number", "Hire Date", "Job",
            "Salary", "Commission PCT", "Manager", "Department"};
        String[][] data = new String[employees.size()][header.length];
        listManagerId = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            data[i][0] = (i + 1) + "";
            data[i][1] = employees.get(i).getEmployeeId() + "";
            data[i][2] = employees.get(i).getFirstName();
            data[i][3] = employees.get(i).getLastName();
            data[i][4] = employees.get(i).getEmail();
            data[i][5] = employees.get(i).getPhoneNumber() + "";
            data[i][6] = employees.get(i).getHireDate();
            data[i][7] = employees.get(i).getJob().getJobTitle();
            data[i][8] = employees.get(i).getSalary() + "";
            data[i][9] = employees.get(i).getCommissionPct() + "";
            data[i][10] = employees.get(i).getManager().getEmployeeId() + "-" + employees.get(i).getManager().getLastName();
//            String id = employees.get(i).getEmployeeId()+"";
//            String name = employees.get(i).getLastName();
//            String email = employees.get(i).getEmail();
            List<String> idName  = new ArrayList<>();
            idName.add((i + 1) + "");
            idName.add(employees.get(i).getManager().getEmployeeId() + "");
            listManagerId.add(idName);
            data[i][11] = employees.get(i).getDepartment().getDepartmentName();
            
            
        }
        tblEmployee.setModel(new DefaultTableModel(data, header));
        tblEmployee.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblEmployee.getColumnModel().getColumn(1).setPreferredWidth(70);
        tblEmployee.getColumnModel().getColumn(2).setPreferredWidth(70);
        tblEmployee.getColumnModel().getColumn(3).setPreferredWidth(70);
        tblEmployee.getColumnModel().getColumn(4).setPreferredWidth(70);
        tblEmployee.getColumnModel().getColumn(5).setPreferredWidth(120);
        tblEmployee.getColumnModel().getColumn(6).setPreferredWidth(70);
        tblEmployee.getColumnModel().getColumn(7).setPreferredWidth(200);
        tblEmployee.getColumnModel().getColumn(8).setPreferredWidth(80);
        tblEmployee.getColumnModel().getColumn(9).setPreferredWidth(100);
        tblEmployee.getColumnModel().getColumn(10).setPreferredWidth(80);
        tblEmployee.getColumnModel().getColumn(11).setPreferredWidth(120);
        tblEmployee.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    private void setCmbCategory() {
        listCmb.add(0, new Pair<>("employee_id", "Employee ID"));
        listCmb.add(1, new Pair<>("first_name", "First Name"));
        listCmb.add(2, new Pair<>("last_name", "Last Name"));
        listCmb.add(3, new Pair<>("email", "Email"));
        listCmb.add(4, new Pair<>("phone_number", "Phone Number"));
        listCmb.add(5, new Pair<>("hire_date", "Hire Date"));
        listCmb.add(6, new Pair<>("job_id", "Job ID"));
        listCmb.add(7, new Pair<>("salary", "Salary"));
        listCmb.add(8, new Pair<>("commission_pct", "Commission"));
        listCmb.add(9, new Pair<>("manager_id", "Manager ID"));
        listCmb.add(10, new Pair<>("department_id", "Department ID"));
        for (Pair<String, String> pair : listCmb) {
            cmbItems.add(pair.getValue());
        }
        final DefaultComboBoxModel model = new DefaultComboBoxModel(cmbItems);
        cmbCategory.setModel(model);
    }
    private String getIdManager(){
        String hasil = "";
//        for (List<String> name : listManagerId) {
//            if(name.get(0).equals(no)) hasil = name.get(1);
//        }
        String[] detail = cmbManager.getSelectedItem().toString().split("-");
        hasil = detail[0];
        return hasil;
    }
    private int getIndex(String value) {
        int hasil = 0;
        switch (value) {
            case "Employee ID":
                hasil = 0;
                break;
            case "First Name":
                hasil = 1;
                break;
            case "Last Name":
                hasil = 2;
                break;
            case "Email":
                hasil = 3;
                break;
            case "Phone Number":
                hasil = 4;
                break;
            case "Hire Date":
                hasil = 5;
                break;
            case "Job ID":
                hasil = 6;
                break;
            case "Salary":
                hasil = 7;
                break;
            case "Commission":
                hasil = 8;
                break;
            case "Manager ID":
                hasil = 9;
                break;
            case "Department ID":
                hasil = 10;
                break;
        }
        return hasil;
    }

    private void getCmbJob() {
        listJob = new Vector();
        for (int i = 0; i < jobController.viewJob().size(); i++) {
            listJob.add(jobController.viewJob().get(i).getJobTitle());
        }
    }
    private void setCmbJob(){
        final DefaultComboBoxModel model = new DefaultComboBoxModel(listJob);
        cmbJobId.setModel(model);
    }
    
    private void getCmbDepartment(){
        listDepartment = new Vector();
        for (int i = 0; i < departmentController.viewDepartmentNames().size(); i++) {
            listDepartment.add(departmentController.viewDepartmentNames().get(i).getDepartmentName());
        }
    }
    
    private void setCmbDepartment(){
        final DefaultComboBoxModel model = new DefaultComboBoxModel(listDepartment);
        cmbDepartment.setModel(model);
    }
    private void getCmbManager(){
        listmanager = new Vector();
        for (int i = 0; i < controller.viewManager().size(); i++) {
            listmanager.add(controller.viewManager().get(i).getEmployeeId() + "-" + controller.viewManager().get(i).getLastName());
        }
    }
    private void setCmbManager(){
        final DefaultComboBoxModel model = new DefaultComboBoxModel(listmanager);
        cmbManager.setModel(model);
    }
    private void setNewEmployeeId(){
        txtEmployeeId.setText(controller.getNextId() + "");
    }
    private void reset(){
        txtEmployeeId.setEnabled(true);
        setNewEmployeeId();
        txtFirstName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtPhoneNumber.setText("");
        dcHireDate.setDate(null);
        cmbJobId.setSelectedItem(null);
        txtSalary.setText("");
        txtCommissionPct.setText("");
        cmbManager.setSelectedItem(null);
        cmbDepartment.setSelectedItem(null);
        bindingEmployee(controller.viewEmployee());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDrop;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbDepartment;
    private javax.swing.JComboBox<String> cmbJobId;
    private javax.swing.JComboBox<String> cmbManager;
    private com.toedter.calendar.JDateChooser dcHireDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCommissionPct;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmployeeId;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables
}
