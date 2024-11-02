package BankHom;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TaiKhoanTietKiem extends TaiKhoan {
    private double soDuTietKiem;
    private Double laiXuat;
    private double tienLai;
    private double kyHan;
    private LocalDate ngayBatDau;
    public double laiXuatRutSom = 0.02;

    public TaiKhoanTietKiem() {

    }

    // Constructors
    public TaiKhoanTietKiem(double soDu, double soDuTietKiem, double tienLai, double laiXuat, double kyHan) {
        super();
        this.soDuTietKiem = soDuTietKiem;
        this.tienLai = tienLai;
        this.laiXuat = laiXuat;
        this.kyHan = kyHan;
        this.ngayBatDau = LocalDate.now();
    }


    public TaiKhoanTietKiem(String soTaiKhoan, String chuTK, double soDu, String passwork) {
        super(soTaiKhoan, chuTK, soDu, passwork);
        this.soDuTietKiem = 0; //
        this.ngayBatDau = LocalDate.now();
    }

    public TaiKhoanTietKiem(double laiTietKiem, double kyHan) {
        super();
        this.kyHan = kyHan;
        this.laiXuat = laiTietKiem;
        this.ngayBatDau = LocalDate.now();
        this.soDuTietKiem = 0; // Khởi tạo số dư tiết kiệm bằng 0
    }

    // Getters and Setters
    public double getSoDuTietKiem() {
        return this.soDuTietKiem;
    }

    public Double getLaiXuat() {
        return this.laiXuat;
    }

    public double getKyHan() {
        return this.kyHan;
    }

    public double getTienLai() {
        return this.tienLai;
    }

    public void setTienLai(double tienLai) {
        this.tienLai = tienLai;
    }

    public void setLaiXuat(Double laiXuat) {
        this.laiXuat = laiXuat;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setSoDuTietKiem(double soDuTietKiem) {
        this.soDuTietKiem = soDuTietKiem;
    }

    public void setThoiGianGuiTietKiem(double thoiGianGuiTietKiem) {
        this.kyHan = thoiGianGuiTietKiem;
    }

    public void GuiTienTietKiem(double soDuTietKiem) {
        if (soDuTietKiem > 0) {
            this.soDuTietKiem += soDuTietKiem;
            this.setSoDu(this.getSoDu() - soDuTietKiem);
            System.out.println("Gửi tiền tiết kiệm thành công.");
        } else {
            System.out.println("Số tiền gửi phải lớn hơn 0.");
        }
    }
@Override
    public void RutTien(double soDuTietKiem) {
        long soNgayDaGui = tinhSoNgayDaGui();
        if (soNgayDaGui < this.kyHan * 30) {
            System.out.println("Không thể rút tiền trước khi hết kỳ hạn.");
            return;
        }

        if (this.soDuTietKiem >= soDuTietKiem) {
            this.soDuTietKiem -= soDuTietKiem;
            this.setSoDu(this.getSoDu() + soDuTietKiem); // Cập nhật số dư tài khoản chính
            System.out.println("Rút tiền tiết kiệm thành công.");
        } else {
            System.out.println("Số tiền rút vượt quá số dư tiết kiệm.");
        }
    }

    public double TienLaiDaGui() {
        return this.tienLai = this.soDuTietKiem * this.laiXuat * (this.kyHan / 12);
    }

    public long tinhSoNgayDaGui() {
        return ChronoUnit.DAYS.between(this.ngayBatDau, LocalDate.now());
    }

    public double TinhsoNgayKyHan() {
        return this.kyHan * 30;
    }

    public void RutLai() {
        if (this.tienLai > 0) {
            this.soDuTietKiem += this.tienLai;
            this.tienLai = 0.0;
            System.out.println("Rút lãi thành công.");
        } else {
            System.out.println("Không có lãi để rút.");
        }
    }

    @Override
    public void RutTien() {
        if (this.soDuTietKiem > 0) {
            this.setSoDu(this.getSoDu()+this.soDuTietKiem);
            this.soDuTietKiem = 0;
            System.out.println("Rút tiền tiết kiệm thành công.");
        } else {
            System.out.println("Bạn chưa gửi tiết kiệm.");
        }
    }

    @Override
    public double KiemTraSoDu() {
        return this.soDuTietKiem;
    }
}
