import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KHACHHANG extends PERSON {
    private  double diemTichLuy;
    private List<HOADON> lichSuMuaHang =new ArrayList<>();

    public KHACHHANG() {
        role= VAITRO.KHACHHANG;
    }

    public KHACHHANG(PERSON person) {
        super(person.id, person.name, person.email, person.SDT, person.address,person.password);

    }

    public double getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(double diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public List<HOADON> getLichSuMuaHang() {
        return lichSuMuaHang;
    }

    public void setLichSuMuaHang(List<HOADON> lichSuMuaHang) {
        this.lichSuMuaHang = lichSuMuaHang;
    }

    public void capNhatDiemTichLuy(double soTien) {
        this.diemTichLuy += (int) (soTien / 100000);
    }
    public  void datHang( GIOHANG giohang,KHACHHANG khachhang){
        DanhSachTaiKhoan ds = new DanhSachTaiKhoan();
        try {
            ds.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
        DanhSachHoaDon danhSachHoaDon  = new DanhSachHoaDon();
        try {
            danhSachHoaDon.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }

        if(giohang == null)
        {
            System.out.println("gio hang trong vui long them san pham vao gio hang");
            return;
        }

        HOADON hoadon = new HOADON(TaoMaNgauNhien.generateRandomString(5),khachhang.getId(), TrangThai.CHOXULI);
        for(CHITIETGIOHANG chitietgiohang : giohang.getDsGioHang()){

           hoadon.themChiTietHoaDon(chitietgiohang.getSanpham(),chitietgiohang.getSoLuong());
        }
        hoadon.setTongTien(hoadon.tinhTongTien());
        danhSachHoaDon.themHoaDon(hoadon);
        this.lichSuMuaHang.add(hoadon);
        ds.capnhatTK(this);
        try {
            ds.ghiFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            danhSachHoaDon.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public String toString() {
        return "KHACHHANG{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", SDT='" + SDT + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", diemTichLuy=" + diemTichLuy +
                ", lichSuMuaHang=" + lichSuMuaHang +
                '}';
    }
}
