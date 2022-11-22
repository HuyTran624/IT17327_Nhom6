/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.util.Date;

/**
 *
 * @author nguye
 */
public class NhanVienModel {
    private String id;
    private String Ten;
    private String NgaySinh;
    private String sdt;
    private int GioiTinh;
    private DangNhapModel dnm;

    public NhanVienModel() {
    }

    public NhanVienModel(String id, String Ten, String NgaySinh, String sdt, int GioiTinh, DangNhapModel dnm) {
        this.id = id;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.sdt = sdt;
        this.GioiTinh = GioiTinh;
        this.dnm = dnm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public DangNhapModel getDnm() {
        return dnm;
    }

    public void setDnm(DangNhapModel dnm) {
        this.dnm = dnm;
    }

    
    
    
    
}
