/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nguye
 */
public class DangNhapModel {
    private String id;
    private String TaiKhoan;
    private String MatKhau;
    private String ChucVu;

    public DangNhapModel() {
    }

    public DangNhapModel(String id, String TaiKhoan, String MatKhau, String ChucVu) {
        this.id = id;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.ChucVu = ChucVu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }
    
    
    
}
