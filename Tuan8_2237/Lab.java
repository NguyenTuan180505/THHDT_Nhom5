package Tuan8_2237;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab {
    public static void main(String[] args) {
            int choice;
            Scanner sc = new Scanner(System.in);
            TKNganHang tk = new TKNganHang();
        TaiKhoanThanhToan tktt = new TaiKhoanThanhToan();
        TaiKhoanTietKiem tktk = new TaiKhoanTietKiem();

            if(tk.getChuTaiKhoan()==null)
            {
                tk.dangKy();
            }
            boolean kt;
            int i=0;
                     System.out.println("-----Dang Nhap------- ");
            do {

                if(i >=5) {
                    System.out.println("Ban Nhap sai qua nhieu lan ");
                    return;
                }
                String ctk, mk;
                System.out.println("Nhap chu tai khoan");
                ctk = sc.next();
                System.out.println("Nhap Mat khau");
                mk = sc.next();
                if(!tk.dangNhap(ctk,mk)) {
                    kt = false;
                    i++;
                    System.out.println("-----Thong tin dang nhap khong chinh xac--- \n" +
                            "Vui long nhap lai");
                }
                else
                    kt=true;

            }while (!kt );


            do{
                System.out.println("\n============MENU==========");
                System.out.println( "1.Tra cuu thong tin \n" +
                        "2.Rut tien \n" +

                        "3.Doi mat khau \n" +
                        "4.Thay doi thong tin tai khoan \n" +
                        "5.Mở Tài Khoản Thanh toán \n" +
                        "6.Mở Tài Khoản tiết kiem \n" +
                        "0.Thoat chuong trinh \n");
                System.out.println("Nhap Lua chon");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:{
                        System.out.println(tk);
                        break;
                    }

                    case 2:
                    {
                        double tienRut;
                        System.out.println("Nhap So tien Ban Muon rut");
                        tienRut = sc.nextDouble();
                        tk.rutTien(tienRut);
                        break;
                    }

                    case 3:
                    {    boolean check=false;

                        do {
                            String mkCu,mkMOi;
                            System.out.println("Nhap mat khau cu");
                            mkCu = sc.next();
                            System.out.println("Nhap mat khau moi");
                            mkMOi = sc.next();
                            check= tk.doiMatKhau(mkCu,mkMOi);
                        }
                        while(!check);

                        break;

                    }
                    case 4:
                    {
                        System.out.println("Nhap Stk");
                        tk.setSoTaiKhoan(sc.next());
                        System.out.println("Nhap Ctk");
                        tk.setChuTaiKhoan(sc.next());
                        break;
                    }
                    case 5:
                    {
                        int lc;
                        if(tktt.soTaiKhoan == null )
                        tktt.dangKy(tk.getSoTaiKhoan(), tk.getChuTaiKhoan(), tk.getSoDu());



                        do {

                            System.out.println("\n============MENU==========");
                            System.out.println( "1.Tra cuu thong tin \n" +
                                    "2.Rut tien \n" +
                                    "3.Tru Phi Dich Vu\n" +
                                    "4.Nap tien\n" +
                                    "0.Quay lại \n");
                            System.out.println("Nhap Lua chon");
                            lc=sc.nextInt();
                            switch (lc) {
                                case 1:{
                                    System.out.println(tktt);
                                    break;
                                }
                                case 2:
                                {
                                    double tienRut;
                                    String Pin;
                                    System.out.println( "Nhap So tien Ban Muon rut");
                                    tienRut = sc.nextDouble();
                                    System.out.println("Nhap Ma Pin");
                                    Pin = sc.next();
                                    tktt.rutTien(tienRut,Pin);
                                    break;
                                }
                                case 3:
                                {
                                    tktt.truPhiDichVu();
                                    break;

                                }
                                case 4:
                                {
                                    double tienNap;
                                    System.out.println("Nhap So tien Ban Muon nap");
                                    tienNap = sc.nextDouble();
                                    tktt.guiTien(tienNap);
                                    break;
                                }

                            }
                        } while ( lc !=0);
                        break;

                    }
                    case 6: {
                        int lc;
                        if (tktk.soTaiKhoan == null)
                            tktk.dangKy(tk.getSoTaiKhoan(), tk.getChuTaiKhoan());
                        do {

                            System.out.println("\n============MENU==========");
                            System.out.println("1.Tra cuu thong tin \n" +
                                    "2.Tinh lai \n" +
                                    "3.Nap Tien Tiet Kiem\n" +
                                    "0.Quay lại \n");
                            System.out.println("Nhap Lua chon");
                            lc = sc.nextInt();
                            switch (lc) {
                                case 1:{
                                    System.out.println(tktk);
                                    break;
                                }
                                case 2:
                                {
                                    tktk.tinhLai();
                                    break;
                                }
                                case 3:
                                {
                                    double tienNap;
                                    System.out.println("Nhap So tien Ban Muon nap vao tai khoan tiet kiem");
                                    tienNap = sc.nextDouble();
                                    tktk.guiTien(tienNap);
                                    break;

                                }
                            }



                        } while (lc !=0);
                        break;
                    }
                    case 0 :
                        System.out.println("Dang Xuat");
                        break;
                    default: {
                        System.out.println("Lua chon khon phu hop ");
                    }
                }

            }
            while (choice != 0);



}
}
