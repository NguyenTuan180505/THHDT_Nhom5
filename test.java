import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        DanhSachTaiKhoan ds = new DanhSachTaiKhoan();

        PERSON tk = new PERSON();

        KHACHHANG kh = new KHACHHANG();
        NHANVIENBANHANG nhanvienbanhang = new NHANVIENBANHANG();
        NHANVIENKHO nhanvienkho = new NHANVIENKHO();
        NHANVIENGIAOHANG nhanviengiaohang = new NHANVIENGIAOHANG();
        Scanner sc = new Scanner(System.in);
        int dn;
        try {
            ds.docFile();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("\n============MENU==========");
        System.out.println("1.Dang Nhap \n" +
                "2.Dang Ki \n" +
                "0.Thoat \n");
        System.out.println("Nhap Lua chon");
        dn = sc.nextInt();
        sc.nextLine();
        switch (dn) {
            case 1: {
                boolean kt;
                int i = 0;

                String email, mk;
                System.out.println("-----Dang Nhap------- ");
                do {

                    if (i >= 5) {
                        System.out.println("Ban Nhap sai qua nhieu lan ");
                        return;
                    }

                    System.out.println("Nhap Email");
                    email = sc.nextLine();
                    System.out.println("Nhap Mat khau");
                    mk = sc.nextLine();

                    Object obj = ds.dangNhap(email, mk);
                    if (obj instanceof KHACHHANG) {
                        kh = (KHACHHANG) obj;
                        break;
                    } else if (obj instanceof NHANVIENBANHANG) {
                        nhanvienbanhang = (NHANVIENBANHANG) obj;
                        break;

                    } else if (obj instanceof NHANVIENKHO) {
                        nhanvienkho = (NHANVIENKHO) obj;
                        break;

                    }
                    else if(obj instanceof NHANVIENGIAOHANG) {
                        nhanviengiaohang = (NHANVIENGIAOHANG) obj;
                        break;
                    }
                    else if(obj instanceof PERSON) {
                        tk = (PERSON) obj;
                        break;
                    }

                    if (obj == null ) {
                        kt = false;
                        i++;
                        System.out.println("-----Thong tin dang nhap khong chinh xac--- \n" +
                                "Vui long nhap lai");
                    } else
                        kt = true;

                } while (!kt);
                break;
               }
            case 2: {
                ds.dangKy();
                boolean kt;
                int i = 0;
                System.out.println("-----Dang Nhap------- ");
                do {

                    if (i >= 5) {
                        System.out.println("Ban Nhap sai qua nhieu lan ");
                        return;
                    }
                    String email, mk;
                    System.out.println("Nhap chu Email");
                    email = sc.next();
                    System.out.println("Nhap Mat khau");
                    mk = sc.next();

                    Object obj = ds.dangNhap(email, mk);
                    if (obj instanceof KHACHHANG) {
                        kh = (KHACHHANG) obj;
                    } else if (obj instanceof NHANVIENBANHANG) {
                        nhanvienbanhang = (NHANVIENBANHANG) obj;

                    } else if (obj instanceof NHANVIENKHO) {
                        nhanvienkho = (NHANVIENKHO) obj;
                    }
                    else if(obj instanceof NHANVIENGIAOHANG) {
                        nhanviengiaohang = (NHANVIENGIAOHANG) obj;
                        break;
                    }
                    else {
                        tk = (PERSON) obj;
                    }
                    if (obj == null) {
                        kt = false;
                        i++;
                        System.out.println("-----Thong tin dang nhap khong chinh xac--- \n" +
                                "Vui long nhap lai");
                    } else
                        kt = true;

                } while (!kt);
                break;
            }
            case 0: {
                System.out.println("Thoat");
                return;
            }
            default: {
                System.out.println("Lua chon khong hop le ");
            }
        }
        if (kh.getEmail() != null || (tk.getRole().equals(VAITRO.KHACHHANG) && tk.getEmail() != null)) {
            GIOHANG giohang = new GIOHANG();
            if (kh.getEmail() == null)
                kh = new KHACHHANG(tk);
            int choice;
            do {
                System.out.println("\n============MENU==========");
                System.out.println("1.Tra cuu thong tin \n" +
                        "2.Mua Hang \n" +
                        "3.Kiem Tra Gio Hang \n" +
                        "4.Xoa San Pham ra Gio Hang \n" +
                        "5.Tra cuu lich su Mua Hang\n" +
                        "6.Dat hang \n" +
                        "7.Tra Hang\n"+
                        "8.Danh Gia San Pham \n"+
                        "9.Xoa Tai Khoan \n" +
                        "0.Thoat chuong trinh \n");
                System.out.println("Nhap Lua chon");
                choice = sc.nextInt();
                DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
                try {
                    danhSachSanPham.docFile();

                } catch (Exception e) {
                    System.out.println(e);
                }

                switch (choice) {
                    case 1: {
                        System.out.println(kh);
                        break;
                    }
                    case 2: {
                        danhSachSanPham.xuatSanPham();
                        String maSp;
                        while (true) {
                            double soLuong;
                            System.out.println("Nhap san pham ban muon mua nhap thoat de thoat");
                            maSp = sc.next();
                            if (maSp.equals("Thoat"))
                                break;
                            System.out.println("Nhap so luong");
                            soLuong = sc.nextDouble();
                            SANPHAM sp = danhSachSanPham.timSanPham(maSp);
                            if (sp != null) {
                                giohang.themSp(sp, soLuong);

                            } else
                                System.out.println("San pham khong ton tai");
                        }
                    }
                    break;
                    case 3: {
                        giohang.kiemTraGioHang();
                        break;

                    }
                    case 4: {
                        String maSp;
                        System.out.println("Nhap Ma san pham muon xoa");
                        maSp = sc.next();
                        giohang.XoaSanPham(maSp);
                        break;
                    }
                    case 5: {
                        List<HOADON> lichSuMuaHang = kh.getLichSuMuaHang();
                        if (lichSuMuaHang == null)
                            System.out.println("Ban chua mua don hang nao");
                        else
                            for (HOADON h : lichSuMuaHang) {
                                System.out.println(h);
                            }
                        break;
                    }
                    case 6: {
                        kh.datHang(giohang,kh);
                        break;
                    }
                    case 7:{
                        kh.TraHang(kh);

                        break;
                    }
                    case 8:{
                        kh.DanhGia(kh);
                        break;
                    }
                    case 9:{
                        break;
                    }
                    case 0:{
                        System.out.println("Dang xuat");
                        break;
                    }
                    default:
                        System.out.println("Lua chon khong hop le ");
                }

            } while (choice != 0);
        }
        else if (tk.getRole().equals(VAITRO.NGUOIQUANTRI)) {
            int choice;
            do {
                System.out.println("\n============MENU==========");
                System.out.println("1.Tao tai khoan nhan vien ban hang\n" +
                        "2.Tao tai Khoan nhan vien kho\n" +
                        "3.Tao tai khoan nhan vien kho \n"+
                        "0.Thoat chuong trinh \n");
                System.out.println("Nhap Lua chon");
                choice = sc.nextInt();
                try {
                    ds.docFile();

                } catch (Exception e) {
                    System.out.println(e);
                }
                switch (choice) {
                    case 1: {
                        ds.taoTkNhanVienbanhang();
                        break;

                    }
                    case 2: {
                        ds.taoTKNhanVienKho();
                        break;
                    }
                    case 3:{
                        ds.taoTkNhanVienGiaoHang();
                        break;
                    }
                }
            } while (choice != 0);

        }
        else if (nhanvienbanhang.getEmail() !=null) {
            int choice;
            do {
                System.out.println("\n============MENU==========");
                System.out.println("1.Xac Nhan don \n" +
                        "2.Tao ma giam gia\n" +
                        "3.Them ma giam gia cho san pham\n"+
                        "4.Go ma giam gia khoi san pham\n"+
                        "5.Xoa ma giam gia\n"+
                        "6.Thong Ke Doanh thu\n"+
                        "0.Thoat chuong trinh \n");
                System.out.println("Nhap Lua chon");
                choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        nhanvienbanhang.xacNhanDon();
                        break;

                    }
                    case 2:{
                        nhanvienbanhang.taoMaGiamGia();
                        break;
                    }
                    case 3:{
                        nhanvienbanhang.themMGGChoSanPham();
                        break;
                    }
                    case 4:{
                        nhanvienbanhang.goMGGchoSanPham();
                        break;
                    }
                    case 5:{
                        break;
                    }
                    case 6:{
                        break;
                    }
                }
            } while (choice != 0);
        } else if (nhanvienkho.getEmail() != null){
            int choice;
            do {
                System.out.println("\n============MENU==========");
                System.out.println("1.Kiem tra hang trong kho\n" +
                        "2.Nhap hang\n" +
                        "3.Cap nhat gia ban\n"+
                        "4.Tim Kiem Hang hoa\n"+
                        "5.Xuat Hang \n"+
                        "0.Thoat chuong trinh \n");
                System.out.println("Nhap Lua chon");
                choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                            nhanvienkho.hangTrongKho();
                            break;
                    }
                    case 2: {
                        nhanvienkho.quanLiNhapHang();
                        break;
                    }
                    case 3:{
                        String maSp;
                        double gia;
                        System.out.println("Nhap Ma san pham ban muon dieu chinh gia");
                        maSp = sc.next();
                        System.out.println("Nhap Gia muon dieu chinh");
                        gia = sc.nextDouble();
                        nhanvienkho.capNhatGiaBan(maSp,gia);
                        break;
                    }
                    case 4:{
                        String maSp;
                        System.out.println("Nhap Ma san pham ban Tim kiem");
                        maSp = sc.next();
                        SANPHAM sanpham =nhanvienkho.timSanPham(maSp);
                        if(sanpham!= null){
                            System.out.println(sanpham);
                        }
                        else System.out.println("San Pham khong ton tai");
                    }
                    case 5:{
                        nhanvienkho.xuatKho();
                        break;
                    }
                    case 0: {
                        System.out.println("dang xuat");
                        return;
                    }
                    default:
                        System.out.println("Lua chon khong hop le");
                }
            } while (choice != 0);
        } else if (nhanviengiaohang.getEmail() != null) {
            int choice;
            do {
                System.out.println("\n============MENU==========");
                System.out.println("1.Xu li don giao \n" +
                        "0.Thoat chuong trinh \n");
                System.out.println("Nhap Lua chon");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:{
                        nhanviengiaohang.xuLiDonGiao();
                    }
                }
            } while (choice != 0);


        }
    }
    }


