import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class NHAPHANG implements Serializable {
    private String maNhap;
    private LocalDate ngayNhap = LocalDate.now();
    private List<CHITIETNHAPHANG> chiTietNhapHang = new ArrayList<>();
    private int tongSoLuong;
    private double tongTienNhap;

    // Constructor
    public NHAPHANG(String maNhap) {
        this.maNhap = maNhap;
        this.chiTietNhapHang = new ArrayList<>();
        this.tongSoLuong = 0;
        this.tongTienNhap = 0;
    }

    public NHAPHANG() {
    }

    // Thêm chi tiết nhập hàng
    public void themChiTietNhapHang(String maSp) {
        Scanner sc = new Scanner(System.in);

        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
        DanhSachNhapHang dsNhaphang = new DanhSachNhapHang();
        try {
            danhSachSanPham.docFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            dsNhaphang.docFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int soLuong;
        SANPHAM sanpham = danhSachSanPham.timSanPham(maSp) ;
        if (sanpham == null) {
            sanpham = new SANPHAM();
            sanpham.taoSanPham();
            System.out.println("Nhap so luong nhap");
            soLuong = sc.nextInt();
            sanpham.setSoLuong(soLuong);
            System.out.println();
            CHITIETNHAPHANG chiTiet = new CHITIETNHAPHANG(sanpham, soLuong,sanpham.getGiaNhap());
            chiTietNhapHang.add(chiTiet);
            danhSachSanPham.themSanPham(sanpham);
        }
        else  {
            System.out.println("Nhap so luong nhap");
            soLuong = sc.nextInt();
            sanpham.setSoLuong(sanpham.getSoLuong()+soLuong);
            CHITIETNHAPHANG chiTiet = new CHITIETNHAPHANG(sanpham, soLuong,sanpham.getGiaNhap());
            chiTietNhapHang.add(chiTiet);
            danhSachSanPham.capNhatSanPham(sanpham);
        }

        dsNhaphang.themNhapHang(this);
        try {
            danhSachSanPham.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            dsNhaphang.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    // Tính tổng số lượng sản phẩm nhập
    public int tinhTongSoLuong() {
        return tongSoLuong;
    }

    // Tính tổng tiền nhập hàng
    public double tinhTongTienNhap() {
        return tongTienNhap;
    }

    @Override
    public String toString() {
        return "NhapHang{" +
                "maNhap='" + maNhap + '\'' +
                ", ngayNhap=" + ngayNhap +
                ", tongSoLuong=" + tongSoLuong +
                ", tongTienNhap=" + tongTienNhap +
                ", chiTietNhapHang=" + chiTietNhapHang +
                '}';
    }
}
