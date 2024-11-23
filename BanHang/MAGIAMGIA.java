package BanHang;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class MAGIAMGIA implements Serializable {
    private String maGG;
    private double phanTram;
    private LocalDate ngayHetHan;

    // Constructor
    public MAGIAMGIA(String maGG, double phanTram, String ngayHetHan) {
        this.maGG = maGG;
        this.phanTram = phanTram;
    }
    public  MAGIAMGIA (){
    }
    public void taoMaGG(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma");
        this.maGG=sc.next();
        System.out.println("Nhap Phan tram giam (1-100)");
        this.phanTram=sc.nextDouble();
        System.out.println("Nhap ngay het han");
        this.ngayHetHan=LocalDate.parse(sc.next());
    }

    // Getter và Setter
    public String getMa() {
        return maGG;
    }

    public void setMa(String ma) {
        this.maGG = ma;
    }

    public double getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(double phanTram) {
        this.phanTram = phanTram;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    // Kiểm tra mã giảm giá có còn hiệu lực
    public boolean isConHieuLuc() {
        return ngayHetHan.isAfter(LocalDate.now());
    }

    @Override
    public String toString() {
        return "MaGiamGia{" +
                "ma='" + maGG + '\'' +
                ", phanTram=" + phanTram +
                ", ngayHetHan='" + ngayHetHan + '\'' +
                '}';
    }
}
