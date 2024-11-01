package BankHom;

public class TaiKhoanThanhToan extends TaiKhoan {
    private double soDuThanhToan;

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String passwork,double soDuThanhToan) {
        super(soTaiKhoan, chuTaiKhoan, soDu, passwork);
        this.soDuThanhToan =soDuThanhToan;
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

    // Rút tiền từ tài khoản thanh toán
    public void RutTienTK(double soTien) {
        if (soTien > 0 && soTien <= this.soDuThanhToan) {
            this.soDuThanhToan -= soTien;
            this.setSoDu(this.getSoDu() + soTien);
            System.out.println("Rút tiền thành công.");
        } else {
            System.out.println("Số tiền rút không hợp lệ.");
        }
    }

    public double KiemTraSoDuThanhToan() {
        return this.soDuThanhToan;
    }

    public double getSoDuThanhToan() {
        return soDuThanhToan;
    }
}
