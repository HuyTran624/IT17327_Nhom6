/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhanVienModel;
import ViewModel.NhanVienViewModel;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public interface NhanVienService {
    public Boolean them(NhanVienViewModel nhanVienViewModel);

    public Boolean xoa(String index);

    public ArrayList<NhanVienViewModel> timKiem(String ten);

    public Boolean update(String index ,NhanVienViewModel nhanVienViewModel);

    public ArrayList<NhanVienViewModel> getList();
}
