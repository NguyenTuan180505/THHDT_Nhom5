package Thang_Tuan7;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab {
    public static void main(String[] args) {
            int choice;
            Scanner sc = new Scanner(System.in);
            TKNganHang tk = new TKNganHang();
            if(tk.getChuTaiKhoan()==null)
            {
                System.out.println("Ban chua co tai khoan can dang ky");
                System.out.println("Nhap So tai khoan");
                tk.setSoTaiKhoan(sc.next());
                System.out.println("Nhap chu tai khoan");
                tk.setChuTaiKhoan(sc.next());
                System.out.println("Nhap Mat khau");
                tk.setMatKhau(sc.next());

            }
            boolean kt=true;
            int i=0;
                     System.out.println("-----Dang Nhap------- ");
            do {

                String ctk, mk;
                System.out.println("Nhap chu tai khoan");
                ctk = sc.next();
                System.out.println("Nhap Mat khau");
                mk = sc.next();
                if(!tk.dangNhap(ctk,mk)) {
                    kt = false;
                    System.out.println("-----Thong tin dang nhap khong chinh xac--- \n" +
                            "Vui long nhap lai");
                }
                if(i > 3) {
                    System.out.println("Ban Nhap sai qua nhieu lan ");
                    return;
                }
                i++;

            }while (!kt );

            System.out.println( "1.Tra cuu thong tin \n" +
                    "2.Rut tien \n" +
                    "3.Nap tien\n" +
                    "4.Doi mat khau \n" +
                    "5.Thay doi thong tin tai khoan \n" +
                    "0.Thoat chuong trinh ");
            do{
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
                    {
                        double tienNap;
                        System.out.println("Nhap So tien Ban Muon nap");
                        tienNap = sc.nextDouble();
                        tk.guiTien(tienNap);
                        break;
                    }
                    case 4:
                    {
                        String mkCu,mkMOi;
                        System.out.println("Nhap mat khau cu");
                        mkCu = sc.next();
                        System.out.println("Nhap mat khau moi");
                        mkMOi = sc.next();
                        tk.doiMatKhau(mkCu,mkMOi);
                        break;

                    }
                    case 5:
                    {
                        System.out.println("Nhap Stk");
                        tk.setSoTaiKhoan(sc.next());
                        System.out.println("Nhap Ctk");
                        tk.setChuTaiKhoan(sc.next());
                    }
                    default:
                    {
                        System.out.println("Lua chon khon phu hop ");
                    }
                }

            }
            while (choice != 0);

}
}
