/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.HoaDonTraXeModel;
import Model.HopDongModel;
import Model.KhachHangModel;
import Repository.HoaDonTraXeRepo;
import Service.Impl.HoaDonTraXeServiceImpl;
import ViewModel.HoaDonTraXeViewModel;
import ViewModel.HopDongViewModel;
import ViewModel.KhachHangViewModel;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author lilyp
 */
public final class HoaDonTraXeUI extends javax.swing.JFrame {

    private final HoaDonTraXeServiceImpl ser = new HoaDonTraXeServiceImpl();
    private final HoaDonTraXeRepo repo = new HoaDonTraXeRepo();

    public HoaDonTraXeUI() {
        initComponents();
        firstload();
    }

    void firstload() {
        setcbbtimkiem();
        loadtablehoadon();
        loadtablehopdong();
        txtidkh1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txttenkh1 = new javax.swing.JTextField();
        txtidhd1 = new javax.swing.JTextField();
        txtngaytra = new javax.swing.JTextField();
        txtphiphatsinh = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnsearch = new javax.swing.JButton();
        cbbloai = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtvalue = new javax.swing.JTextField();
        btnreload = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnQR = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtidkh1 = new javax.swing.JTextField();
        rdodatra = new javax.swing.JRadioButton();
        rdochuatra = new javax.swing.JRadioButton();
        btndelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txttongtien = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtidhd2 = new javax.swing.JTextField();
        txttennv = new javax.swing.JTextField();
        txtngaytao = new javax.swing.JTextField();
        txtngayhethan = new javax.swing.JTextField();
        txttinhtrang2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhopdong = new javax.swing.JTable();
        btnselect3 = new javax.swing.JButton();
        txtidkh2 = new javax.swing.JTextField();
        txttenkh2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("id h???p ?????ng");

        jLabel12.setText("t??n kh??ch h??ng");

        jLabel13.setText("ng??y tr???");

        jLabel16.setText("t??nh tr???ng");

        jLabel17.setText("ph?? ph??t sinh");

        txttenkh1.setEditable(false);

        txtidhd1.setEditable(false);

        txtphiphatsinh.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtphiphatsinhCaretUpdate(evt);
            }
        });
        txtphiphatsinh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtphiphatsinhFocusLost(evt);
            }
        });

        tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "id hd", "t??n kh", "ng??y tr???", "t??nh tr???ng", "ph?? ph??t sinh", "t???ng ti???n"
            }
        ));
        tblhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhoadonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblhoadon);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnthem.setText("th??m");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setText("s???a");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("clear");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setName("t??m ki???m"); // NOI18N

        btnsearch.setText("t??m ki???m");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        cbbloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel21.setText("lo???i");

        jLabel22.setText("gi?? tr???");

        btnreload.setText("reload(beta)");
        btnreload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnreload)
                        .addGap(18, 18, 18)
                        .addComponent(btnsearch)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbloai, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtvalue))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsearch)
                    .addComponent(btnreload))
                .addContainerGap())
        );

        jLabel19.setText("t??m ki???m");

        btnQR.setText("QR");
        btnQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnthem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(112, 112, 112)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnQR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnQR))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxoa)
                    .addComponent(btnsua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jLabel18.setText("id");

        txtid.setEditable(false);

        jLabel20.setText("thao t??c");

        buttonGroup2.add(rdodatra);
        rdodatra.setText("????");

        buttonGroup2.add(rdochuatra);
        rdochuatra.setSelected(true);
        rdochuatra.setText("ch??a");

        btndelete.setText("delete(beta)");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jLabel4.setText("t???ng ti???n");

        txttongtien.setEditable(false);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidhd1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenkh1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidkh1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel4))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtphiphatsinh, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(txtngaytra, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(txttongtien)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdodatra)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdochuatra)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(48, 48, 48)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btndelete)
                                .addGap(48, 48, 48)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidhd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txttenkh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(btndelete)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(rdodatra)
                            .addComponent(rdochuatra))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtphiphatsinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtidkh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tab.addTab("H??a ????n tr??? xe", jPanel1);

        jLabel7.setText("id h???p ?????ng");

        jLabel8.setText("t??n nh??n vi??n");

        jLabel9.setText("ng??y t???o");

        jLabel10.setText("ng??y h???t h???n");

        jLabel11.setText("t??nh tr???ng");

        txtidhd2.setEditable(false);

        txttennv.setEditable(false);

        txtngaytao.setEditable(false);

        txtngayhethan.setEditable(false);

        txttinhtrang2.setEditable(false);

        tblhopdong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "t??n nh??n vi??n", "ng??y t???o", "ng??y h???t h???n", "t??nh tr???ng"
            }
        ));
        tblhopdong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhopdongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblhopdong);

        btnselect3.setText("l???a ch???n");
        btnselect3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselect3ActionPerformed(evt);
            }
        });

        txtidkh2.setEditable(false);

        txttenkh2.setEditable(false);

        jLabel2.setText("id kh??ch h??ng");

        jLabel3.setText("t??n kh");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                .addGap(14, 14, 14))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txttennv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txttenkh2)
                    .addComponent(txtidhd2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidkh2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtngaytao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtngayhethan)
                    .addComponent(txttinhtrang2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(btnselect3))
                .addGap(34, 34, 34))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(txtidhd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngayhethan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txttinhtrang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(btnselect3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidkh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttenkh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        tab.addTab("h???p ?????ng", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnselect3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselect3ActionPerformed
        txtidhd1.setText(txtidhd2.getText());
        txttenkh1.setText(txttenkh2.getText());
        txtidkh1.setText(txtidkh2.getText());
    }//GEN-LAST:event_btnselect3ActionPerformed

    private void tblhopdongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhopdongMouseClicked
        int row = tblhopdong.getSelectedRow();
        txtidhd2.setText(tblhopdong.getValueAt(row, 0).toString());
        txttennv.setText(tblhopdong.getValueAt(row, 1).toString());
        KhachHangViewModel khvm = ser.getkh(tblhopdong.getValueAt(row, 0).toString());
        txtidkh2.setText(khvm.getId());
        txttenkh2.setText(khvm.getTen());
        txtngaytao.setText(tblhopdong.getValueAt(row, 2).toString());
        txtngayhethan.setText(tblhopdong.getValueAt(row, 3).toString());
        txttinhtrang2.setText(tblhopdong.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblhopdongMouseClicked

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        int category = cbbloai.getSelectedIndex();
        String value = txtvalue.getText();
        ArrayList<HoaDonTraXeViewModel> list = ser.getlistdata();
        ArrayList<HoaDonTraXeViewModel> final_list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        switch (category) {
            case 0 -> {
                for (HoaDonTraXeViewModel hoaDonHoanTraViewModel : list) {
                    if (value.equalsIgnoreCase(hoaDonHoanTraViewModel.getId())) {
                        final_list.add(hoaDonHoanTraViewModel);
                    }
                }
            }
            case 1 -> {
                for (HoaDonTraXeViewModel hoaDonHoanTraViewModel : list) {
                    if (value.equalsIgnoreCase(hoaDonHoanTraViewModel.getIdhd())) {
                        final_list.add(hoaDonHoanTraViewModel);
                    }
                }
            }
            case 2 -> {
                for (HoaDonTraXeViewModel hoaDonHoanTraViewModel : list) {
                    try {
                        if (sdf.parse(value).equals(hoaDonHoanTraViewModel.getNgaytra()) == true) {
                            final_list.add(hoaDonHoanTraViewModel);
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                        return;
                    }
                }
            }
            default -> {
            }
        }
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        dtm.setRowCount(0);
        for (HoaDonTraXeViewModel h : final_list) {
            Object[] rowData = {
                h.getId(),
                h.getIdhd(),
                ser.getkh(h.getIdhd()).getTen(),
                convertdate(h.getNgaytra()),
                h.getTinhtrang() == 0 ? "???? tr???" : "ch??a tr???",
                h.getPhiphatsinh(),
                h.getTongtien()
            };
            dtm.addRow(rowData);
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        txtid.setText("");
        txtidhd1.setText("");
        txttenkh1.setText("");
        txtngaytra.setText("");
        txttongtien.setText("");
        rdochuatra.setSelected(true);
        txtphiphatsinh.setText("");
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        HoaDonTraXeModel hdhtm = getformdata();
        if (hdhtm == null) {

        } else {
            ser.update(hdhtm);
            loadtablehoadon();
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        HoaDonTraXeModel hdhtm = getformdata();
        if (hdhtm == null) {

        } else {
            hdhtm.setId(UUID.randomUUID().toString());
            ser.insert(hdhtm);
            loadtablehoadon();
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void tblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonMouseClicked
        int row = tblhoadon.getSelectedRow();
        txtid.setText(tblhoadon.getValueAt(row, 0).toString());
        txtidhd1.setText(tblhoadon.getValueAt(row, 1).toString());
        txttenkh1.setText(tblhoadon.getValueAt(row, 2).toString());
        txtngaytra.setText(tblhoadon.getValueAt(row, 3).toString());
        if (tblhoadon.getValueAt(row, 4).toString().equalsIgnoreCase("???? tr???")) {
            rdodatra.setSelected(true);
        } else {
            rdochuatra.setSelected(true);
        }
        txtphiphatsinh.setText(tblhoadon.getValueAt(row, 5).toString());
        txtidkh1.setText(ser.getkh(tblhoadon.getValueAt(row, 1).toString()).getId());
        txttongtien.setText(tblhoadon.getValueAt(row, 6).toString());
    }//GEN-LAST:event_tblhoadonMouseClicked

    private void btnQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQRActionPerformed
        FileOutputStream fos = null;
        try {
            int row = tblhoadon.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "ch??a c?? h??ng n??o ???????c l???a ch???n");
                return;
            }
            String f_name = "id hoa don: " + tblhoadon.getValueAt(row, 0) + "\nten khach hang: " + tblhoadon.getValueAt(row, 2) + "\nid hop dong"
                    + tblhoadon.getValueAt(row, 1) + "\nngay tra: " + tblhoadon.getValueAt(row, 3)
                    + "\ntinh trang: " + tblhoadon.getValueAt(row, 4) + "\nphi phat sinh: " + (tblhoadon.getValueAt(row, 5).equals("ch??a tr???") ? 0 : 1) + "\ntong tien: " + tblhoadon.getValueAt(row, 6);
            ByteArrayOutputStream out = QRCode.from(f_name).to(ImageType.PNG).stream();
            String path = "D:\\fpt\\QRCode\\";
            fos = new FileOutputStream(new File(path + (UUID.randomUUID().toString() + ".PNG")));
            fos.write(out.toByteArray());
            fos.flush();
            openFileExplorer();
        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnQRActionPerformed

    private void btnreloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreloadActionPerformed
        loadtablehoadon();
    }//GEN-LAST:event_btnreloadActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        HoaDonTraXeModel hdhtm = getformdata();
        ser.delete(hdhtm);
        loadtablehoadon();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void txtphiphatsinhCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtphiphatsinhCaretUpdate
        try {
            double tienthuexe = repo.tienthuexe(txtidhd1.getText());
            if (txtidhd1.getText().equalsIgnoreCase("")) {
                txttongtien.setText(String.valueOf(tienthuexe));
                return;
            }
            double phiphatsinh = Double.parseDouble(txtphiphatsinh.getText());
            if (phiphatsinh == 0) {
                txttongtien.setText(String.valueOf(tienthuexe));
            }
            txttongtien.setText(String.valueOf(tienthuexe + phiphatsinh));
        } catch (NumberFormatException ex) {
            return;
        }
    }//GEN-LAST:event_txtphiphatsinhCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println(repo.tienthuexe(txtidhd1.getText()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtphiphatsinhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtphiphatsinhFocusLost

    }//GEN-LAST:event_txtphiphatsinhFocusLost

    void openFileExplorer() {
        try {
            String pathname = "D:\\fpt\\QRCode\\";
            File file = new File(pathname);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void setcbbtimkiem() {
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) cbbloai.getModel();
        dcm.removeAllElements();
        ArrayList<String> list = new ArrayList<>();
        list.add("id");
        list.add("id h???p ?????ng");
        list.add("ng??y tr???");
        for (String string : list) {
            dcm.addElement(string);
        }
    }

    String convertdate(java.util.Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(utilDate);
    }

    void loadtablehoadon() {
        ArrayList<HoaDonTraXeViewModel> list = ser.getlistdata();
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        dtm.setRowCount(0);
        for (HoaDonTraXeViewModel h : list) {
            Object[] rowData = {
                h.getId(),
                h.getIdhd(),
                ser.getkh(h.getIdhd()).getTen(),
                convertdate(h.getNgaytra()),
                returnStatus(h.getTinhtrang()),
                h.getPhiphatsinh(),
                h.getTongtien(),};
            dtm.addRow(rowData);
        }
    }

    String returnStatus(int status) {
        switch (status) {
            case 0 -> {
                return "ch??a tr???";
            }
            case 1 -> {
                return "???? ho??n th??nh";
            }
            default -> {
                return "false";
            }
        }
    }

    void loadtablehopdong() {
        ArrayList<HopDongViewModel> list = ser.getlisthd();
        DefaultTableModel dtm = (DefaultTableModel) tblhopdong.getModel();
        dtm.setRowCount(0);
        for (HopDongViewModel h : list) {
            Object[] rowData = {
                h.getId(),
                h.getIdnv(),
                convertdate(h.getNgaytao()),
                convertdate(h.getNgayhethan()),
                h.getTinhTrangXe()
            };
            dtm.addRow(rowData);
        }
    }

    public HoaDonTraXeModel getformdata() {
        if (txtngaytra.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "ko dc de trong ngay tra");
            return null;
        } else if (txtphiphatsinh.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "ko dc de trong phi phat sinh");
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            HoaDonTraXeModel hdhtm = new HoaDonTraXeModel();
            hdhtm.setId(txtid.getText());
            HopDongModel hdm = new HopDongModel();
            hdm.setId(txtidhd1.getText());
            KhachHangModel khm = new KhachHangModel();
            khm.setId(txtidkh1.getText());
            hdm.setKhm(khm);
            hdhtm.setHdm(hdm);
            hdhtm.setNgaytra(sdf.parse(txtngaytra.getText()));
            if (rdodatra.isSelected()) {
                hdhtm.setTinhtrang(1);
            } else {
                hdhtm.setTinhtrang(0);
            }
            try {
                hdhtm.setPhiphatsinh(Double.parseDouble(txtphiphatsinh.getText()));
            } catch (NumberFormatException ex) {
                System.out.println("sai ?????nh d???ng ph?? ph??t sinh");
                return null;
            }
            hdhtm.setTongtien(Double.parseDouble(txttongtien.getText()));
            return hdhtm;
        } catch (ParseException ex) {
            ex.printStackTrace();
            System.out.println("null getformdata");
            return null;
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonTraXeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonTraXeUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQR;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnreload;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnselect3;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbloai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdochuatra;
    private javax.swing.JRadioButton rdodatra;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JTable tblhopdong;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidhd1;
    private javax.swing.JTextField txtidhd2;
    private javax.swing.JTextField txtidkh1;
    private javax.swing.JTextField txtidkh2;
    private javax.swing.JTextField txtngayhethan;
    private javax.swing.JTextField txtngaytao;
    private javax.swing.JTextField txtngaytra;
    private javax.swing.JTextField txtphiphatsinh;
    private javax.swing.JTextField txttenkh1;
    private javax.swing.JTextField txttenkh2;
    private javax.swing.JTextField txttennv;
    private javax.swing.JTextField txttinhtrang2;
    private javax.swing.JTextField txttongtien;
    private javax.swing.JTextField txtvalue;
    // End of variables declaration//GEN-END:variables
}
