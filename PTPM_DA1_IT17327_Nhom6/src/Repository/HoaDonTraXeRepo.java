
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDonTraXeModel;
import Utilities.DBConnections1;
import ViewModel.HoaDonTraXeViewModel;
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
public class HoaDonTraXeRepo {

    public ArrayList<HoaDonTraXeViewModel> getlistdata() {
        try {
            ArrayList<HoaDonTraXeViewModel> list = new ArrayList<>();
            String sql = "select id,idkh,idhopdong,ngaytra,soluong,tinhtrang,phiphatsinh,thanhtien from hoadontraxe";
            Connection conn = DBConnections1.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonTraXeViewModel hdhtvm = new HoaDonTraXeViewModel();
                hdhtvm.setId(rs.getString(1));
                hdhtvm.setIdkh(rs.getString(2));
                hdhtvm.setIdhd(rs.getString(3));
                hdhtvm.setNgaytra(rs.getDate(4));
                hdhtvm.setSoluong(rs.getInt(5));
                hdhtvm.setTinhtrang(rs.getInt(6));
                hdhtvm.setPhiphatsinh(rs.getDouble(7));
                hdhtvm.setTongtien(rs.getDouble(8));
                list.add(hdhtvm);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public KhachHangViewModel getkh(String idhd) {
        try ( Connection conn = DBConnections1.getConnection()) {
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
        try ( Connection conn = DBConnections1.getConnection()) {
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

    public boolean insert(HoaDonTraXeModel hdhtm) {
        try ( Connection conn = DBConnections1.getConnection()) {
            String sql = "insert into hoadontraxe(id,idkh,idhopdong,ngaytra,soluong,tinhtrang,phiphatsinh,tongtien) values(convert(uniqueidentifier,?),convert(uniqueidentifier,?),convert(uniqueidentifier,?),?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdhtm.getId());
            ps.setString(2, hdhtm.getKhm().getId());
            ps.setString(3, hdhtm.getHdm().getId());
            ps.setDate(4, new java.sql.Date(hdhtm.getNgaytra().getTime()));
            ps.setInt(5, hdhtm.getSoluong());
            ps.setInt(6, hdhtm.getTinhtrang());
            ps.setDouble(7, hdhtm.getPhiphatsinh());
            ps.setDouble(8, hdhtm.getTongtien());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(HoaDonTraXeModel hdhtm) {
        try ( Connection conn = DBConnections1.getConnection()) {
            String sql = "update hoadontraxe set idkh = convert(uniqueidentifier,?),idhopdong = convert(uniqueidentifier,?),ngaytra = ?, soluong = ?, tinhtrang = ?, phiphatsinh = ?, tongtien = ? where id = convert(uniqueidentifier,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdhtm.getKhm().getId());
            ps.setString(2, hdhtm.getHdm().getId());
            ps.setDate(3, new java.sql.Date(hdhtm.getNgaytra().getTime()));
            ps.setInt(4, hdhtm.getSoluong());
            ps.setInt(5, hdhtm.getTinhtrang());
            ps.setDouble(6, hdhtm.getPhiphatsinh());
            ps.setString(7, hdhtm.getId());
            ps.setDouble(8, hdhtm.getTongtien());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(HoaDonTraXeModel hdhtm) {
        try ( Connection conn = DBConnections1.getConnection()) {
            String sql = "delete from hoadontraxe where id = convert(uniqueidentifier,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdhtm.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public double tienthuexe(String idhd) {
        try ( Connection conn = DBConnections1.getConnection()) {
            double tienthuexe = 0;
            String sql = "select giathue from loaiXe join chiTietXe on loaiXe.id = chiTietXe.idLoai join chiTietHopDong on chiTietHopDong.bienSo = chiTietXe.bienSo join hopDong on hopDong.id = chiTietHopDong.idHopDong join hoaDonTraXe on hopDong.id = hoaDonTraXe.idHopDong where hopDong.id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idhd);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tienthuexe += rs.getDouble(1);
            }
            return tienthuexe;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
