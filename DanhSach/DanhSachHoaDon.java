package DanhSach;

import BanHang.HOADON;
import BanHang.SANPHAM;
import ChiTiet.CHITIETHOADON;
import Interface.DocGhiFile;
import TaiKhoan.KHACHHANG;
import Enum.TrangThai;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DanhSachHoaDon implements DocGhiFile {
    List<HOADON> dsHoaDon = new ArrayList<HOADON>();
    @Override
    public void ghiFile() throws Exception {

        try (FileOutputStream fileOut = new FileOutputStream("HoaDon.txt");
             ObjectOutputStream objectOut =  new ObjectOutputStream(fileOut)) {

            // Ghi từng đối tượng vào file
            for (HOADON hoadon : this.dsHoaDon) {
                objectOut.writeObject(hoadon);
            }
            objectOut.flush();
            objectOut.close();

            System.out.println("Đã ghi thêm danh sách STAFF vào file HoaDon.txt");
        } catch (IOException ex) {
            System.out.println("Đã xảy ra lỗi khi ghi vào file: " + ex.getMessage());
        }
    }


    public List<HOADON> getDsHoaDon() {
        return dsHoaDon;
    }

    public void setDsHoaDon(List<HOADON> dsHoaDon) {
        this.dsHoaDon = dsHoaDon;
    }
@Override
    public void docFile() throws Exception {
        this.dsHoaDon = new ArrayList<>(); // Khởi tạo lại danh sách
        File file = new File("HoaDon.txt");
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + file.getName());
            return;
        }
        try (FileInputStream fileIn = new FileInputStream("HoaDon.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    HOADON hoadon = (HOADON) objectIn.readObject();
                    this.dsHoaDon.add(hoadon);
                } catch (EOFException e) {
                    // Kết thúc khi đến cuối file
                    break;
                }
            }
            System.out.println("Đã đọc danh sách  từ file HoaDon.txt");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Đã xảy ra lỗi khi đọc từ file: " + e.getMessage());
        }
    }
    public void xuat(){
        for(HOADON hoadon : this.dsHoaDon){
            System.out.println(hoadon);
        }

    }
    public void capNhatHoaDon(HOADON hoadon){
            this.dsHoaDon.replaceAll(e -> {
                if (e.getMaHD().equals(hoadon.getMaHD()) ){
                    return  hoadon;
                }
                return e;
            });
    }
    public void HuyHoaDon(String maHd,String lido){
        DanhSachTaiKhoan danhSachTaiKhoan = new DanhSachTaiKhoan();
        try {
            danhSachTaiKhoan.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
        try {
            danhSachSanPham.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
     HOADON hoadon = this.dsHoaDon.stream().filter(e->e.getMaHD().equals(maHd)).findFirst().orElse(null);
     if(hoadon != null){
         hoadon.setTrangThaiDH(TrangThai.HUY);
         hoadon.setMoTa(lido);
         this.capNhatHoaDon(hoadon);
         List<CHITIETHOADON> chitiethoadonList = hoadon.getChiTietHoaDon();
         for (CHITIETHOADON chitiethoadon : chitiethoadonList) {
             SANPHAM sanpham = chitiethoadon.getSanPham();
             SANPHAM sanphamtrongkho = danhSachSanPham.timSanPham(sanpham.getMaSP());
             if(sanphamtrongkho != null)
             {
                 sanphamtrongkho.setSoLuong(sanphamtrongkho.getSoLuong() + chitiethoadon.getSoLuong());
                 danhSachSanPham.capNhatSanPham(sanphamtrongkho);
             }
         }
         KHACHHANG kh = danhSachTaiKhoan.timMaKH(hoadon.getMaKH());
         if(kh != null)
         {
             List<HOADON> lichsu= kh.getLichSuMuaHang();
             lichsu.replaceAll( e->e.getMaHD().equals(hoadon.getMaHD()) ?  hoadon : e);
             kh.setLichSuMuaHang(lichsu);
             danhSachTaiKhoan.capnhatTK(kh);
             try {
                 danhSachTaiKhoan.ghiFile();

             }
             catch (Exception e) {
                 System.out.println(e);
             }

         }
     }

        try {
            danhSachSanPham.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            this.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void xuatHoaDon(List<String> mahd){
        DanhSachTaiKhoan danhSachTaiKhoan = new DanhSachTaiKhoan();
        try {
            danhSachTaiKhoan.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
        for(String maHd : mahd){
            HOADON hoadon = this.dsHoaDon.stream().filter(e->e.getMaHD().equals(maHd)).findFirst().orElse(null);
            if(hoadon != null){
                hoadon.setTrangThaiDH(TrangThai.DANGGIAO);
                this.capNhatHoaDon(hoadon);
                KHACHHANG kh = danhSachTaiKhoan.timMaKH(hoadon.getMaKH());
                List<HOADON> lichsu= kh.getLichSuMuaHang();
                lichsu.replaceAll( e->e.getMaHD().equals(hoadon.getMaHD()) ?  hoadon : e);
                kh.setLichSuMuaHang(lichsu);
                danhSachTaiKhoan.capnhatTK(kh);
            }
        }
        try {
            danhSachTaiKhoan.ghiFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            this.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void xacNhanDon(List<String> mahd){
        DanhSachTaiKhoan danhSachTaiKhoan = new DanhSachTaiKhoan();
        try {
            danhSachTaiKhoan.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
        for(String maHd : mahd){
            HOADON hoadon = this.dsHoaDon.stream().filter(e->e.getMaHD().equals(maHd)).findFirst().orElse(null);
            if(hoadon != null){
                hoadon.setTrangThaiDH(TrangThai.XACNHAN);
                this.capNhatHoaDon(hoadon);
                KHACHHANG kh = danhSachTaiKhoan.timMaKH(hoadon.getMaKH());
                List<HOADON> lichsu= kh.getLichSuMuaHang();
                lichsu.replaceAll( e->e.getMaHD().equals(hoadon.getMaHD()) ?  hoadon : e);
                kh.setLichSuMuaHang(lichsu);
                danhSachTaiKhoan.capnhatTK(kh);
            }
        }
        try {
            danhSachTaiKhoan.ghiFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            this.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public HOADON timHoaDon(String maHd)
    {
        return  this.dsHoaDon.stream().filter(e->e.getMaHD().equals(maHd)).findFirst().orElse(null);
    }
public  void themHoaDon(HOADON hoadon){
        this.dsHoaDon.add(hoadon);
}


}
