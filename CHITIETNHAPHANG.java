import java.io.Serializable;

public class CHITIETNHAPHANG implements Serializable {
    private SANPHAM sanPham;
    private int soLuong;
    private double giaNhap;


    // Constructor
    public CHITIETNHAPHANG(SANPHAM sanPham, int soLuong, double giaNhap) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    this.giaNhap = giaNhap;
    }

    public CHITIETNHAPHANG() {
    }

    // Getters và Setters
    public SANPHAM getSanPham() {
        return sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSanPham(SANPHAM sanPham) {
        this.sanPham = sanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    @Override
    public String toString() {
        return "ChiTietNhapHang{" +
                "sanPham=" + sanPham.getTenSP() +
                ", soLuong=" + soLuong +
                ", giaNhap=" + giaNhap +
                '}';
    }
}
