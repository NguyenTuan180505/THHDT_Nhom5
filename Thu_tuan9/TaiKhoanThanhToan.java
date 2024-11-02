package BankHom;

public class TaiKhoanThanhToan extends TaiKhoan {
    private double soDuThanhToan;
    private double hanMucThauChi = 5000000;

    public TaiKhoanThanhToan() {
        soDuThanhToan=0;
    }

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String passwork, double soDuThanhToan) {
        super(soTaiKhoan, chuTaiKhoan, soDu, passwork);
        this.soDuThanhToan = soDuThanhToan;
    }

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTK, double soDu, String passwork) {
        super(soTaiKhoan, chuTK, soDu, passwork);
    }

    public void GuiTienThanhToan(double soTien) {
        if (soTien > 0) {
            if (soTien <= this.getSoDu()) {
                this.soDuThanhToan += soTien;
                this.setSoDu(this.getSoDu() - soTien);
                System.out.println("Gửi tiền vào tài khoản thanh toán thành công.");
            } else {
                System.out.println("Số tiền gửi vượt quá số dư tài khoản chính.");
            }
        } else {
            System.out.println("Số tiền gửi không hợp lệ.");
        }
    }

    @Override
    public void RutTien(double soTien) {
        if (soTien <= 0) {
            System.out.println("Số tiền rút không hợp lệ.");
        }
        double soDuHienTai = this.soDuThanhToan + this.hanMucThauChi;

        if (soTien <= soDuHienTai) {
            if (soTien > this.soDuThanhToan) {
                this.hanMucThauChi -= (soTien - this.soDuThanhToan);
                this.soDuThanhToan = 0;
            } else {
                this.soDuThanhToan -= soTien;
            }
            System.out.println("Rút tiền thành công.");
        } else {
            System.out.println("Số tiền không thể rút do vượt quá số dư và hạn mức chi tiêu.");
        }
    }

    @Override
    public double KiemTraSoDu() {
        return this.soDuThanhToan;
    }

    public double getSoDuThanhToan() {
        return soDuThanhToan;
    }

    public void setSoDuThanhToan(double soDuThanhToan) {
        this.soDuThanhToan = soDuThanhToan;
    }
}
