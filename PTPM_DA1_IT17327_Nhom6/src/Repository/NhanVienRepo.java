/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.DangNhapModel;
import Model.NhanVienModel;
import Utilities.DBConnections;
import ViewModel.DangNhapViewModel;
import ViewModel.NhanVienViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class NhanVienRepo {
    private DBConnections connection;

    public ArrayList<NhanVienViewModel> getNVFromDB() {
        ArrayList<NhanVienViewModel> listNV = new ArrayList<>();
        String sql = "select * from nhanVien";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                NhanVienViewModel nhanVienViewModel = new NhanVienViewModel();
                nhanVienViewModel.setId(rs.getString(1));
                nhanVienViewModel.setTen(rs.getString(2));
                nhanVienViewModel.setNgaySinh(rs.getString(3));
                nhanVienViewModel.setSdt(rs.getString(4));
                nhanVienViewModel.setGioiTinh(rs.getInt(5));
                nhanVienViewModel.setChucVu(rs.getString(6));
                listNV.add(nhanVienViewModel);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listNV;
    }
    public Boolean them(NhanVienViewModel nhanVienViewModel) {
        String query = "insert into nhanVien VALUES (?,?,?,?,?,?)";
        try {Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setObject(1, nhanVienViewModel.getId());
            ps.setObject(2, nhanVienViewModel.getTen());
            ps.setObject(3, nhanVienViewModel.getNgaySinh());
            ps.setObject(4, nhanVienViewModel.getSdt());
            ps.setObject(5, nhanVienViewModel.getGioiTinh());
            ps.setObject(6, nhanVienViewModel.getChucVu());
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.getMessage();
            
        }
        return false;
    }
    public Boolean update(String index, NhanVienViewModel nhanVienViewModel) {
        String sql = "update nhanVien set  ten = ?, ngaySinh = ?, sdt = ?, Gioitinh = ?, ChucVu = ? where id = ?";
        try {Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setObject(1, nhanVienViewModel.getTen());
            ps.setObject(2, nhanVienViewModel.getNgaySinh());
            ps.setObject(3, nhanVienViewModel.getSdt());
            ps.setObject(4, nhanVienViewModel.getGioiTinh());
            ps.setObject(5, nhanVienViewModel.getChucVu());
            ps.setObject(6, index);
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.getMessage();
            
        }
        return false;
    }
    public Boolean delete(String index){
        String sql = "delete from nhanVien where id = ?";
         try(Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
             
             ps.setObject(1, index);
             ps.executeUpdate();
             return true;
           
       }catch(Exception e){
           return false;
       }
    }
    public ArrayList<NhanVienViewModel> timKiem(String tim) {
        ArrayList<NhanVienViewModel> list = new ArrayList<>();
        
        String sql = "select * from nhanVien where ten like '%" + tim + "%'";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel();
                nv.setId(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setNgaySinh(rs.getString(3));
                nv.setSdt(rs.getString(4));
                nv.setGioiTinh(rs.getInt(5));
                nv.setChucVu(rs.getString(6));
                list.add(nv);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
}
}    
