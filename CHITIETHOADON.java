import java.io.Serializable;

public class CHITIETHOADON implements Serializable {
    private SANPHAM sanPham;
    private double soLuong;
    private double thanhTien;

    // Constructor
    public CHITIETHOADON(SANPHAM sanPham, double soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.thanhTien = soLuong * sanPham.getGiaBan();
    }

    // Getters và Setters
    public SANPHAM getSanPham() {
        return sanPham;
    }

    public void setSanPham(SANPHAM sanPham) {
        this.sanPham = sanPham;
    }

    public double getSoLuong() {
        return soLuong;
    }
    public double getThanhTien() {
        return thanhTien;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "sanPham=" + sanPham.getTenSP() +
                ", soLuong=" + soLuong +
                ", thanhTien=" + thanhTien +
                '}';
    }
}
