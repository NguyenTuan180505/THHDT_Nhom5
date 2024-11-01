package BankHom;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TaiKhoanTietKiem extends TaiKhoan {
    private double SoDuTietKiem ;
    private Double LaiXuat;
    private double TienLai;
    private double KyHan;
    private LocalDate ngayBatDau;
    public double LaiXuatRutSom = 0.02;

    // Constructors
    public TaiKhoanTietKiem() {
    }
    public TaiKhoanTietKiem(double SoDuTietKiem) {
        this.SoDuTietKiem = SoDuTietKiem;
    }

    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String passwork, double laiTietKiem, double thoiGianGuiTietKiem) {
        super(soTaiKhoan, chuTaiKhoan, soDu, passwork);
        this.LaiXuat = laiTietKiem;
        this.KyHan = thoiGianGuiTietKiem;
        this.ngayBatDau = LocalDate.now();
    }

    // Getters
    public double getSoDuTietKiem() {
        return this.SoDuTietKiem;
    }

    public Double getLaiXuat() {
        return this.LaiXuat;
    }

    public double getKyHan() {
        return this.KyHan;
    }

    public double getTienLai() {
        return  this.TienLai;
    }
    // Setters

    public void setTienLai(double tienLai) {
        this.TienLai = tienLai;
    }

    public void setLaiXuat(Double laiXuat) {
        this.LaiXuat = laiXuat;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setThoiGianGuiTietKiem(double thoiGianGuiTietKiem) {
        this.KyHan = thoiGianGuiTietKiem;
    }

    public void GuiTienTietKiem(double soDuTietKiem) {
        this.SoDuTietKiem += soDuTietKiem;
        this.setSoDu(this.getSoDu() - soDuTietKiem);
    }

    public void RutTienTietKiem(double soDuTietKiem) {
        this.SoDuTietKiem -= soDuTietKiem;
        this.setSoDu(this.getSoDu() + soDuTietKiem);
    }

    public double TongTienLaiTietKiem() {
        return this.SoDuTietKiem + this.TienLai;
    }

    public void TienLaiNhiemKy() {
        this.TienLai = this.SoDuTietKiem * (this.LaiXuat) * (this.KyHan / 12);
    }

    public long tinhSoNgayDaGui() {
        return ChronoUnit.DAYS.between(this.ngayBatDau, LocalDate.now());
    }

    public double TinhsoNgayKyHan() {
        return this.KyHan * 60;
    }
    public void setSoDuTietKiem(double soDuTietKiem) {
        this.SoDuTietKiem = soDuTietKiem;
    }

    public void RutTienLai() {
        if (this.TienLai > 0) {
            this.GuiTien(this.TienLai);
            this.TienLai = 0;
        } else {
            System.out.println("Không có tiền lãi để rút.");
        }
    }

    public void RutTienLaiKhongDuhan() {
        if (this.TienLai > 0) {
            double tienLaiRutSom = this.LaiXuatRutSom * this.SoDuTietKiem;
            this.GuiTien(tienLaiRutSom);
            this.TienLai = 0;
            System.out.println("Rút tiền lãi không đúng hạn thành công. Số tiền lãi đã được cộng vào tài khoản chính.");
        } else {
            System.out.println("Không có tiền gửi để rút lãi.");
        }

    }

}

