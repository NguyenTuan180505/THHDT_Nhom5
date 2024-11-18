import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SANPHAM implements Serializable {
        private String maSP;
        private String tenSP;
        private double giaBan;
        private double giaNhap;
        private double soLuong;
        private MAGIAMGIA maGiamGia;
       private  List<DANHGIA> danhGia = new ArrayList<>();
    public MAGIAMGIA getMaGiamGia() {
        return maGiamGia;
    }

    public List<DANHGIA> getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(List<DANHGIA> danhGia) {
        this.danhGia = danhGia;
    }

    public void setMaGiamGia(MAGIAMGIA maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    // Constructor
        public SANPHAM(String maSP, String tenSP, double giaBan, double giaNhap,double soLuong) {
            this.maSP = maSP;
            this.tenSP = tenSP;
            this.giaBan = giaBan;
            this.soLuong = soLuong;
            this.giaNhap = giaNhap;
        }

        public SANPHAM() {

        }
        public void taoSanPham (){
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap ma san pham");
            this.maSP = sc.nextLine();
            System.out.println("Nhap ten san pham");
            this.tenSP = sc.nextLine();
            System.out.println("Nhap gia ban");
            this.giaBan = sc.nextDouble();
            System.out.println("Nhap gia nhap");
            this.giaNhap = sc.nextDouble();


        }

        public double getGiaNhap() {
            return giaNhap;
        }

        public void setGiaNhap(double giaNhap) {
            this.giaNhap = giaNhap;
        }

        public void setTenSP(String tenSP) {
            this.tenSP = tenSP;
        }

        public void setMaSP(String maSP) {
            this.maSP = maSP;
        }

        // Getters và Setters
        public String getMaSP() {
            return maSP;
        }

        public String getTenSP() {
            return tenSP;
        }

        public double getGiaBan() {
            return giaBan;
        }

        public void setGiaBan(double giaBan) {
            this.giaBan = giaBan;
        }

        public double getSoLuong() {
            return soLuong;
        }

        public void setSoLuong(double soLuong) {
            this.soLuong = soLuong;
        }
        @Override
        public String toString() {
            return "SanPham{" +
                    "maSP='" + maSP + '\'' +
                    ", tenSP='" + tenSP + '\'' +
                    ", gia=" + giaBan +
                    ", soLuong=" + (soLuong > 0 ? soLuong : "Het Hang") +
                    '}';
        }
    }

