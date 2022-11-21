/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.PBD;
import Services.Implements.PBDImplement;
import Services.PBDService;
import ViewModels.PBDViewModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ListView;
import jdk.jshell.execution.Util;

/**
 *
 * @author Admin
 */
public class Form_PBD extends javax.swing.JFrame {

    private PBDService getPBDService = new PBDImplement();

    private DefaultTableModel dtm;

    /**
     * Creates new form PBD
     */
    public Form_PBD() {
        initComponents();
        loadData(getPBDService.getListPhieu());
        clearForm();
    }

    public void loadData(ArrayList<PBDViewModel> listVM) {

        dtm = (DefaultTableModel) tblPBD.getModel();

        dtm.setRowCount(0);

        for (PBDViewModel dataPBDViewModel : listVM) {

            dtm.addRow(new Object[]{
                dataPBDViewModel.getId(),
                dataPBDViewModel.getNgayBaoDuong(),
                dataPBDViewModel.getNgayHoanThanh(),
                dataPBDViewModel.getChiPhi(),
                dataPBDViewModel.getBienSoXe()
            });
        }
    }

    public void clearForm() {

        this.txtBienSoXe.setText("");
        this.txtNgayBaoDuong.setText("");
        this.txtNgayHoanThanh.setText("");
        this.txtChiPhi.setText("");
    }

    public PBD getFromData() {

        PBD pbd = new PBD();

        String bienSX = txtBienSoXe.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date ngayBD = sdf.parse(txtNgayBaoDuong.getText());
            Date ngayHT = sdf.parse(txtNgayHoanThanh.getText());
            pbd.setNgayBaoDuong(ngayBD);
            pbd.setNgayHoanThanh(ngayHT);
            pbd.setBienSoXe(bienSX);
        } catch (ParseException ex) {
            Logger.getLogger(Form_PBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Float chiPhi = Float.parseFloat(txtChiPhi.getText());
        pbd.setChiPhi(chiPhi);

        return pbd;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNgayBaoDuong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgayHoanThanh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtChiPhi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPBD = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnTinh = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtBienSoXe = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("PHIẾU BẢO DƯỠNG");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("Biển Số Xe:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Ngày Bảo Dưỡng:");

        txtNgayBaoDuong.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Ngày Hoàn Thành:");

        txtNgayHoanThanh.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Chi Phí:");

        txtChiPhi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        tblPBD.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblPBD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ngày Bảo Dưỡng", "Ngày Hoàn Thành", "Chi Phí", "Biển Số Xe"
            }
        ));
        tblPBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPBDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPBD);

        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Gear.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTinh.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnTinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Upload.png"))); // NOI18N
        btnTinh.setText("LOAD");
        btnTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Search.png"))); // NOI18N
        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        txtBienSoXe.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("ID:");

        txtID.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtChiPhi, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(txtNgayHoanThanh)
                                    .addComponent(txtNgayBaoDuong)
                                    .addComponent(txtBienSoXe)
                                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(65, 65, 65))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(jLabel2)
                    .addComponent(txtBienSoXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayBaoDuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTinh))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtChiPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPBDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPBDMouseClicked

        int row = tblPBD.getSelectedRow();

        if (row == -1) {

            return;
        }

        txtBienSoXe.setText(tblPBD.getValueAt(row, 4).toString());
        txtNgayBaoDuong.setText(tblPBD.getValueAt(row, 1).toString());
        txtNgayHoanThanh.setText(tblPBD.getValueAt(row, 2).toString());
        txtChiPhi.setText(tblPBD.getValueAt(row, 3).toString());
        txtID.setText(tblPBD.getValueAt(row, 0).toString());
    }//GEN-LAST:event_tblPBDMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        PBD addPBD = new PBD();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            addPBD.setBienSoXe(txtBienSoXe.getText());
            addPBD.setChiPhi(Float.parseFloat(txtChiPhi.getText()));
            addPBD.setNgayBaoDuong(sdf.parse(txtNgayBaoDuong.getText()));
            addPBD.setNgayHoanThanh(sdf.parse(txtNgayHoanThanh.getText()));
        } catch (Exception e) {

            e.printStackTrace();
        }

        if (addPBD == null) {

            return;
        }

        if (getPBDService.Them(addPBD)) {

            loadData(getPBDService.getListPhieu());
            JOptionPane.showMessageDialog(this, "Thêm Thành Công!");

        } else {

            JOptionPane.showMessageDialog(this, "Thêm Thất Bại!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        PBD addPBD = new PBD();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            addPBD.setId(txtID.getText());
            addPBD.setBienSoXe(txtBienSoXe.getText());
            addPBD.setChiPhi(Float.parseFloat(txtChiPhi.getText()));
            addPBD.setNgayBaoDuong(sdf.parse(txtNgayBaoDuong.getText()));
            addPBD.setNgayHoanThanh(sdf.parse(txtNgayHoanThanh.getText()));
        } catch (Exception e) {

            e.printStackTrace();
        }

        if (addPBD == null) {

            return;
        }

        if (getPBDService.Sua(addPBD)) {

            loadData(getPBDService.getListPhieu());
            JOptionPane.showMessageDialog(this, "Sửa Thành Công!");

        } else {

            JOptionPane.showMessageDialog(this, "Sửa Thất Bại!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed

        String bienSX = txtBienSoXe.getText();

        ArrayList<PBDViewModel> searchListPBD = getPBDService.timKiemPhieu(bienSX);

        dtm = (DefaultTableModel) tblPBD.getModel();

        dtm.setRowCount(0);

        for (PBDViewModel searchPBDViewModel : searchListPBD) {

            dtm.addRow(new Object[]{
                searchPBDViewModel.getId(),
                searchPBDViewModel.getNgayBaoDuong(),
                searchPBDViewModel.getNgayHoanThanh(),
                searchPBDViewModel.getChiPhi(),
                searchPBDViewModel.getBienSoXe()
            });
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhActionPerformed

        loadData(getPBDService.getListPhieu());
    }//GEN-LAST:event_btnTinhActionPerformed

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
            java.util.logging.Logger.getLogger(Form_PBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_PBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_PBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_PBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_PBD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPBD;
    private javax.swing.JTextField txtBienSoXe;
    private javax.swing.JTextField txtChiPhi;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNgayBaoDuong;
    private javax.swing.JTextField txtNgayHoanThanh;
    // End of variables declaration//GEN-END:variables
}