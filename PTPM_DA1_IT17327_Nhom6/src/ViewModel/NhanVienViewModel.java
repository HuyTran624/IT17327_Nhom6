/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;



/**
 *
 * @author nguye
 */
public class NhanVienViewModel {
    private String id;
    private String Ten;
    private String NgaySinh;
    private String sdt;
    private int GioiTinh;
    private String ChucVu;
    

    public NhanVienViewModel() {
    }

    public NhanVienViewModel(String id, String Ten, String NgaySinh, String sdt, int GioiTinh, String ChucVu) {
        this.id = id;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.sdt = sdt;
        this.GioiTinh = GioiTinh;
        this.ChucVu = ChucVu;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getId() {
        return id;
    }

    public String getTen() {
        return Ten;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    

    public String hienThiGioiTinh(){
        if (GioiTinh==0) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

}
