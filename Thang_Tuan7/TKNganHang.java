package Thang_Tuan7;

public class TKNganHang {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private  String matKhau;

    public TKNganHang(String soTaiKhoan, String chuTaiKhoan, double soDu,String matKhau) {
        this.soTaiKhoan= soTaiKhoan;
        this.chuTaiKhoan= chuTaiKhoan;
        this.soDu=soDu;
        this.matKhau=matKhau;

    }

    @Override
    public String toString() {
        return "TKNganHang{" +
                "soTaiKhoan='" + soTaiKhoan + '\'' +
                ", chuTaiKhoan='" + chuTaiKhoan + '\'' +
                ", soDu=" + soDu +
                ", matKhau='" + matKhau + '\'' +
                '}';
    }

    public TKNganHang() {}

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }

    public void guiTien(double tien) {
        if(tien>0) {
            soDu=soDu +tien;
            System.out.println("gui tien thanh cong,so du hien tai :"+soDu);
        }
        else
            System.out.println("so tien khong hop le");
    }
    public void rutTien(double tien) {
        if(tien>0&&tien<=soDu) {
            soDu=soDu-tien;
            System.out.println("rut tien thanh cong,so du hien tai :"+soDu);
        }
        else
            System.out.println("so tien rut vuot qua so du ");
    }
    public double kiemTraSoDu() {
        return soDu;
    }
    public void doiMatKhau (String matKhauCu, String matKhauMoi)
    {
        if(matKhauCu.equals(this.matKhau)){
            this.matKhau=matKhauMoi;
            System.out.println("Doi mat khau thanh cong");
        }
        else{
            System.out.println("Mat khau khong chinh xac");
        }
    }
    public boolean dangNhap( String tk, String mk)
    {
        if (this.matKhau.equals(mk)&& this.chuTaiKhoan.equals(tk)) {
            return true;
        }
        else return false;
    }

}
