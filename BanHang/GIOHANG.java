package BanHang;

import ChiTiet.CHITIETGIOHANG;
import DanhSach.DanhSachSanPham;

import java.util.ArrayList;
import java.util.List;

public class GIOHANG {
    private List<CHITIETGIOHANG> dsGioHang = new ArrayList<>();
    public void gioHang() {

    }

    public void themSp(SANPHAM sanpham,double soLuong)
    {
        CHITIETGIOHANG chitietgiohang = new CHITIETGIOHANG();
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
        try {
            danhSachSanPham.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
        SANPHAM spkho= danhSachSanPham.timSanPham(sanpham.getMaSP());
        if(spkho.getSoLuong() <= 0){
            System.out.println("Het Hang");
            return;
        }
        chitietgiohang.setSanpham(sanpham);
        chitietgiohang.setSoLuong(soLuong);
        dsGioHang.add(chitietgiohang);
    }
    public  void kiemTraGioHang(){
        if(dsGioHang.isEmpty())
            System.out.println("Gio Hang Trong");
        for(CHITIETGIOHANG chitietgiohang : dsGioHang){
            System.out.println(chitietgiohang);
        }
    }
    public void XoaSanPham(String maSP){

        this.dsGioHang.removeIf(e->e.getSanpham().getMaSP().equals(maSP));
    }

    public List<CHITIETGIOHANG> getDsGioHang() {
        return dsGioHang;
    }

    public void setDsGioHang(List<CHITIETGIOHANG> dsGioHang) {
        this.dsGioHang = dsGioHang;
    }
}
