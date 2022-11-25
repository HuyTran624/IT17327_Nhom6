package View;

import Model.HoaDonTraXeModel;
import Model.HopDongModel;
import Model.KhachHangModel;
import Repository.HoaDonTraXeRepo;
import ViewModel.HoaDonTraXeViewModel;
import ViewModel.HopDongViewModel;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public final class MainUI extends javax.swing.JFrame {

    private final HoaDonTraXeRepo traxerepo = new HoaDonTraXeRepo();

    // VIẾT CODE Ở DƯỚI NÀY!!!
    public MainUI() {
        initComponents();
        firstLoad();
    }

    void firstLoad() {
        loadcbbtimkiemhoadon();
        loadtablehoadon();
        loadtablehopdong12();
        removeColumn();
    }

    void removeColumn() {
        tblhoadon.removeColumn(tblhoadon.getColumnModel().getColumn(5));
        tblhoadon.removeColumn(tblhoadon.getColumnModel().getColumn(5));
        tblhoadon.removeColumn(tblhoadon.getColumnModel().getColumn(5));
        tblhopdong12.removeColumn(tblhopdong12.getColumnModel().getColumn(6));
        tblhopdong12.removeColumn(tblhopdong12.getColumnModel().getColumn(6));
    }

    void loadcbbtimkiemhoadon() {
        ArrayList<String> list = new ArrayList<>();
        list.add("tên khách hàng");
        list.add("ngày trả");
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) cbbsearchcategoryhoadon.getModel();
        dcm.removeAllElements();
        for (String string : list) {
            dcm.addElement(string);
        }
    }

    ;
    
    String convertdate(java.util.Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(utilDate);
    }

    void loadtablehoadon() {
        ArrayList<HoaDonTraXeViewModel> list = traxerepo.getlistdata();
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        dtm.setRowCount(0);
        for (HoaDonTraXeViewModel h : list) {
            Object[] rowData = {
                traxerepo.getkh(h.getIdhd()).getTen(),
                convertdate(h.getNgaytra()),
                h.getTinhtrang() == 0 ? "đã trả" : "chưa trả",
                h.getPhiphatsinh(),
                h.getTongtien(),
                h.getId(),
                h.getIdhd(),
                h.getIdkh(),
            };
            dtm.addRow(rowData);
        }
    }
    
    void loadtablehopdong12() {
        ArrayList<HopDongViewModel> list = traxerepo.getlisthd();
        DefaultTableModel dtm = (DefaultTableModel) tblhopdong12.getModel();
        dtm.setRowCount(0);
        for (HopDongViewModel h : list) {
            Object[] rowData = {
                h.getId(),
                traxerepo.getkh(h.getId()).getTen(),
                traxerepo.getnv(h.getIdnv()),
                h.getTinhTrangXe() == 0 ? "0" : "1",
                convertdate(h.getNgaytao()),
                convertdate(h.getNgayhethan()),
                h.getIdkh(),
                h.getIdnv()
            };
            dtm.addRow(rowData);
        }
    }

    void pre_test() {
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        System.out.println(dtm.getValueAt(0, 5));
        System.out.println(dtm.getValueAt(0, 6));
    }

    HoaDonTraXeModel gethoadonformdata() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        HoaDonTraXeModel hdtxm = new HoaDonTraXeModel();

        KhachHangModel khm = new KhachHangModel();
        khm.setId(txtidkhachhang12.getText());

        HopDongModel hdm = new HopDongModel();
        hdm.setId(txtidhopdong11.getText());
        try {
            hdm.setNgayHetHan(sdf.parse(txtngayhethan12.getText()));
            hdm.setNgayTao(sdf.parse(txtngaytao12.getText()));
            hdtxm.setNgaytra(sdf.parse(txtngaytra.getText()));
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
        try {
            hdtxm.setPhiphatsinh(Double.parseDouble(txtphuphi.getText()));
            hdtxm.setTongtien(Double.parseDouble(txttongtien11.getText()));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "sai dinh dang phu phi");
            return null;
        }
        if (rdochuatra.isSelected()) {
            hdtxm.setTinhtrang(0);
        } else {
            hdtxm.setTinhtrang(1);
        }
        hdm.setKhm(khm);
        hdtxm.setHdm(hdm);
        return hdtxm;
    }

    void openFileExplorer(String filename) {
        try {
            String pathname = "D:\\fpt\\QRCode\\" + filename;
            File file = new File(pathname);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //KHÔNG VIẾT CODE Ở BÊN DƯỚI!!!
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tinhtranghoadon = new javax.swing.ButtonGroup();
        tinhtranghopdong12 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        txtidhopdong11 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttenkhachhang11 = new javax.swing.JTextField();
        txtngaytra = new javax.swing.JTextField();
        txtphuphi = new javax.swing.JTextField();
        rdodatra = new javax.swing.JRadioButton();
        rdochuatra = new javax.swing.JRadioButton();
        txttongtien11 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        btnthemhoadon = new javax.swing.JButton();
        btnsuahoadon = new javax.swing.JButton();
        btnQR = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtsearchvaluehoadon = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbbsearchcategoryhoadon = new javax.swing.JComboBox<>();
        lblsearchcounthoadon = new javax.swing.JLabel();
        btnsearchhoadon = new javax.swing.JButton();
        btnreload = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();
        txtidkhachhang11 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtidhopdong12 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txttenkhachhang12 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txttennhanvien12 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtngaytao12 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtngayhethan12 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        rdo0 = new javax.swing.JRadioButton();
        rdo1 = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblhopdong12 = new javax.swing.JTable();
        btnselecthopdong = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtidkhachhang12 = new javax.swing.JTextField();
        txtidnhanvien12 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("thuê xe", jPanel1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("tất cả", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("rảnh rỗi", jPanel8);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("đang dc thuê", jPanel9);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("xe", jPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("khách hàng", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txtidhopdong11.setEditable(false);

        jLabel1.setText("id hợp đồng");

        jLabel2.setText("tên khách hàng");

        jLabel3.setText("ngày trả");

        jLabel4.setText("tình trạng");

        jLabel5.setText("phụ phí");

        jLabel6.setText("tổng tiền");

        txttenkhachhang11.setEditable(false);

        txtphuphi.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtphuphiCaretUpdate(evt);
            }
        });

        tinhtranghoadon.add(rdodatra);
        rdodatra.setText("đã trả");

        tinhtranghoadon.add(rdochuatra);
        rdochuatra.setSelected(true);
        rdochuatra.setText("chưa trả");

        txttongtien11.setEditable(false);

        jPanel10.setBackground(new java.awt.Color(204, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), null));

        btnthemhoadon.setText("thêm");
        btnthemhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemhoadonActionPerformed(evt);
            }
        });

        btnsuahoadon.setText("sửa");
        btnsuahoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuahoadonActionPerformed(evt);
            }
        });

        btnQR.setText("QR");
        btnQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQRActionPerformed(evt);
            }
        });

        jLabel7.setText("search");

        jPanel11.setBackground(new java.awt.Color(204, 204, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 255), null));

        jLabel8.setText("giá trị");

        jLabel9.setText("loại");

        cbbsearchcategoryhoadon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblsearchcounthoadon.setText("tìm thấy x");

        btnsearchhoadon.setText("tìm kiếm");
        btnsearchhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchhoadonActionPerformed(evt);
            }
        });

        btnreload.setText("reload");
        btnreload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(lblsearchcounthoadon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(btnreload)
                        .addGap(29, 29, 29)
                        .addComponent(btnsearchhoadon))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsearchvaluehoadon)
                            .addComponent(cbbsearchcategoryhoadon, 0, 290, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearchvaluehoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbbsearchcategoryhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsearchcounthoadon)
                    .addComponent(btnsearchhoadon)
                    .addComponent(btnreload))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnthemhoadon)
                        .addGap(45, 45, 45)
                        .addComponent(btnsuahoadon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(btnQR)
                        .addGap(26, 26, 26))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemhoadon)
                    .addComponent(btnsuahoadon)
                    .addComponent(btnQR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "tên khách hàng", "ngày trả", "tình trạng", "phụ phí", "tổng tiền", "id hóa đơn", "id hợp đồng", "idkh"
            }
        ));
        tblhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhoadonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblhoadon);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtidhopdong11, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rdodatra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(rdochuatra))
                            .addComponent(txttenkhachhang11)
                            .addComponent(txtngaytra)
                            .addComponent(txtphuphi)
                            .addComponent(txttongtien11))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtidkhachhang11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidhopdong11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txttenkhachhang11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rdodatra)
                            .addComponent(rdochuatra))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtphuphi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txttongtien11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(txtidkhachhang11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("hóa đơn", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("id hợp đồng");

        jLabel11.setText("tên khách hàng");

        jLabel12.setText("tên nhân viên");

        jLabel13.setText("ngày tạo");

        jLabel14.setText("ngày hết");

        jLabel15.setText("tinh trang");

        tinhtranghopdong12.add(rdo0);
        rdo0.setSelected(true);
        rdo0.setText("0");

        tinhtranghopdong12.add(rdo1);
        rdo1.setText("1");

        tblhopdong12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id hợp đồng", "tên khách hàng", "tên nhân viên", "tình trạng", "ngày tạo", "ngày hết hạn", "idkh", "idnv"
            }
        ));
        tblhopdong12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhopdong12MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblhopdong12);

        btnselecthopdong.setText("select");
        btnselecthopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselecthopdongActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 255)));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel16.setText("tìm kiếm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidhopdong12, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txttenkhachhang12, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttennhanvien12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(rdo0)
                                        .addGap(48, 48, 48)
                                        .addComponent(rdo1)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtngaytao12)
                                    .addComponent(txtngayhethan12))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(109, 109, 109))
                            .addComponent(btnselecthopdong, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtidkhachhang12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(txtidnhanvien12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtidhopdong12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txttenkhachhang12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtngaytao12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txttennhanvien12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtngayhethan12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnselecthopdong))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(rdo0)
                    .addComponent(rdo1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidkhachhang12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidnhanvien12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("hợp đồng", jPanel6);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("hóa đơn", jPanel4);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("hợp đồng", jPanel12);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("bảo dưỡng", jPanel13);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("nhân viên", jPanel14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemhoadonActionPerformed
        HoaDonTraXeModel hdtxm = gethoadonformdata();
        if (hdtxm == null) {
            return;
        }
        hdtxm.setId(UUID.randomUUID().toString());
        boolean insert = traxerepo.insert(hdtxm);
        if (insert) {
            JOptionPane.showMessageDialog(this, "insert thành cmn công");
        } else {
            JOptionPane.showMessageDialog(this, "insert thất cmn bại");
        }
        loadtablehoadon();
    }//GEN-LAST:event_btnthemhoadonActionPerformed

    private void btnsuahoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuahoadonActionPerformed
        HoaDonTraXeModel hdtxm = gethoadonformdata();
        if (hdtxm == null) {
            return;
        }
        boolean update = traxerepo.update(hdtxm);
        if (update) {
            JOptionPane.showMessageDialog(this, "update thành cmn công");
        } else {
            JOptionPane.showMessageDialog(this, "update thất cmn bại");
        }
        loadtablehoadon();
    }//GEN-LAST:event_btnsuahoadonActionPerformed

    private void btnQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQRActionPerformed
        FileOutputStream fos = null;
        try {
            int row = tblhoadon.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "chưa có hàng nào được lựa chọn");
                return;
            }
            String f_name = "id hoa don: " + tblhoadon.getValueAt(row, 0) + "\nten khach hang: " + tblhoadon.getValueAt(row, 2) + "\nid hop dong"
                    + tblhoadon.getValueAt(row, 1) + "\nngay tra: " + tblhoadon.getValueAt(row, 3)
                    + "\ntinh trang: " + tblhoadon.getValueAt(row, 4) + "\nphi phat sinh: " + (tblhoadon.getValueAt(row, 5).equals("chưa trả") ? 0 : 1) + "\ntong tien: " + tblhoadon.getValueAt(row, 6);
            ByteArrayOutputStream out = QRCode.from(f_name).to(ImageType.PNG).stream();
            String path = "D:\\fpt\\QRCode\\";
            String filename = UUID.randomUUID().toString() + ".PNG";
            fos = new FileOutputStream(new File(path + filename));
            fos.write(out.toByteArray());
            fos.flush();
            openFileExplorer(filename);
        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnQRActionPerformed

    private void btnreloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreloadActionPerformed
        loadtablehoadon();
    }//GEN-LAST:event_btnreloadActionPerformed

    private void btnsearchhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchhoadonActionPerformed
        int category = cbbsearchcategoryhoadon.getSelectedIndex();
        String value = txtsearchvaluehoadon.getText();
        ArrayList<HoaDonTraXeViewModel> list = traxerepo.getlistdata();
        ArrayList<HoaDonTraXeViewModel> final_list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        switch (category) {
            case 0 -> {
                for (HoaDonTraXeViewModel hoaDonHoanTraViewModel : list) {
                    if (value.equalsIgnoreCase(traxerepo.getkh(hoaDonHoanTraViewModel.getIdhd()).getTen())) {
                        final_list.add(hoaDonHoanTraViewModel);
                    }
                }
            }
            case 1 -> {
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
        lblsearchcounthoadon.setText("tìm thấy" + final_list.size());
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        dtm.setRowCount(0);
        for (HoaDonTraXeViewModel h : final_list) {
            Object[] rowData = {
                h.getId(),
                h.getIdhd(),
                traxerepo.getkh(h.getIdhd()).getTen(),
                convertdate(h.getNgaytra()),
                h.getTinhtrang() == 0 ? "đã trả" : "chưa trả",
                h.getPhiphatsinh(),
                h.getTongtien()
            };
            dtm.addRow(rowData);
        }
    }//GEN-LAST:event_btnsearchhoadonActionPerformed

    private void btnselecthopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselecthopdongActionPerformed
        txtidhopdong11.setText(txtidhopdong12.getText());
        txttenkhachhang11.setText(txttenkhachhang12.getText());
        txtidkhachhang11.setText(txtidkhachhang12.getText());
    }//GEN-LAST:event_btnselecthopdongActionPerformed

    private void tblhopdong12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhopdong12MouseClicked
        int row = tblhopdong12.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) tblhopdong12.getModel();
        txtidhopdong12.setText(dtm.getValueAt(row, 0).toString());
        txttenkhachhang12.setText(dtm.getValueAt(row, 1).toString());
        txttennhanvien12.setText(dtm.getValueAt(row, 2).toString());
        if(dtm.getValueAt(row, 3).toString().equalsIgnoreCase("0")){
            rdo0.setSelected(true);
        }else{
            rdo1.setSelected(true);
        }
        txtngaytao12.setText(dtm.getValueAt(row, 4).toString());
        txtngayhethan12.setText(dtm.getValueAt(row, 5).toString());
        txtidkhachhang12.setText(dtm.getValueAt(row, 6).toString());
        txtidnhanvien12.setText(dtm.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tblhopdong12MouseClicked

    private void tblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonMouseClicked
        int row = tblhoadon.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        txtidhopdong11.setText(dtm.getValueAt(row, 6).toString());
        txttenkhachhang11.setText(dtm.getValueAt(row, 0).toString());
        txtidkhachhang11.setText(dtm.getValueAt(row, 7).toString());
        txtngaytra.setText(dtm.getValueAt(row, 1).toString());
        if(dtm.getValueAt(row, 2).toString().equalsIgnoreCase("đã trả")){
            rdodatra.setSelected(true);
        }else{
            rdochuatra.setSelected(true);
        }
        txtphuphi.setText(dtm.getValueAt(row, 3).toString());
        txttongtien11.setText(dtm.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblhoadonMouseClicked

    private void txtphuphiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtphuphiCaretUpdate
        try {
            double tienthuexe = traxerepo.tienthuexe(txtidhopdong11.getText().trim());
            if (txtidhopdong11.getText().equalsIgnoreCase("")) {
                txttongtien11.setText(String.valueOf(tienthuexe));
                return;
            }
            double phiphatsinh = Double.parseDouble(txtphuphi.getText());
            if (phiphatsinh == 0) {
                txttongtien11.setText(String.valueOf(tienthuexe));
            }
            txttongtien11.setText(String.valueOf(tienthuexe + phiphatsinh));
        } catch (NumberFormatException ex) {
            return;
        }
    }//GEN-LAST:event_txtphuphiCaretUpdate

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MainUI().setVisible(true);
        });
    }
    //KHÔNG VIẾT CODE Ở ĐÂY!!!

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQR;
    private javax.swing.JButton btnreload;
    private javax.swing.JButton btnsearchhoadon;
    private javax.swing.JButton btnselecthopdong;
    private javax.swing.JButton btnsuahoadon;
    private javax.swing.JButton btnthemhoadon;
    private javax.swing.JComboBox<String> cbbsearchcategoryhoadon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblsearchcounthoadon;
    private javax.swing.JRadioButton rdo0;
    private javax.swing.JRadioButton rdo1;
    private javax.swing.JRadioButton rdochuatra;
    private javax.swing.JRadioButton rdodatra;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JTable tblhopdong12;
    private javax.swing.ButtonGroup tinhtranghoadon;
    private javax.swing.ButtonGroup tinhtranghopdong12;
    private javax.swing.JTextField txtidhopdong11;
    private javax.swing.JTextField txtidhopdong12;
    private javax.swing.JTextField txtidkhachhang11;
    private javax.swing.JTextField txtidkhachhang12;
    private javax.swing.JTextField txtidnhanvien12;
    private javax.swing.JTextField txtngayhethan12;
    private javax.swing.JTextField txtngaytao12;
    private javax.swing.JTextField txtngaytra;
    private javax.swing.JTextField txtphuphi;
    private javax.swing.JTextField txtsearchvaluehoadon;
    private javax.swing.JTextField txttenkhachhang11;
    private javax.swing.JTextField txttenkhachhang12;
    private javax.swing.JTextField txttennhanvien12;
    private javax.swing.JTextField txttongtien11;
    // End of variables declaration//GEN-END:variables
}
