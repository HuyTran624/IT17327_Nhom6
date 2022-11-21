/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public class ChiTietHopDongModel {
        private String idhd;
        private String idxe;
        private Float donGia;
        private int soLuong;
        private Float tienCoc;

    public ChiTietHopDongModel() {
    }

    public ChiTietHopDongModel(String idhd, String idxe, Float donGia, int soLuong, Float tienCoc) {
        this.idhd = idhd;
        this.idxe = idxe;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tienCoc = tienCoc;
    }

    public String getIdhd() {
        return idhd;
    }

    public void setIdhd(String idhd) {
        this.idhd = idhd;
    }

    public String getIdxe() {
        return idxe;
    }

    public void setIdxe(String idxe) {
        this.idxe = idxe;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Float getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(Float tienCoc) {
        this.tienCoc = tienCoc;
    }
        
}
