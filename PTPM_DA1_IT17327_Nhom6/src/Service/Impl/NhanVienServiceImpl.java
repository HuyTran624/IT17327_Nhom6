/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Model.NhanVienModel;
import Repository.NhanVienRepo;
import ViewModel.NhanVienViewModel;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class NhanVienServiceImpl implements Service.NhanVienService{
    private NhanVienRepo nhanVienRepo = new NhanVienRepo();

    @Override
    public Boolean them(NhanVienViewModel nhanVienViewModel) {
        return nhanVienRepo.them(nhanVienViewModel);
    }

    @Override
    public Boolean xoa(String index) {
        return nhanVienRepo.delete(index);
    }

    @Override
    public ArrayList<NhanVienViewModel> timKiem(String ten) {
        return nhanVienRepo.timKiem(ten);
    }

    @Override
    public Boolean update(String index, NhanVienViewModel nhanVienViewModel) {
        return nhanVienRepo.update(index, nhanVienViewModel);
    }

    @Override
    public ArrayList<NhanVienViewModel> getList() {
        return nhanVienRepo.getNVFromDB();
    }

    
    
    
    
}
