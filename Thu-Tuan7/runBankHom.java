package BankHom;

import java.util.Scanner;

public class runBankHom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyTaiKhoang TK = new QuanLyTaiKhoang();
        while (true) {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("Nhập lựa chọn của bạn:");
            int luachon = sc.nextInt();
            sc.nextLine();
            switch (luachon) {
                case 1: {
                    System.out.println("Nhập số tài khoản:");
                    String STK = sc.nextLine();
                    System.out.println("Nhập mật khẩu:");
                    String MK = sc.nextLine();

                    if (TK.DangNhapTaiKhoan(STK, MK)) {
                        TaiKhoan TKHT = new TaiKhoan(STK,"LEducvan",0.0,MK);
                        while (true){
                            System.out.println("1. Gửi tiền");
                            System.out.println("2. Rút tiền");
                            System.out.println("3. Đổi mật khẩu");
                            System.out.println("4. Kiểm tra số dư");
                            System.out.println("5. Đăng xuất");
                            int chon = sc.nextInt();
                            sc.nextLine();
                            switch (chon) {
                                case 1: {
                                    System.out.println("Nhập số tiền muốn gửi:");
                                    double soTien = sc.nextDouble();
                                    System.out.println("So Du hien tai"+TKHT.GuiTien(soTien));
                                    break;
                                }
                                case 2: {
                                    System.out.println("Nhập số tiền muốn rút:");
                                    double soTien = sc.nextDouble();
                                    System.out.println(TKHT.RutTien(soTien));
                                    break;
                                }
                                case 3: {

                                    System.out.println("Nhập mật khẩu mới:");
                                    String matKhau = sc.nextLine();

                                    System.out.println("Mat Khau Moi :"+TKHT.DoiMatKhau(matKhau));
                                    break;
                                }
                                case 4: {
                                    System.out.println(TKHT.KiemTraSoDu());
                                    break;
                                }
                                case 5: {
                                    System.out.println("Đăng xuất thành công.");
                                    break;
                                }
                                default:
                                    System.out.println("Lựa chọn không hợp lệ.");
                            }
                            if (chon == 5) break;
                        }
                    } else {
                        System.out.println("Đăng nhập không thành công.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhập số tài khoản:");
                    String STK = sc.nextLine();
                    System.out.println("Nhập mật khẩu:");
                    String MK = sc.nextLine();
                    System.out.println("Nhập tên chủ tài khoản:");
                    String TenDK = sc.nextLine(); // Bạn cần nhập tên chủ tài khoản
                    TK.DangKyTaiKhoang(STK, TenDK, MK);
                    System.out.println("Đăng ký thành công.");
                    break;
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
