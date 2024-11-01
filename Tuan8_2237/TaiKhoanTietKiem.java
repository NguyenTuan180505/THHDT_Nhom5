package Tuan8_2237;

import java.util.Scanner;

class TaiKhoanTietKiem extends TKNganHang {
    private double laiSuat;  // Lãi suất tiết kiệm hàng năm (%)
    private int kyHan;
    private double soDuTK;

    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan,String matKhau, double laiSuat, int kyHan,double soDuTK) {
        super(soTaiKhoan, chuTaiKhoan,matKhau);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
        this.soDuTK = soDuTK;
    }

    public TaiKhoanTietKiem() {
    }

    public void dangKy(String soTaiKhoan, String tenChuTaiKhoan){
        Scanner sc = new Scanner(System.in);
        this.setSoTaiKhoan(soTaiKhoan);
        this.setChuTaiKhoan(tenChuTaiKhoan);
        System.out.println("mo tai khoan tiet kiem");
        System.out.println("Nhap lai suat");
        this.laiSuat=sc.nextDouble();
        System.out.println("Nhap Ky han");
        this.kyHan=sc.nextInt();
        System.out.println("Nhap so du tai khoan tiet kiem");
        this.soDuTK=sc.nextDouble();
    }

    // Tính tiền lãi
    public void tinhLai() {
        double tienLai = soDuTK * (laiSuat / 100) * (kyHan / 12.0); // Tính lãi theo năm
        soDuTK += tienLai;
        System.out.println("Tiền lãi cộng vào tài khoản: " + tienLai + ". Số dư hiện tại: " + soDuTK);
    }
    public void guiTien(double tien) {
        if(tien>0) {
            soDuTK=soDuTK +tien;
            System.out.println("gui tien thanh cong,so du hien tai :"+soDu);
        }
        else
            System.out.println("so tien khong hop le");
    }
    @Override
    public String toString() {
        return "TaiKhoanTietKiem{" +
                "laiSuat=" + laiSuat +
                ", kyHan=" + kyHan +
                ", soDuTK=" + soDuTK +
                ", soTaiKhoan='" + soTaiKhoan + '\'' +
                ", chuTaiKhoan='" + chuTaiKhoan + '\'' +
                '}';
    }
// Hiển thị thông tin tài khoản tiết kiệm


}
