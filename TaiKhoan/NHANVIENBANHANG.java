package TaiKhoan;

import BanHang.HOADON;
import BanHang.MAGIAMGIA;
import BanHang.SANPHAM;
import ChiTiet.CHITIETHOADON;
import DanhSach.DanhSachHoaDon;
import DanhSach.DanhSachMaGiamGia;
import DanhSach.DanhSachSanPham;
import DanhSach.DanhSachTaiKhoan;
import Enum.VAITRO;
import Enum.TrangThai;
import Enum.HinhThucThanhToan;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NHANVIENBANHANG extends  NHANVIEN {

    private double thuongMoiHoaDon;

    public NHANVIENBANHANG(NHANVIEN nhanvien,double thuongMoiHoaDon) {
        super(nhanvien.id, nhanvien.name,nhanvien.email,nhanvien.SDT, nhanvien.address,nhanvien.password, nhanvien.luongCoBan, nhanvien.phuCap);
        this.thuongMoiHoaDon = thuongMoiHoaDon;
    }

    public NHANVIENBANHANG() {
        role = VAITRO.NHANVIENBANHANG;
    }
    public void xacNhanDon(){
        DanhSachHoaDon danhSachHoaDon  = new DanhSachHoaDon();
        try {
            danhSachHoaDon.docFile();

        } catch (Exception e) {
            System.out.println(e);
        }
        List<HOADON> hoadonXuLI  = danhSachHoaDon.getDsHoaDon().stream().filter(e->e.getTrangThaiDH().equals(TrangThai.CHOXULI)).toList();

        List<String> maHd=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
                    while (true) {
                        for(HOADON hoadon : hoadonXuLI){
                            System.out.println(hoadon);
                        }
                        String maHoaDon ;
                        System.out.println("Nhap ma hoa don (0/ket thuc): ");
                        maHoaDon = sc.nextLine();
                        if(maHoaDon.equals("0"))
                            break;
                        maHd.add(maHoaDon);
                    }
                    danhSachHoaDon.xacNhanDon(maHd);
    }
    public void taoMaGiamGia (){
        DanhSachMaGiamGia danhSachMaGiamGia =new DanhSachMaGiamGia();
            try {
                danhSachMaGiamGia.docFile();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        MAGIAMGIA magiamgia = new MAGIAMGIA();
        magiamgia.taoMaGG();
        if(danhSachMaGiamGia.timMGG(magiamgia.getMa()) != null)
            System.out.println("Ma Giam Gia da ton tai");
        else {
            danhSachMaGiamGia.themMGG(magiamgia);
            try {
                danhSachMaGiamGia.ghiFile();
                System.out.println("Tao ma giam gia thanh cong");
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
    public void themMGGChoSanPham(){
        Scanner sc = new Scanner(System.in);
        DanhSachSanPham danhSachSanPham =new DanhSachSanPham();
        try {
            danhSachSanPham.docFile();
        } catch (Exception e) {
            System.out.println(e);
        }
        DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia();
        try {
            danhSachMaGiamGia.docFile();
        } catch (Exception e) {
            System.out.println(e);
        }
        danhSachSanPham.xuatSanPham();
        String mgg,maSp;
        System.out.println("Nhap ma giam gia ");
        mgg= sc.next();
        System.out.println("Nhap San Pham muon them ");
        maSp= sc.next();
        SANPHAM sanpham = danhSachSanPham.timSanPham(maSp);
        if(sanpham != null){
            MAGIAMGIA magiamgia =danhSachMaGiamGia.timMGG(mgg);
            if(magiamgia != null){
                MAGIAMGIA magiamgiaSp = sanpham.getMaGiamGia();
                if(magiamgiaSp.equals(magiamgia))
                    System.out.println("Ma Giam Gia da ton tai");
                else
                {
                    sanpham.setMaGiamGia(magiamgia);
                    danhSachSanPham.capNhatSanPham(sanpham);
                    try {
                        danhSachSanPham.ghiFile();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
            else {
                System.out.println("Nhap ma giam gia khong hop le");
            }
        }
        else {
            System.out.println("San Pham khong ton tai");
        }


    }
    public void goMGGchoSanPham(){
        Scanner sc = new Scanner(System.in);
        DanhSachSanPham danhSachSanPham =new DanhSachSanPham();
        try {
            danhSachSanPham.docFile();
        } catch (Exception e) {
            System.out.println(e);
        }
        DanhSachMaGiamGia danhSachMaGiamGia = new DanhSachMaGiamGia();
        try {
            danhSachMaGiamGia.docFile();
        } catch (Exception e) {
            System.out.println(e);
        }
        danhSachSanPham.xuatSanPham();
        String maSp;
        System.out.println("Nhap San Pham muon go ");
        maSp= sc.next();
        SANPHAM sanpham = danhSachSanPham.timSanPham(maSp);
        if(sanpham != null){
            sanpham.setMaGiamGia(null);
            danhSachSanPham.capNhatSanPham(sanpham);
            try {
                danhSachMaGiamGia.docFile();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            System.out.println("San Pham khong ton tai");
        }



    }
    public void xuLiTraHang(){
        Scanner sc = new Scanner(System.in);
        DanhSachTaiKhoan danhSachTaiKhoan =new DanhSachTaiKhoan();
        try {
            danhSachTaiKhoan.docFile();
        }
        catch (Exception e) {
        }
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
        try {
            danhSachSanPham.docFile();
        }
        catch (Exception e) {
        }
        DanhSachHoaDon danhSachHoaDon = new DanhSachHoaDon();
        try {
            danhSachHoaDon.docFile();
        }
        catch (Exception e) {
        }
        List<HOADON> hoaDonTraHang = danhSachHoaDon.getDsHoaDon().stream().filter(e->e.getTrangThaiDH().equals(TrangThai.CHOXULITRAHANG)).toList();
        int choice;
        do {

            System.out.println("\n============MENU==========");
            System.out.println("1.Chon Don hang muon xu li \n" +
                    "2.Tra cuu Hoa don tra hang \n" +
                    "0.Thoat\n"
            );

            System.out.println("Nhap lua chon");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:{
                    String maHd;
                    System.out.println("Nhap vao ma hoa don muon xu li");
                    maHd= sc.nextLine();
                    HOADON hoadonxuli = danhSachHoaDon.timHoaDon(maHd);
                    System.out.println("1.Xac nhan tra hang \n" +
                            "2.Tu choi tra hang \n" +
                            "3.Huy\n"
                                );
                    int lc;
                    lc = sc.nextInt();
                    sc.nextLine();
                    switch (lc) {
                        case 1:{
                            hoadonxuli.setTrangThaiDH(TrangThai.TRAHANG);
                            List<CHITIETHOADON> chitiethoadon = hoadonxuli.getChiTietHoaDon();
                            for(CHITIETHOADON chitiet:chitiethoadon){
                                SANPHAM sanphamKho =danhSachSanPham.timSanPham(chitiet.getSanPham().getMaSP());
                                sanphamKho.setSoLuong(sanphamKho.getSoLuong()+chitiet.getSoLuong());
                                danhSachSanPham.capNhatSanPham(sanphamKho);
                            }
                            KHACHHANG kh = danhSachTaiKhoan.timMaKH(hoadonxuli.getMaKH());
                            kh.getLichSuMuaHang().replaceAll(e->{
                                if(e.getMaHD().equals(hoadonxuli.getMaHD()))
                                {
                                    return  hoadonxuli;
                                }
                                return e;
                            });
                            if(hoadonxuli.getHinhThucThanhToan().equals(HinhThucThanhToan.NGANHANG))
                            {
                                TKNganHang tkKH= kh.getTkNganHang();
                                tkKH.setSoDu(tkKH.getSoDu()+ hoadonxuli.getTongTien());
                                kh.setTkNganHang(tkKH);
                            }
                            danhSachHoaDon.capNhatHoaDon(hoadonxuli);
                            danhSachTaiKhoan.capnhatTK(kh);
                            try {
                                danhSachHoaDon.ghiFile();
                            }
                            catch (Exception e) {
                            }
                            try {
                                danhSachSanPham.ghiFile();
                            }
                            catch (Exception e) {
                            }
                            try {
                                danhSachTaiKhoan.ghiFile();
                            }
                            catch (Exception e) {
                            }
                            break;

                        }
                        case 2:{
                            System.out.println("Nhap li do tu choi tra hang");
                            String lido = sc.nextLine();
                            hoadonxuli.setTrangThaiDH(TrangThai.TRAHANGTHATBAI);
                            hoadonxuli.setMoTa(lido);
                            KHACHHANG kh = danhSachTaiKhoan.timMaKH(hoadonxuli.getMaKH());
                            kh.getLichSuMuaHang().replaceAll(e->{
                                if(e.getMaHD().equals(hoadonxuli.getMaHD())){
                                    return  hoadonxuli;
                                }
                                return e;
                            });
                            danhSachHoaDon.capNhatHoaDon(hoadonxuli);
                            danhSachTaiKhoan.capnhatTK(kh);
                            try {
                                danhSachHoaDon.ghiFile();
                            }
                            catch (Exception e){}
                            try {
                                danhSachTaiKhoan.ghiFile();
                            }
                            catch (Exception e){}
                            break;
                        }
                        case 3:{
                            break;
                        }
                    }

                }
                case 2:{
                    for (HOADON hoaDon : hoaDonTraHang) {
                        System.out.println(hoaDon);
                    }
                    break;
                }
                default:{
                    System.out.println("Lua chon khong hop le ");
                }
            }
        }while (choice!=0);

    }
    @Override
    public  void  themMoi(){
        Scanner sc = new Scanner(System.in);
        super.themMoi();
        System.out.println("Nhap tien thuong moi hoa don");
        thuongMoiHoaDon = sc.nextDouble();

    }

    @Override
    public String toString() {
        return "TaiKhoan.NHANVIENBANHANG{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", SDT='" + SDT + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", luongCoBan=" + luongCoBan +
                ", phuCap=" + phuCap +
                ", thuongMoiHoaDon=" + thuongMoiHoaDon +
                '}';
    }
}
