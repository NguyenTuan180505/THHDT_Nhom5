package TaiKhoan;

import java.util.Scanner;

public class NHANVIEN extends PERSON {
    protected double luongCoBan;
    protected double phuCap;


    // Constructor
    public NHANVIEN(PERSON person,double luongCoBan,double phuCap) {
        super( person.id, person.name,person.email, person.SDT, person.address,person.password);
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;

    }

    public NHANVIEN(String id, String name, String email, String SDT, String address, String password, double luongCoBan, double phuCap) {
        super(id, name, email, SDT, address, password);
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
    }

    public NHANVIEN() {

    }
    public void themMoi(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id");
        setId(sc.next());
        System.out.println("Nhap ten");
        setName(sc.next());
        System.out.println("Nhap email");
        setEmail(sc.next());
        System.out.println("Nhap sdt");
        setSDT(sc.next());
        System.out.println("Nhap Dia chi");
        setAddress(sc.next());
        System.out.println("Nhap password");
        setPassword(sc.next());
        System.out.println("Nhap luong co ban");
        setLuongCoBan(sc.nextDouble());
        System.out.println("Nhap phu cap");
        setPhuCap(sc.nextDouble());
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }
    public double tinhLuong (){
        return  luongCoBan+phuCap;
    }

    @Override
    public String toString() {
        return "TaiKhoan.NHANVIEN{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", SDT='" + SDT + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
