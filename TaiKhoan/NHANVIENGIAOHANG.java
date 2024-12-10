package TaiKhoan;

import BanHang.HOADON;
import DanhSach.DanhSachHoaDon;
import DanhSach.DanhSachTaiKhoan;
import Enum.TrangThai;
import java.util.List;
import java.util.Scanner;

public class NHANVIENGIAOHANG extends  NHANVIEN{
    private int soDonDaGiao;
    public NHANVIENGIAOHANG(NHANVIEN nhanvien,double thuongMoiHoaDon) {
        super(nhanvien.id, nhanvien.name,nhanvien.email,nhanvien.SDT, nhanvien.address,nhanvien.password, nhanvien.luongCoBan, nhanvien.phuCap);
    }
    public  NHANVIENGIAOHANG (){

    }
    public int getSoDonDaGiao() {
        return soDonDaGiao;
    }

    public void setSoDonDaGiao(int soDonDaGiao) {
        this.soDonDaGiao = soDonDaGiao;
    }
    public HOADON giaoThatBai(HOADON hoadon){
        Scanner sc = new Scanner(System.in);
          hoadon.setTrangThaiDH(TrangThai.GIAOTHATBAI);
          System.out.println("Nhap li do");
          hoadon.setMoTa(sc.nextLine());
          return hoadon;
    }
    public HOADON giaoThanhCong(HOADON hoadon){
        Scanner sc = new Scanner(System.in);
        hoadon.setTrangThaiDH(TrangThai.GIAOTHANHCONG);
        return hoadon;
    }
    public void xuLiDonGiao (){
        DanhSachTaiKhoan danhSachTaiKhoan = new DanhSachTaiKhoan();
        Scanner sc = new Scanner(System.in);
        try {
            danhSachTaiKhoan.docFile();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        DanhSachHoaDon danhSachHoaDon = new DanhSachHoaDon();
        try {
            danhSachHoaDon.docFile();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        List<HOADON> hoaDonGiao = danhSachHoaDon.getDsHoaDon().stream().filter(e->e.getTrangThaiDH().equals(TrangThai.DANGGIAO)).toList();

        if(!hoaDonGiao.isEmpty())
        {
            int choice;
            do {
                System.out.println("\n============MENU==========");
                System.out.println("1.Don Hang giao thanh cong \n" +
                        "2.Don Hang giao that bai\n" +
                        "3.Kiem tra don hang giao\n" +
                        "0.Thoat\n"
                );
                System.out.println("Nhap lua chon");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                    {
                        System.out.println("Nhap Ma hoa don da giao thanh cong");
                        HOADON hoadon = danhSachHoaDon.timHoaDon(sc.nextLine());
                        if(hoadon != null)
                        {
                            HOADON hoadonCapNhap = giaoThanhCong(hoadon);
                             KHACHHANG khachhang =danhSachTaiKhoan.timMaKH(hoadon.getMaKH());
                             List<HOADON> lichSuMuaHang =khachhang.getLichSuMuaHang();
                             lichSuMuaHang.replaceAll( e-> {

                                 if (e.getMaHD().equals(hoadonCapNhap.getMaHD())) {
                                     return hoadonCapNhap;
                                 }
                                 return e;

                             } );
                             khachhang.setDiemTichLuy( khachhang.getDiemTichLuy() + hoadonCapNhap.getTongTien()*0.01) ;
                             khachhang.setLichSuMuaHang(lichSuMuaHang);
                             danhSachTaiKhoan.capnhatTK(khachhang);
                            danhSachHoaDon.capNhatHoaDon(hoadonCapNhap);
                            try {
                                danhSachTaiKhoan.ghiFile();
                            }
                            catch (Exception e) {
                                System.out.println(e);
                            }

                            try {
                                danhSachHoaDon.ghiFile();
                            }
                            catch (Exception e) {
                                System.out.println(e);
                            }

                        }
                        else {
                            System.out.println("Hoa don khong ton tai");
                        }

                        break;
                    }
                    case 2:{
                        System.out.println("Nhap Ma hoa don da giao that bai");
                        HOADON hoadon = danhSachHoaDon.timHoaDon(sc.nextLine());
                        if(hoadon != null)
                        {
                            HOADON hoadonCapNhap = giaoThatBai(hoadon);
                            KHACHHANG khachhang =danhSachTaiKhoan.timMaKH(hoadon.getMaKH());
                            List<HOADON> lichSuMuaHang =khachhang.getLichSuMuaHang();
                            lichSuMuaHang.replaceAll( e-> {

                                if (e.getMaHD().equals(hoadonCapNhap.getMaHD())) {
                                    return hoadonCapNhap;
                                }
                                return e;

                            } );
                            khachhang.setLichSuMuaHang(lichSuMuaHang);
                            danhSachTaiKhoan.capnhatTK(khachhang);
                            danhSachHoaDon.capNhatHoaDon(hoadonCapNhap);
                            try {
                                danhSachTaiKhoan.ghiFile();
                            }
                            catch (Exception e) {
                                System.out.println(e);
                            }

                            try {
                                danhSachHoaDon.ghiFile();
                            }
                            catch (Exception e) {
                                System.out.println(e);
                            }

                        }
                        else {
                            System.out.println("Hoa don khong ton tai");
                        }

                        break;

                    }
                    case 3:{
                        for (HOADON hoadon : hoaDonGiao){
                            System.out.println(hoadon);
                        }
                        break;
                    }
                    case 0:{
                        System.out.println("Thoat");
                        break;
                    }
                    default:
                        System.out.println("Lua chon khong hop le");
                }
            }while (choice !=0);




        }
    }
}
