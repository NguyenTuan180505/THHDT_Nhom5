import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HOADON implements Serializable {
    private String maHD;
    private LocalDate ngayLap = LocalDate.now();
    private List<CHITIETHOADON> chiTietHoaDon  = new ArrayList<>();
    private double tongTien;
    private String diaChiGiaoHang;
    private String maNV;
    private  String maKH;
    private  TrangThai trangThaiDH;
    private String moTa;
    private HinhThucThanhToan hinhThucThanhToan;

    public HOADON() {
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public TrangThai getTrangThaiDH() {
        return trangThaiDH;
    }

    public void setTrangThaiDH(TrangThai trangThaiDH) {
        this.trangThaiDH = trangThaiDH;
    }

    // Constructor
    public HOADON(String maHD, LocalDate ngayLap,TrangThai trangThaiDH) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.chiTietHoaDon = new ArrayList<>();
        this.tongTien = 0;
        this.trangThaiDH= trangThaiDH;
    }

    public HOADON(String maHD,  String khachhang,String diaChiGiaoHang, HinhThucThanhToan hinhThucThanhToan, TrangThai trangThaiDH) {
        this.maHD = maHD;
        this.maKH = khachhang;
        this.hinhThucThanhToan=hinhThucThanhToan;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.trangThaiDH = trangThaiDH;
    }

    // Thêm chi tiết hóa đơn
    public void themChiTietHoaDon(SANPHAM sanPham, double soLuong) {
        if (sanPham.getSoLuong() < soLuong) {
            System.out.println("Không đủ số lượng sản phẩm trong kho.");
            return;
        }
        // Cập nhật tồn kho
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
        try {
            danhSachSanPham.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
        SANPHAM sanphamtrongkho = danhSachSanPham.timSanPham(sanPham.getMaSP());
        if(sanphamtrongkho != null)
            sanphamtrongkho.setSoLuong(sanPham.getSoLuong() - soLuong);
        danhSachSanPham.capNhatSanPham(sanphamtrongkho);

        // Thêm chi tiết vào danh sách
        CHITIETHOADON chiTiet = new CHITIETHOADON(sanPham, soLuong);
        chiTietHoaDon.add(chiTiet);
        try {
            danhSachSanPham.ghiFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
        // Cập nhật tổng tiền hóa đơn


    }

    // Tính tổng tiền hóa đơn
    public double tinhTongTien() {
        for(CHITIETHOADON chitiethoadon :chiTietHoaDon) {
            tongTien += chitiethoadon.getThanhTien();
        }
        return  tongTien;
    }

    public List<CHITIETHOADON> getChiTietHoaDon() {
        return chiTietHoaDon;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setChiTietHoaDon(List<CHITIETHOADON> chiTietHoaDon) {
        this.chiTietHoaDon = chiTietHoaDon;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getNhanvien() {
        return maNV;
    }

    public void setNhanvien(String nhanvien) {
        this.maNV = nhanvien;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String khachhang) {
        this.maKH = khachhang;
    }

    @Override
    public String toString() {
        return "HOADON{" +
                "maHD='" + maHD + '\'' +
                ", ngayLap=" + ngayLap +
                ", chiTietHoaDon=" + chiTietHoaDon +
                ", tongTien=" + tongTien +
                ", nhanvien=" + maNV +
                ", MaKH=" + maKH +
                ", trangThaiDH=" + trangThaiDH +
                ", Mota=" + moTa+
                ", HinhThucThanhToan=" + hinhThucThanhToan+
                ", DiaChiGiaoHang=" + diaChiGiaoHang+
                '}';
    }
}
