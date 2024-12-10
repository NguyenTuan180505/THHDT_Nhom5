package TaiKhoan;

import BanHang.HOADON;
import BanHang.NHAPHANG;
import BanHang.SANPHAM;
import DanhSach.DanhSachHoaDon;
import DanhSach.DanhSachNhapHang;
import DanhSach.DanhSachSanPham;
import Enum.TrangThai;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Enum.VAITRO;
public class NHANVIENKHO extends NHANVIEN{
    private List<NHAPHANG> danhSachNhap;


    public NHANVIENKHO( NHANVIEN nhanvien, List<NHAPHANG> danhSachNhap) {
        super(nhanvien.id, nhanvien.name,nhanvien.email,nhanvien.SDT, nhanvien.address,nhanvien.password, nhanvien.luongCoBan, nhanvien.phuCap);
        this.danhSachNhap = danhSachNhap;
    }

    public NHANVIENKHO() {
        role = VAITRO.NHANVIENKHO;
    }
    @Override
        public  void themMoi(){
        super.themMoi();
    }
    public void quanLiNhapHang (){
        NHAPHANG nhaphang = new NHAPHANG();
        Scanner sc = new Scanner(System.in);
        SANPHAM sanpham= new SANPHAM();
        String maSp;

        System.out.println("Nhap ma san pham: (0/de thoat) ");
        while (true) {
            maSp = sc.nextLine();
            if(maSp.equals("0"))
                break;
            nhaphang.themChiTietNhapHang(maSp);
        }

    }
    public void hangTrongKho(){
        DanhSachSanPham danhSachSanPham =new DanhSachSanPham();
        try {
            danhSachSanPham.docFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        danhSachSanPham.xuatSanPham();
    }
    public  void kiemTraHoaDonNhapHang(){
        DanhSachNhapHang danhSachNhapHang = new DanhSachNhapHang();
        try {
            danhSachNhapHang.docFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        danhSachNhapHang.Xuat();
    }
    public void capNhatGiaBan (String maSp,double giaBan){
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
        try {
            danhSachSanPham.docFile();

        } catch (Exception e) {
            System.out.println(e);
        }
        SANPHAM sanpham = danhSachSanPham.timSanPham(maSp);
        if(sanpham != null){
            sanpham.setGiaBan(giaBan);
            danhSachSanPham.capNhatSanPham(sanpham);
            try {
                danhSachSanPham.ghiFile();

            } catch (Exception e) {
                System.out.println(e);
            }

        }
        else {
            System.out.println("San Pham khong ton tai");
        }

    }
    public SANPHAM timSanPham(String maSp){
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
        try {
            danhSachSanPham.docFile();

        } catch (Exception e) {
            System.out.println(e);
        }
        return  danhSachSanPham.timSanPham(maSp);
    }
    public void xuatKho(){
        DanhSachHoaDon danhSachHoaDon  = new DanhSachHoaDon();
        try {
            danhSachHoaDon.docFile();

        } catch (Exception e) {
            System.out.println(e);
        }
        List<HOADON> hoadonXacNhan  = danhSachHoaDon.getDsHoaDon().stream().filter(e->e.getTrangThaiDH().equals(TrangThai.XACNHAN)).toList();
        for(HOADON hoadon : hoadonXacNhan){
            System.out.println(hoadon);
        }
        List<String> maHd=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n============MENU==========");
            System.out.println("1.Nhap Ma Hoa Don Xuat kho \n" +
                    "2.Huy Hoa Don \n" +
                    "0.Thoat \n");
            System.out.println("Nhap Lua chon");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                {
                    while (true) {
                        String maHoaDon ;
                        System.out.println("Nhap ma hoa don (0/ket thuc): ");
                        maHoaDon = sc.nextLine();
                        if(maHoaDon.equals("0"))
                            break;
                        maHd.add(maHoaDon);
                    }
                    danhSachHoaDon.xuatHoaDon(maHd);
                    break;
                }
                case 2:
                {
                    while (true){
                        String maHoaDon ;
                        String lido;
                        System.out.println("Nhap ma hoa don (0/ket thuc): ");
                        maHoaDon = sc.next();
                        if(maHoaDon.equals("0"))
                            break;
                        System.out.println("Nhap li do Huy hoa don");
                        sc.nextLine();
                        lido= sc.nextLine();
                        danhSachHoaDon.HuyHoaDon(maHoaDon,lido);
                    }
                    break;
                }
                case 0:{
                    return;
                }
                default:{
                    System.out.println("Lua chon khong hop le ");
                }
            }
        } while ( choice != 0 );



    }

    @Override
    public String toString() {
        return "TaiKhoan.NHANVIENKHO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", SDT='" + SDT + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", luongCoBan=" + luongCoBan +
                ", phuCap=" + phuCap +
                ", Vaitro=" + role +
                '}';
    }
}
