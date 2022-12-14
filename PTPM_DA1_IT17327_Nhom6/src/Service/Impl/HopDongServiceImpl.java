/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Model.ChiTietHopDongModel;
import Model.ChiTietXeModel;
import Model.HopDongModel;
import Model.KhachHangModel;
import Model.NhanVienModel;
import Repository.HopDongRepo;
import Service.HopDongService;
import ViewModel.ChiTietHopDongViewModel;
import ViewModel.HopDongViewModel;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class HopDongServiceImpl implements HopDongService{
    private HopDongRepo hopDongRepo= new HopDongRepo();

    @Override
    public ArrayList<HopDongViewModel> getList() {
        return hopDongRepo.getList();
    }

    @Override
    public ArrayList<String> getCbNhanVien() {
        return hopDongRepo.getCbNV();
    }

    @Override
    public ArrayList<String> getCbKhachHang() {
        return hopDongRepo.getCbKH();
    }

    @Override
    public Boolean add(HopDongModel hopDongModel) {
        return hopDongRepo.add(hopDongModel);
    }

    @Override
    public Boolean delete(String id) {
        return hopDongRepo.deleteHopDong(id);
    }

    @Override
    public Boolean update(HopDongModel hopDongModel, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean findbyName(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String tenNhanVien(String id) {
        return hopDongRepo.tenNhanVien(id);
    }

    @Override
    public String tenKhachHang(String id) {
        return hopDongRepo.tenKhachHang(id);
    }

    @Override
    public ArrayList<ChiTietHopDongViewModel> getListChiTiet() {
        return hopDongRepo.getListChiTiet();
    }

    @Override
    public String tenXe(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean addChiTiet(ChiTietHopDongModel chiTietHopDongModel) {
        return hopDongRepo.addChiTiet(chiTietHopDongModel);
    }

    @Override
    public Boolean DeleteChiTiet(String idhd) {
        return hopDongRepo.DeleteChiTiet(idhd);

    }

    @Override
    public ArrayList<String> getCbid() {
        return hopDongRepo.getCbid();
    }

    @Override
    public ArrayList<String> getCbHd() {
        return hopDongRepo.getCbHD();
    }

    @Override
    public Boolean updateChiTiet(ChiTietHopDongModel chiTietHopDongModel, String idhd) {
        return hopDongRepo.updateChiTiet(chiTietHopDongModel, idhd);
    }

    @Override
    public Boolean findHDbyId(String idhd) {
        return hopDongRepo.findHdById(idhd);
    }

    @Override
    public String idnhanvien(String ten) {
        return hopDongRepo.idnhanvien(ten);
    }

    @Override
    public String idkhachhang(String ten) {
        return hopDongRepo.idkhachhang(ten);
    }

    
    
}
