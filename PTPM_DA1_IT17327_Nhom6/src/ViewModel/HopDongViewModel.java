/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Model.*;
import java.util.Date;

/**
 *
 * @author User
 */
public class HopDongViewModel {
    private String id;
    private String idnv;
    private String idkh;
    private Date ngayTao;
    private Date ngayHetHan;
    private int tinhTrang;

    public HopDongViewModel() {
    }

    public HopDongViewModel(String id, String idnv, String idkh, Date ngayTao, Date ngayHetHan, int tinhTrang) {
        this.id = id;
        this.idnv = idnv;
        this.idkh = idkh;
        this.ngayTao = ngayTao;
        this.ngayHetHan = ngayHetHan;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getIdkh() {
        return idkh;
    }

    public void setIdkh(String idkh) {
        this.idkh = idkh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
}
