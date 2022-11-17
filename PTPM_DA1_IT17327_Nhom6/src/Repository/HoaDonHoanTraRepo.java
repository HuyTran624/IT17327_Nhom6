/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnections_cho_binh;
import ViewModel.HoaDonHoanTraViewModel;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lilyp
 */
public class HoaDonHoanTraRepo {
    public ArrayList<HoaDonHoanTraViewModel> getlistdata(){
        try {
            ArrayList<HoaDonHoanTraViewModel> list = new ArrayList<>();
            String sql = "select id,idkh,idhopdong,ngaytra,dongia,soluong,tinhtrang,phiphatsinh from hoadonhoantra";
            Connection conn = DBConnections_cho_binh.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
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
}
