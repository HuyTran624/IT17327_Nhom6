
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDonHoanTraModel;
import Utilities.DBConnections_cho_binh;
import ViewModel.HoaDonHoanTraViewModel;
import ViewModel.ChiTietXeViewModel;
import ViewModel.HopDongViewModel;
import ViewModel.KhachHangViewModel;
import java.util.ArrayList;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author lilyp
 */
public class HoaDonHoanTraRepo {

    public ArrayList<HoaDonHoanTraViewModel> getlistdata() {
        try {
            ArrayList<HoaDonHoanTraViewModel> list = new ArrayList<>();
            String sql = "select id,idkh,idhopdong,ngaytra,dongia,soluong,tinhtrang,phiphatsinh from hoadonhoantra";
            Connection conn = DBConnections_cho_binh.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonHoanTraViewModel hdhtvm = new HoaDonHoanTraViewModel();
                hdhtvm.setId(rs.getString(1));
                hdhtvm.setIdkh(rs.getString(2));
                hdhtvm.setIdhd(rs.getString(3));
                hdhtvm.setNgaytra(rs.getDate(4));
                hdhtvm.setDongia(rs.getDouble(5));
                hdhtvm.setSoluong(rs.getInt(6));
                hdhtvm.setTinhtrang(rs.getInt(7));
                hdhtvm.setPhiphatsinh(rs.getDouble(8));
                list.add(hdhtvm);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public KhachHangViewModel getkh(String idhd) {
        try ( Connection conn = DBConnections_cho_binh.getConnection()) {
            String sql = "select khachhang.id,ten from khachhang join hopdong on khachhang.id = hopdong.idkh where hopdong.id = convert(uniqueidentifier,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idhd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangViewModel khvm = new KhachHangViewModel();
                khvm.setId(rs.getString(1));
                khvm.setTen(rs.getString(2));
                return khvm;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<HopDongViewModel> getlisthd() {
        try ( Connection conn = DBConnections_cho_binh.getConnection()) {
            ArrayList<HopDongViewModel> list = new ArrayList<>();
            String sql = "select hopdong.id,idnv,idkh,ngaytao,ngayhethan,tinhtrang,ten from hopdong join khachhang on hopdong.idkh = khachhang.id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HopDongViewModel hdvm = new HopDongViewModel();
                hdvm.setId(rs.getString(1));
                hdvm.setIdkh(rs.getString(3));
                hdvm.setIdnv(rs.getString(2));
                hdvm.setNgayTao(rs.getDate(4));
                hdvm.setNgayHetHan(rs.getDate(5));
                hdvm.setTinhTrangXe(rs.getInt(6));
                list.add(hdvm);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean insert(HoaDonHoanTraModel hdhtm) {
        try ( Connection conn = DBConnections_cho_binh.getConnection()) {
            String sql = "insert into hoadonhoantra(id,idkh,idhopdong,ngaytra,dongia,soluong,tinhtrang,phiphatsinh) values(convert(uniqueidentifier,?),convert(uniqueidentifier,?),convert(uniqueidentifier,?),?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdhtm.getId());
            ps.setString(2, hdhtm.getKhm().getId());
            ps.setString(3, hdhtm.getHdm().getId());
            ps.setDate(4, new java.sql.Date(hdhtm.getNgaytra().getTime()));
            ps.setDouble(5, hdhtm.getDongia());
            ps.setInt(6, hdhtm.getSoluong());
            ps.setInt(7, hdhtm.getTinhtrang());
            ps.setDouble(8, hdhtm.getPhiphatsinh());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(HoaDonHoanTraModel hdhtm) {
        try ( Connection conn = DBConnections_cho_binh.getConnection()) {
            String sql = "update hoadonhoantra set idkh = convert(uniqueidentifier,?),idhopdong = convert(uniqueidentifier,?),ngaytra = ?, dongia = ?, soluong = ?, tinhtrang = ?, phiphatsinh = ? where id = convert(uniqueidentifier,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdhtm.getKhm().getId());
            ps.setString(2, hdhtm.getHdm().getId());
            ps.setDate(3, new java.sql.Date(hdhtm.getNgaytra().getTime()));
            ps.setDouble(4, hdhtm.getDongia());
            ps.setInt(5, hdhtm.getSoluong());
            ps.setInt(6, hdhtm.getTinhtrang());
            ps.setDouble(7, hdhtm.getPhiphatsinh());
            ps.setString(8, hdhtm.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(HoaDonHoanTraModel hdhtm) {
        try ( Connection conn = DBConnections_cho_binh.getConnection()) {
            String sql = "delete from hoadonhoantra where id = convert(uniqueidentifier,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdhtm.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}