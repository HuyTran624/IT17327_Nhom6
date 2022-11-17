/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.ArrayList;
import Model.ChiTietXeModel;
import Model.HopDongModel;
import Model.KhachHangModel;

import Model.NhanVienModel;

import ViewModel.HopDongViewModel;

/**
 *
 * @author User
 */
public interface HopDongService {
        public ArrayList<HopDongViewModel> getHopDong();
        public ArrayList<NhanVienModel> getCbNhanVien();
        public ArrayList<KhachHangModel> getCbKhachHang();
       
        public Boolean add(HopDongModel hopDongModel);
        public Boolean delete(String id);
        public Boolean update (HopDongModel hopDongModel,String id);
        public Boolean findbyName(String ten);
}
