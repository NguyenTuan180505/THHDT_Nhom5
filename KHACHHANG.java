import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class KHACHHANG extends PERSON {
    private  double diemTichLuy;
    private TKNganHang tkNganHang;
    private List<HOADON> lichSuMuaHang =new ArrayList<>();

    public TKNganHang getTkNganHang() {
        return tkNganHang;
    }

    public void setTkNganHang(TKNganHang tkNganHang) {
        this.tkNganHang = tkNganHang;
    }

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
        if(giohang.getDsGioHang().isEmpty())
        {
            System.out.println("gio hang trong vui long them san pham vao gio hang");
            return;
        }
        Scanner sc = new Scanner(System.in);
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
        DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia();
        try {
            danhSachMaGiamGia.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
boolean dathanhtoan =false;
while (true) {
    int choice;
    if(dathanhtoan)
        break;
    System.out.println("\n============MENU==========");
    System.out.println("1.Thanh toan khi nhan hang \n" +
            "2.Thanh toan bang the ngan hang \n" +
            "4.Kiem tra ma giam gia\n" +
            "3.Thoat\n"
    );

    HOADON hoadon = new HOADON();
    System.out.println("Nhap lua chon");
    choice = sc.nextInt();
    sc.nextLine();
    switch (choice) {
        case 1: {
            System.out.println("Nhap dia chi giao hang");
            String dc = sc.nextLine();

            hoadon = new HOADON(TaoMaNgauNhien.generateRandomString(5), khachhang.getId(), dc, HinhThucThanhToan.COD, TrangThai.CHOXULI);
            for (CHITIETGIOHANG chitietgiohang : giohang.getDsGioHang()) {
                hoadon.themChiTietHoaDon(chitietgiohang.getSanpham(), chitietgiohang.getSoLuong());
            }
            hoadon.setTongTien(hoadon.tinhTongTien());
            danhSachHoaDon.themHoaDon(hoadon);
            this.lichSuMuaHang.add(hoadon);
            ds.capnhatTK(this);
            dathanhtoan =true;
            break;
        }
        case 2: {
            System.out.println("Nhap dia chi giao hang");
            String dc = sc.nextLine();
            if (khachhang.getTkNganHang() != null) {
                hoadon = new HOADON(TaoMaNgauNhien.generateRandomString(5), khachhang.getId(), dc, HinhThucThanhToan.NGANHANG, TrangThai.CHOXULI);

                for (CHITIETGIOHANG chitietgiohang : giohang.getDsGioHang()) {

                    hoadon.themChiTietHoaDon(chitietgiohang.getSanpham(), chitietgiohang.getSoLuong());
                }
                hoadon.setTongTien(hoadon.tinhTongTien());
                if (khachhang.getTkNganHang().thanhToan(hoadon.getTongTien())) {
                    danhSachHoaDon.themHoaDon(hoadon);
                    this.lichSuMuaHang.add(hoadon);
                    ds.capnhatTK(this);
                    dathanhtoan =true;
                } else {
                    System.out.println("Khong du so du trong tai khoan");
                }
                break;
            } else {
                TKNganHang tkNganHang = new TKNganHang();
                tkNganHang.themTk();
                khachhang.setTkNganHang(tkNganHang);
                hoadon = new HOADON(TaoMaNgauNhien.generateRandomString(5), khachhang.getId(), dc, HinhThucThanhToan.NGANHANG, TrangThai.CHOXULI);

                for (CHITIETGIOHANG chitietgiohang : giohang.getDsGioHang()) {

                    hoadon.themChiTietHoaDon(chitietgiohang.getSanpham(), chitietgiohang.getSoLuong());
                }
                hoadon.setTongTien(hoadon.tinhTongTien());
                if (khachhang.getTkNganHang().thanhToan(hoadon.getTongTien())) {
                    danhSachHoaDon.themHoaDon(hoadon);
                    this.lichSuMuaHang.add(hoadon);
                    ds.capnhatTK(this);
                    dathanhtoan =true;
                } else {
                    System.out.println("Khong du so du trong tai khoan");
                }
                break;
            }
        }
        case 4: {
            danhSachMaGiamGia.xuatMGG();
        }
        case 0: {
            System.out.println("Thoat");

            break;
        }
        default:
            System.out.println("Lua chon khong hop le");

    }
}


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
    public void TraHang(KHACHHANG khachhang){
        Scanner sc = new Scanner(System.in);
        DanhSachTaiKhoan danhSachTaiKhoan  = new DanhSachTaiKhoan();
        try {
            danhSachTaiKhoan.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
        DanhSachHoaDon danhSachHoaDon = new DanhSachHoaDon();
        try {
            danhSachHoaDon.docFile();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        List<HOADON>  lichSu= khachhang.getLichSuMuaHang();
        List<HOADON> lichSuMuaThanhCong = lichSu.stream().filter(e->e.getTrangThaiDH().equals(TrangThai.GIAOTHANHCONG)).toList();
        int choice;
        do{

            System.out.println("\n============MENU==========");
            System.out.println("1.Chon Don hang muon tra \n" +
                    "2.Lich Su mua hang thanh cong \n" +
                    "0.Thoat\n"
            );

            System.out.println("Nhap lua chon");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                {
                    boolean traHang= false;
                    String lido;
                    String maDh;
                    System.out.println("Nhập mã sản phẩm muốn tra hang:");
                    maDh = sc.nextLine();
                    for (var dh : lichSuMuaThanhCong) {
                        if(dh.getMaHD().equals(maDh)){
                            dh.setTrangThaiDH(TrangThai.CHOXULITRAHANG);
                            System.out.println("Nhap li do tra hang");
                            lido= sc.nextLine();
                            dh.setMoTa(lido);
                            danhSachHoaDon.capNhatHoaDon(dh);
                            khachhang.getLichSuMuaHang().replaceAll(e->{
                               if(e.getMaHD().equals(dh.getMaHD())){
                                   return  dh;
                               }
                               else return e;
                           });
                            danhSachTaiKhoan.capnhatTK(khachhang);
                            try {
                                danhSachTaiKhoan.ghiFile();
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
                           traHang =true;
                            break;
                        }
                    }
                    if(traHang)
                        System.out.println("Yeu cau tra hang thanh cong");
                    else
                        System.out.println("Yeu cau tra hang that bai");
                    break;
                }
                case 2:{
                    for(HOADON hoadon : lichSuMuaThanhCong) {
                        System.out.println(hoadon);
                        }
                    }
                }

        }while (choice != 0);

    }
    public void DanhGia(KHACHHANG khachhang){
        Scanner sc = new Scanner(System.in);
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
        try {
            danhSachSanPham.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }

        List<HOADON>  lichSu= khachhang.getLichSuMuaHang();
        List<HOADON> lichSuMuaThanhCong = lichSu.stream().filter(e->e.getTrangThaiDH().equals(TrangThai.GIAOTHANHCONG)).toList();
        int choice;
        do{

            System.out.println("\n============MENU==========");
            System.out.println("1.Chon San Pham muon Danh gia \n" +
                    "2.Lich Su mua hang thanh cong \n" +
                    "0.Thoat\n"
            );

            System.out.println("Nhap lua chon");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                {
                    boolean isDanhGia = false;
                    String maSp;
                    System.out.println("Nhập mã sản phẩm muốn đánh giá:");
                    maSp = sc.nextLine();

                    for (var dh : lichSuMuaThanhCong) {
                        for (var ct : dh.getChiTietHoaDon()) {
                            if (ct.getSanPham().getMaSP().equals(maSp)) {
                                DANHGIA danhgia = new DANHGIA();
                                danhgia.taoDanhGia(khachhang);
                                SANPHAM sanpham = ct.getSanPham();
                                List<DANHGIA> danhgiaList = sanpham.getDanhGia();
                                danhgiaList.add(danhgia);
                                sanpham.setDanhGia(danhgiaList);

                                danhSachSanPham.capNhatSanPham(sanpham);

                                try {
                                    danhSachSanPham.ghiFile();
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                isDanhGia = true;

                                break;
                            }
                        }
                        if (isDanhGia) break;
                    }
                    if (isDanhGia) {
                        System.out.println("Đánh giá thành công!");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm với mã đã nhập.");
                    }
                    break;
                }
                case 2:{
                    for(HOADON hoadon : lichSuMuaThanhCong) {
                        for(CHITIETHOADON chitiethoadon : hoadon.getChiTietHoaDon()) {
                            System.out.println(chitiethoadon);
                        }
                    }
                }
            }

        }while (choice != 0);


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
                '}';
    }
}
