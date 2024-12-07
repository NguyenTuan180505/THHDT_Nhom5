import BanHang.HOADON;
import DanhSach.DanhSachHoaDon;
import DanhSach.DanhSachTaiKhoan;
import TaiKhoan.NHANVIENBANHANG;
import TaiKhoan.PERSON;
import Enum.VAITRO;
import Enum.TrangThai;

import java.time.LocalDate;

public class Lab {
    public static void main(String[] args) {
//        DanhSachTaiKhoan ds = new DanhSachTaiKhoan();
//        try {
//            ds.docFile();
//
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//
//
//        ds.Xuat();
//        PERSON person = new PERSON();
//        person.setId("123");
//        person.setRole(VAITRO.NGUOIQUANTRI);
//        person.setEmail("admin@gmail.com");
//        person.setPassword("123");
//        ds.themTK(person);
//        try {
//            ds.ghiFile();
//
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
        DanhSachHoaDon danhSachHoaDon = new DanhSachHoaDon();
        try {
            danhSachHoaDon.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }

//        HOADON hoadon = new HOADON();
//        hoadon.setNgayLap(LocalDate.of(2025, 11, 1));
//        hoadon.setTongTien(100000);
//        hoadon.setTrangThaiDH(TrangThai.GIAOTHANHCONG);
//        danhSachHoaDon.themHoaDon(hoadon);
        danhSachHoaDon.xuat();
        try {
            danhSachHoaDon.ghiFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
//
        NHANVIENBANHANG nhanvienbanhang = new NHANVIENBANHANG();
        nhanvienbanhang.thongKeDoangThu(2024);
//
////
//        DanhSach.DanhSachHoaDon danhSachHoaDon = new DanhSach.DanhSachHoaDon();
//        try {
//            danhSachHoaDon.docFile();
//
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//  for(BanHang.HOADON hoadon: danhSachHoaDon.getDsHoaDon()){
//      System.out.println(hoadon);
//  }

    }
}
