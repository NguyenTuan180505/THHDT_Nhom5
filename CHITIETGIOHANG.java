import java.util.Scanner;

public class CHITIETGIOHANG {
    private  SANPHAM sanpham;
    private  double soLuong;

    public SANPHAM getSanpham() {
        return sanpham;
    }

    public void setSanpham(SANPHAM sanpham) {
        this.sanpham = sanpham;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "CHITIETGIOHANG{" +
                "sanpham=" + sanpham.getTenSP() +
                ", soLuong=" + soLuong +
                '}';
    }
}
