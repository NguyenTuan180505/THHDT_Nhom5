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
                List<MAGIAMGIA> magiamgiaList = sanpham.getMaGiamGia();
                if(magiamgiaList.contains(mgg))
                    System.out.println("Ma Giam Gia da ton tai");
                else
                {
                    magiamgiaList.add(magiamgia);
                    sanpham.setMaGiamGia(magiamgiaList);
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
        String mgg,maSp;
        System.out.println("Nhap ma giam gia g0 ");
        mgg= sc.next();
        System.out.println("Nhap San Pham muon go ");
        maSp= sc.next();
        SANPHAM sanpham = danhSachSanPham.timSanPham(maSp);
        if(sanpham != null){
            MAGIAMGIA magiamgia =danhSachMaGiamGia.timMGG(mgg);
            if(magiamgia != null){
                List<MAGIAMGIA> magiamgiaList = sanpham.getMaGiamGia();
                if(magiamgiaList.contains(mgg)){
                    magiamgiaList.removeIf(e->e.getMa().equals(mgg));
                    sanpham.setMaGiamGia(magiamgiaList);
                    try {
                        danhSachMaGiamGia.ghiFile();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                else
                {
                        System.out.println("San pham khong chua ma giam gia nay");
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
    @Override
    public  void  themMoi(){
        Scanner sc = new Scanner(System.in);
        super.themMoi();
        System.out.println("Nhap tien thuong moi hoa don");
        thuongMoiHoaDon = sc.nextDouble();

    }

    @Override
    public String toString() {
        return "NHANVIENBANHANG{" +
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
