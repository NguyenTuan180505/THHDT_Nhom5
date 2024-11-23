package BanHang;

import Service.TaoMaNgauNhien;
import TaiKhoan.KHACHHANG;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class DANHGIA implements Serializable {
    private String maDanhGia;
    private String khachHangId;
    private String noiDung;
    private int soSao;
    private LocalDate ngayDanhGia;

    // Constructor
    public DANHGIA(String maDanhGia,String khachHangId, String noiDung, int soSao) {
        this.maDanhGia = maDanhGia;

        this.khachHangId = khachHangId;
        this.noiDung = noiDung;
        this.soSao = soSao;
        this.ngayDanhGia = LocalDate.now();
    }
    public DANHGIA (){
        ngayDanhGia = LocalDate.now();
    }

    // Getter và Setter
    public String getMaDanhGia() {
        return maDanhGia;
    }

    public void setMaDanhGia(String maDanhGia) {
        this.maDanhGia = maDanhGia;
    }



    public String getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(String khachHangId) {
        this.khachHangId = khachHangId;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getSoSao() {
        return soSao;
    }

    public void setSoSao(int soSao) {
        if (soSao < 1 || soSao > 5) {
            throw new IllegalArgumentException("Số sao phải nằm trong khoảng từ 1 đến 5.");
        }
        this.soSao = soSao;
    }

    public LocalDate getNgayDanhGia() {
        return ngayDanhGia;
    }

    public void setNgayDanhGia(LocalDate ngayDanhGia) {
        this.ngayDanhGia = ngayDanhGia;
    }
    public void taoDanhGia(KHACHHANG khachhang){
        Scanner sc = new Scanner(System.in);
        this.khachHangId=khachhang.getId();
        this.maDanhGia= TaoMaNgauNhien.generateRandomString(5);
        System.out.println("Nhap noi dung");
        this.noiDung=sc.nextLine();
        System.out.println("Nhap so sao(1-5)");
        setSoSao(sc.nextInt());

    }
    @Override
    public String toString() {
        return "Đánh giá bởi khách hàng " + khachHangId +
                " | Số sao: " + soSao +
                " | Nội dung: " + noiDung +
                " | Ngày: " + ngayDanhGia;
    }

}
