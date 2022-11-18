/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author lilyp
 */
public class HoaDonHoanTraModel {
    private String id;
    private Date Ngaytra;
    private double dongia, phiphatsinh; 
    private int tinhtrang,soluong;
    
    private KhachHangModel khm;
    private HopDongModel hdm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNgaytra() {
        return Ngaytra;
    }

    public void setNgaytra(Date Ngaytra) {
        this.Ngaytra = Ngaytra;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getPhiphatsinh() {
        return phiphatsinh;
    }

    public void setPhiphatsinh(double phiphatsinh) {
        this.phiphatsinh = phiphatsinh;
    }

    public int getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public KhachHangModel getKhm() {
        return khm;
    }

    public void setKhm(KhachHangModel khm) {
        this.khm = khm;
    }

    public HopDongModel getHdm() {
        return hdm;
    }

    public void setHdm(HopDongModel hdm) {
        this.hdm = hdm;
    }
    
    
}
