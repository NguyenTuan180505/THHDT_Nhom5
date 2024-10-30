package BankHom;

public class TaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private Double soDu;
    private String passwork;

    public TaiKhoan() {
    }

    public TaiKhoan(String soTaiKhoan, String passwork) {
        this.soTaiKhoan = soTaiKhoan;
        this.passwork = passwork;
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
    public double GuiTien(double soTien){
        if(soTien>0)
            return this.soDu=this.soDu+soTien;
        else
        {
            System.out.println("so tien khong hop le");
            return soDu;
        }
    }

    public double RutTien(double soTien){
        if(soDu>0 &&soDu>soTien)
            this.soDu=this.soDu-soTien;
        return soTien;
    }

    public String KiemTraSoDu(){
        return  "so Du Hien Tai :"+this.soDu;
    }
    public String DoiMatKhau(String MatKhauMoi){
        return this.passwork=MatKhauMoi;
    }
}
