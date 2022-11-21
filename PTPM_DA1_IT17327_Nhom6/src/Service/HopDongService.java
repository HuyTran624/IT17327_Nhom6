/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.ChiTietHopDongModel;
import java.util.ArrayList;
import Model.ChiTietXeModel;
import Model.HopDongModel;
import Model.KhachHangModel;

import Model.NhanVienModel;
import ViewModel.ChiTietHopDongViewModel;

import ViewModel.HopDongViewModel;

/**
 *
 * @author User
 */
public interface HopDongService {
        public ArrayList<HopDongViewModel> getList();
        public ArrayList<String> getCbNhanVien();
        public ArrayList<String> getCbKhachHang();
        public String tenNhanVien(String id);
        public String tenKhachHang(String id);
        public String idnhanvien(String ten);
        public String idkhachhang(String ten);
        public Boolean add(HopDongModel hopDongModel);
        public Boolean delete(String id);
        public Boolean update (HopDongModel hopDongModel,String id);
        public Boolean findbyName(String ten);
        public ArrayList<ChiTietHopDongViewModel> getListChiTiet();
        public ArrayList<String> getCbid();
        public ArrayList<String> getCbHd();
        public Boolean addChiTiet(ChiTietHopDongModel chiTietHopDongModel);
        public Boolean DeleteChiTiet(String idhd);
        public Boolean updateChiTiet(ChiTietHopDongModel chiTietHopDongModel,String idhd);
        public Boolean findHDbyId(String idhd);
        public String tenXe(String id);
}
