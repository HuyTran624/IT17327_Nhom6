/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.KhachHangModel;
import Model.NhanVienModel;
import Utilities.DBConnections;
import ViewModel.HopDongViewModel;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author User
 */
public class HopDongRepo {
    private DBConnections connections;
    public ArrayList<HopDongViewModel> getList(){
        ArrayList<HopDongViewModel> listHopDongViewModels = new ArrayList<>();
        String sql = "Select id,idnv,idkh,ngaytao,ngayhethan,tinhtrang"
                + "From hopdong";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HopDongViewModel hopDongViewModel = new HopDongViewModel();
                hopDongViewModel.setId(rs.getString(1));
                hopDongViewModel.setIdnv(rs.getString(2));
                hopDongViewModel.setIdkh(rs.getString(3));
                hopDongViewModel.setNgaytao(rs.getDate(4));
                hopDongViewModel.setNgayhethan(rs.getDate(5));
                hopDongViewModel.setTinhTrangXe(rs.getInt(6));
                listHopDongViewModels.add(hopDongViewModel);
                
            }
        } catch (Exception e) {
        }
        return listHopDongViewModels;
    }
    public ArrayList<NhanVienModel> getCbNhanVien(){
        ArrayList<NhanVienModel> list = new ArrayList<>();
        String sql = "Select id,ten"
                + "From nhanvien";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVienModel nhanVienModel = new NhanVienModel();
                nhanVienModel.setId(rs.getString(1));
                nhanVienModel.setTen(rs.getString(2));
                list.add(nhanVienModel);
            }
            
        } catch (Exception e) {
        }
        return list;
}
    public ArrayList<KhachHangModel> getCbKhachHang(){
        ArrayList<KhachHangModel> list = new ArrayList<>();
        String sql = "Select id,ten"
                + "From khachhang";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHangModel khachHangModel = new KhachHangModel();
                khachHangModel.setId(rs.getString(1));
                khachHangModel.setTen(rs.getString(2));
                list.add(khachHangModel);
            }
            
        } catch (Exception e) {
        }
        return list;
    }
}
