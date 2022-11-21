/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChiTietHopDongModel;
import Model.ChiTietXeModel;
import Model.HopDongModel;
import Model.KhachHangModel;
import Model.NhanVienModel;
import Utilities.DBConnections;
import ViewModel.ChiTietHopDongViewModel;
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
        String sql = "Select id,idnv,idkh,ngaytao,ngayhethan,tinhtrang \n"
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
    public Boolean deleteHopDong(String id){
        String sql = "DELETE From hopdong where id = CONVERT(uniqueidentifier,?)";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,id);
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
        }
        return false;
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
    public Boolean add(HopDongModel hopDongModel){
        int checkInsert = 0;
        String sql = "INSERT INTO hopdong(id,idnv,idkh,ngaytao,ngayhethan,tinhtrang) values (CONVERT(uniqueidentifier,?),CONVERT(uniqueidentifier,?),CONVERT(uniqueidentifier,?),?,?,?)";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, hopDongModel.getId());
            ps.setObject(2,hopDongModel.getIdnv());
            ps.setObject(3, hopDongModel.getIdkh());
            ps.setDate(4, new java.sql.Date(hopDongModel.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(hopDongModel.getNgayHetHan().getTime()));
            ps.setInt(6, hopDongModel.getTinhTrang());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    public ArrayList<ChiTietHopDongViewModel> getListChiTiet(){
        ArrayList<ChiTietHopDongViewModel> listHopDongViewModels = new ArrayList<>();
        String sql = "SELECT idHopDong,idxe,dongia,soluong,tiencoc from chitiethopdong";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietHopDongViewModel chiTietHopDongViewModel = new ChiTietHopDongViewModel();
                chiTietHopDongViewModel.setIdhd(rs.getString(1));
                chiTietHopDongViewModel.setIdxe(rs.getString(2));
                chiTietHopDongViewModel.setDonGia(rs.getFloat(3));
                chiTietHopDongViewModel.setSoLuong(rs.getInt(4));
                chiTietHopDongViewModel.setTiencoc(rs.getFloat(5));
                listHopDongViewModels.add(chiTietHopDongViewModel);
                
            }
        } catch (Exception e) {
        }
        return listHopDongViewModels;
    }
    public Boolean addChiTiet(ChiTietHopDongModel chiTietHopDongModel){
        String sql ="INSERT INTO chitiethopdong(idHopDong,idxe,dongia,soluong,tiencoc) values (CONVERT(uniqueidentifier,?),CONVERT(uniqueidentifier,?),?,?,?)";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
           ps.setObject(1,chiTietHopDongModel.getIdhd());
           ps.setObject(2, chiTietHopDongModel.getIdxe());
           ps.setObject(3, chiTietHopDongModel.getDonGia());
           ps.setObject(4, chiTietHopDongModel.getSoLuong());
           ps.setObject(5, chiTietHopDongModel.getTienCoc());
           ps.executeUpdate();
           return true;
            
        } catch (Exception e) {
            return false;
        }
        
    }
    public Boolean DeleteChiTiet(String idhd){
        String sql = "DELETE FROM chitiethopdong where idHopDong = CONVERT(uniqueidentifier,?)";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idhd);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Boolean updateChiTiet(ChiTietHopDongModel chiTietHopDongModel,String idhd){
        String sql = "UPDATE chitiethopdong set idXe = convert(uniqueidentifier,?), dongia = ?, soluong = ?, tiencoc = ? where idHopDong = convert(uniqueidentifier,?)";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
           ps.setObject(1, chiTietHopDongModel.getIdxe());
           ps.setObject(2, chiTietHopDongModel.getDonGia());
           ps.setObject(3, chiTietHopDongModel.getSoLuong());
           ps.setObject(4, chiTietHopDongModel.getTienCoc());
           ps.setObject(5, idhd);
           ps.executeUpdate();
           return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    public String tenNhanVien(String id){
        String sql ="SELECT ten from nhanvien where id = CONVERT(uniqueidentifier,?)";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
                
            }
            return null;
        } catch (Exception e) {
        }
        return null;
    }
    public String idnhanvien(String ten){
        String sql = "Select id from nhanvien where ten = ?";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
                
            }
            return null;
        } catch (Exception e) {
        }
        return null;
    }
    public String idkhachhang(String ten){
        String sql = "Select id from khachhang where ten = ?";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
                
            }
            return null;
        } catch (Exception e) {
        }
        return null;
    }
    public String tenKhachHang(String id){
         String sql ="SELECT ten from khachhang where id = CONVERT(uniqueidentifier,?)";
         try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
                
            }
            return null;
        } catch (Exception e) {
        }
        return null;
    }
    public ArrayList<String> getCbid(){
        ArrayList<String> list = new ArrayList<>();
        String sql ="Select id from chitietxe";
          try(Connection con = connections.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String a = rs.getString(1);
                    list.add(a);
                }
                
            } catch (Exception e) {
            }
            return list;
        
    }
    public ArrayList<String> getCbHD(){
         ArrayList<String> list = new ArrayList<>();
        String sql ="Select id from hopdong";
          try(Connection con = connections.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String a = rs.getString(1);
                    list.add(a);
                }
                
            } catch (Exception e) {
            }
            return list;
}
    public ArrayList<String> getCbNV(){
        ArrayList<String> list = new ArrayList<>();
        String sql = "select ten from nhanvien";
         try(Connection con = connections.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String a = rs.getString(1);
                    list.add(a);
                }
                
            } catch (Exception e) {
            }
            return list;
}
      public ArrayList<String> getCbKH(){
        ArrayList<String> list = new ArrayList<>();
        String sql = "select ten from khachhang";
         try(Connection con = connections.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String a = rs.getString(1);
                    list.add(a);
                }
                
            } catch (Exception e) {
            }
            return list;
}
    
    public Boolean findHdById(String idhd){
        
        String sql = "SELECT * From chitiethopdong where idHopDong = CONVERT(uniqueidentifier,?)";
        
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, idhd);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietHopDongModel chiTietHopDongModel = new ChiTietHopDongModel();
                chiTietHopDongModel.setIdhd(rs.getString(1));
                chiTietHopDongModel.setIdxe(rs.getString(2));
                chiTietHopDongModel.setDonGia(rs.getFloat(3));
                chiTietHopDongModel.setSoLuong(rs.getInt(4));
                chiTietHopDongModel.setTienCoc(rs.getFloat(5));
                return null;
            }
            
        } catch (Exception e) {
        }
        return null;
    }
}
