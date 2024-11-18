

import java.io.Serializable;
import java.util.Scanner;

public class TKNganHang implements Serializable {
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected String email;
    protected  String sdt;
    protected String cccd;
    protected double soDu;
    protected  String matKhau;


    public TKNganHang(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
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
                ", email='" + email + '\'' +
                ", sdt='" + sdt + '\'' +
                ", cccd='" + cccd + '\'' +
                ", soDu=" + soDu +
                ", matKhau='" + matKhau + '\'' +
                '}';
    }

    public TKNganHang() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

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


    public void guiTien(double tien) {

        if(tien>0) {
            this.soDu=this.soDu +tien;
            System.out.println("gui tien thanh cong,so du hien tai :"+soDu);

        }
        else
            System.out.println("so tien khong hop le");
    }


    public  void RutTien(double tien,String maPin) {

        if(tien>0&&tien<=soDu) {
            soDu=soDu-tien;
            System.out.println("rut tien thanh cong,so du hien tai :"+soDu);

        }
        else
            System.out.println("so tien rut vuot qua so du ");
    }
    public  boolean thanhToan(double tien){
        if(tien>0&&tien<=soDu) {
            soDu=soDu-tien;
            System.out.println("Thanh toan don hang thanh cong,so du hien tai :"+soDu);
            return  true;
        }
        else
            System.out.println("so tien thanh vuot qua so du ");
        return false;
    }
    public  void  themTk(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so tai khoan");
        this.soTaiKhoan=sc.nextLine();
        System.out.println("Nhap chu tai khoan");
        this.chuTaiKhoan=sc.nextLine();
        System.out.println("Nhap email");
        this.email=sc.nextLine();
        System.out.println("Nhap sdt");
        this.sdt=sc.nextLine();
        System.out.println("Nhap cccd");
        this.cccd=sc.nextLine();
        System.out.println("Nhap so du");
        this.soDu=sc.nextDouble();

    }

}
