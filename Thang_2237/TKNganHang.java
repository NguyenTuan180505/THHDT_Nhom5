package Thang_2237;

import java.util.Scanner;

public class TKNganHang extends RutTienTaiKhoan  {
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected double soDu;
    protected  String matKhau;

    public TKNganHang(String soTaiKhoan, String chuTaiKhoan, double soDu,String matKhau) {
        this.soTaiKhoan= soTaiKhoan;
        this.chuTaiKhoan= chuTaiKhoan;
        this.soDu=soDu;
        this.matKhau=matKhau;

    }

    public TKNganHang(String soTaiKhoan, String chuTaiKhoan, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.matKhau = matKhau;
    }

    public TKNganHang(String soTaiKhoan, double soDu, String chuTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
        this.soDu = soDu;
        this.chuTaiKhoan = chuTaiKhoan;
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



    public double kiemTraSoDu() {
        return soDu;
    }
    public boolean doiMatKhau (String matKhauCu, String matKhauMoi)
    {
        if(matKhauCu.equals(this.matKhau)){
            this.matKhau=matKhauMoi;
            System.out.println("Doi mat khau thanh cong");
            return  true;
        }
        else{
            System.out.println("Mat khau khong chinh xac");
            return  false;
        }
    }
    public boolean dangNhap( String tk, String mk)
    {
        if (this.matKhau.equals(mk)&& this.chuTaiKhoan.equals(tk)) {
            return true;
        }
        else return false;
    }
    public void dangKy(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban chua co tai khoan can dang ky");
        System.out.println("Nhap So tai khoan");
        this.soTaiKhoan=sc.next();
        System.out.println("Nhap chu tai khoan");
        this.chuTaiKhoan=sc.next();
        System.out.println("Nhap Mat khau");
       this.matKhau=sc.next();
    }
    public void guiTien(double tien) {
        if(tien>0) {
            this.soDu=this.soDu +tien;
            System.out.println("gui tien thanh cong,so du hien tai :"+soDu);
        }
        else
            System.out.println("so tien khong hop le");
    }

    @Override
    public void RutTien(double tien,String maPin) {
        if(tien>0&&tien<=soDu) {
            soDu=soDu-tien;
            System.out.println("rut tien thanh cong,so du hien tai :"+soDu);
        }
        else
            System.out.println("so tien rut vuot qua so du ");
    }
}
