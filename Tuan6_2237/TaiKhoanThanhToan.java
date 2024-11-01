package Tuan6;

import Tuan6.TKNganHang;

import java.util.Scanner;

class TaiKhoanThanhToan extends TKNganHang {
    private double phiDichVuHangThang;  // Phí dịch vụ hàng tháng
    private double hanMucRutTien;
    private  String maPin;// Hạn mức rút tiền tối đa

    public double getPhiDichVuHangThang() {
        return phiDichVuHangThang;
    }

    public void setPhiDichVuHangThang(double phiDichVuHangThang) {
        this.phiDichVuHangThang = phiDichVuHangThang;
    }

    public String getMaPin() {
        return maPin;
    }

    public void setMaPin(String maPin) {
        this.maPin = maPin;
    }

    public double getHanMucRutTien() {
        return hanMucRutTien;
    }

    public void setHanMucRutTien(double hanMucRutTien) {
        this.hanMucRutTien = hanMucRutTien;
    }

    public TaiKhoanThanhToan() {
    }

    public TaiKhoanThanhToan(String soTaiKhoan, String tenChuTaiKhoan, double soDu, double phiDichVuHangThang, double hanMucRutTien, String maPin) {
        super(soTaiKhoan, soDu, tenChuTaiKhoan);
        this.phiDichVuHangThang = phiDichVuHangThang;
        this.hanMucRutTien = hanMucRutTien;
        this.maPin = maPin;
    }

    public void dangKy(String soTaiKhoan, String tenChuTaiKhoan, double soDu){
        Scanner sc = new Scanner(System.in);

      this.setSoTaiKhoan(soTaiKhoan);
      this.setChuTaiKhoan(tenChuTaiKhoan);
      this.setSoDu(soDu);
        System.out.println("mo tai khoan thanh toan");
        System.out.println("Nhap Phi dich vu hang thang");
        this.phiDichVuHangThang=sc.nextDouble();
        System.out.println("Nhap han muc rut tien");
        this.hanMucRutTien=sc.nextDouble();
        System.out.println("Nhap ma pin");
        this.maPin=sc.next();

    }

    // Phương thức trừ phí dịch vụ hàng tháng
    public void truPhiDichVu() {
        if (soDu >= phiDichVuHangThang) {
             soDu = soDu - phiDichVuHangThang;
            System.out.println("Đã trừ phí dịch vụ hàng tháng: " + phiDichVuHangThang + ". Số dư hiện tại: " + soDu);
        } else {
            System.out.println("Không đủ số dư để trừ phí dịch vụ.");
        }
    }

    // Phương thức rút tiền có kiểm tra hạn mức

    public void rutTien(double soTien,String maPin) {
        if(!maPin.equals(this.maPin)){
            System.out.println("Ma Pin Khong chinh xac");
        }
       else if (soTien > hanMucRutTien) {
            System.out.println("Số tiền rút vượt quá hạn mức cho phép.");
        } else {

            super.rutTien(soTien);

        }
    }

    // Hiển thị thông tin tài khoản thanh toán
    public void guiTien(double tien) {
        if(tien>0) {
            soDu=soDu +tien;
            System.out.println("gui tien thanh cong,so du hien tai :"+soDu);
        }
        else
            System.out.println("so tien khong hop le");
    }
    @Override
    public String toString() {
        return "TaiKhoanThanhToan{" +
                "phiDichVuHangThang=" + phiDichVuHangThang +
                ", hanMucRutTien=" + hanMucRutTien +
                ", maPin='" + maPin + '\'' +
                ", soTaiKhoan='" + soTaiKhoan + '\'' +
                ", chuTaiKhoan='" + chuTaiKhoan + '\'' +
                ", soDu=" + soDu +
                '}';
    }


}
