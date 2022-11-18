/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

<<<<<<< HEAD
import Model.*;
=======
>>>>>>> d8f254dd8ea954ed9152f2843ee961bd2c05585a
import java.util.Date;

/**
 *
 * @author User
 */
public class HopDongViewModel {
<<<<<<< HEAD
    private String id;
    private String idnv;
    private String idkh;
    private Date ngayTao;
    private Date ngayHetHan;
    private int tinhTrang;
=======
        private String id;
        private String idnv;
        private String idkh;
        private Date ngaytao;
        private Date ngayhethan;
        private int tinhTrangXe;
        
>>>>>>> d8f254dd8ea954ed9152f2843ee961bd2c05585a

    public HopDongViewModel() {
    }

<<<<<<< HEAD
    public HopDongViewModel(String id, String idnv, String idkh, Date ngayTao, Date ngayHetHan, int tinhTrang) {
        this.id = id;
        this.idnv = idnv;
        this.idkh = idkh;
        this.ngayTao = ngayTao;
        this.ngayHetHan = ngayHetHan;
        this.tinhTrang = tinhTrang;
=======
    public HopDongViewModel(String id, String idnv, String idkh, Date ngaytao, Date ngayhethan, int tinhTrangXe) {
        this.id = id;
        this.idnv = idnv;
        this.idkh = idkh;
        this.ngaytao = ngaytao;
        this.ngayhethan = ngayhethan;
        this.tinhTrangXe = tinhTrangXe;
>>>>>>> d8f254dd8ea954ed9152f2843ee961bd2c05585a
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

<<<<<<< HEAD
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
=======
    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(Date ngayhethan) {
        this.ngayhethan = ngayhethan;
>>>>>>> d8f254dd8ea954ed9152f2843ee961bd2c05585a
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
<<<<<<< HEAD
    
=======

    
    public String hienThiTinhTrang(){
        if (tinhTrangXe == 0) {
            return "chưa ký";
        }else
            return "đã ký";
    }
        
>>>>>>> d8f254dd8ea954ed9152f2843ee961bd2c05585a
}
