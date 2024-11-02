package BankHom;

public class TaiKhoan extends AbStractRutTien {
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected Double soDu;
    protected String passwork;

    public TaiKhoan() {
        this.soTaiKhoan = "";
        this.soDu = 0.0;
        this.passwork = "";
    }

    public TaiKhoan(String soTaiKhoan, String passwork) {
        this.soTaiKhoan = soTaiKhoan;
        this.passwork = passwork;
        this.soDu = 0.0;
    }

    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, Double soDu, String passwork) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.passwork = passwork;
    }

    public String getSoTaiKhoan() {
        return this.soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return this.chuTaiKhoan;
    }

    public String getPasswork() {
        return this.passwork;
    }

    public double getSoDu() {
        return this.soDu;
    }

    public double GuiTien(double soTien) {
        if (soTien > 0) {
            this.soDu += soTien;
            return this.soDu;
        } else {
            System.out.println("Số tiền không hợp lệ.");
            return this.soDu;
        }
    }

    @Override
    public void RutTien(double soTien) {
        if (this.soDu >= soTien && soTien > 0) {
            this.soDu -= soTien;
        } else {
            System.out.println("Không đủ số dư hoặc số tiền không hợp lệ.");
        }
    }

    @Override
    public void RutTien() {

    }

    @Override
    public double KiemTraSoDu() {
        return this.soDu;
    }

    public void DoiMatKhau(String passwork) {
        this.passwork = passwork;
    }

    public void setSoDu(Double soDu) {
        this.soDu = soDu;
    }

    public String toString() {
        return this.soTaiKhoan + " " + this.passwork + " " + this.chuTaiKhoan + " " + this.soDu ;
    }
}
