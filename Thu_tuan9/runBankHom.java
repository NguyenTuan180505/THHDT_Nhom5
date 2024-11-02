package BankHom;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class runBankHom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyTaiKhoang TK = new QuanLyTaiKhoang();
        TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan();
        TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem();
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
                        TaiKhoan TKHT = TK.timTaiKhoan(STK);

                        while (true) {
                            System.out.println("0. Đăng Xuất");
                            System.out.println("1. Gửi tiền");
                            System.out.println("2. Rút tiền");
                            System.out.println("3. Đổi mật khẩu");
                            System.out.println("4. Kiểm tra số dư");
                            System.out.println("5. Gửi Tiết Kiệm");
                            System.out.println("6. Tài Khoản Thanh Toán");
                            int chon = sc.nextInt();
                            sc.nextLine();

                            switch (chon) {
                                case 1: {
                                    System.out.println("Nhập số tiền muốn gửi: ");
                                    double soTien = sc.nextDouble();
                                    sc.nextLine();
                                    TKHT.GuiTien(soTien);
                                    System.out.println("Số dư hiện tại: " + TKHT.KiemTraSoDu());
                                    break;
                                }
                                case 2: {
                                    System.out.println("Nhập số tiền muốn rút: ");
                                    double soTien = sc.nextDouble();
                                    sc.nextLine();
                                    TKHT.RutTien(soTien);
                                    System.out.println("Rút tiền thành công.");
                                    break;
                                }
                                case 3: {
                                    while (true) {
                                        System.out.println("Nhập mật khẩu cũ:");
                                        String mkcu = sc.nextLine();
                                        if (TKHT.getPasswork().equals(mkcu)) {
                                            break;
                                        }
                                        System.out.println("Mật khẩu cũ sai.");
                                    }
                                    System.out.println("Nhập mật khẩu mới:");
                                    String matKhau = sc.nextLine();
                                    TKHT.DoiMatKhau(matKhau);
                                    System.out.println("Đổi mật khẩu thành công.");
                                    break;
                                }
                                case 4: {
                                    System.out.println("Số dư hiện tại: " + TKHT.KiemTraSoDu());
                                    break;
                                }
                                case 5: {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                    while (true) {
                                        System.out.println("1. Gửi tiết kiệm trực tuyến");
                                        System.out.println("2. Xem số dư tài khoản tiết kiệm");
                                        System.out.println("3. Rút tiền");
                                        System.out.println("4. Tính lãi suất và xem tiền lãi ");
                                        System.out.println("5. Thoát");

                                        int chonTK = sc.nextInt();
                                        sc.nextLine();

                                        switch (chonTK) {
                                            case 1: {
                                                System.out.println("Nhập số tiền muốn gửi tiết kiệm:");
                                                double soTienGuiTietKiem;
                                                while (true) {
                                                    soTienGuiTietKiem = sc.nextDouble();
                                                    if (soTienGuiTietKiem <= TKHT.getSoDu())
                                                        break;
                                                    System.out.println("Số tiền vượt quá tài khoản chính.");
                                                }
                                                tkTietKiem.GuiTienTietKiem(soTienGuiTietKiem);
                                                TKHT.RutTien(soTienGuiTietKiem);

                                                System.out.println("Nhập kỳ hạn theo tháng:");
                                                int KyHan = sc.nextInt();
                                                sc.nextLine();
                                                tkTietKiem.setThoiGianGuiTietKiem(KyHan);
                                                tkTietKiem.setLaiXuat(KyHan <= 12 ? 0.045 : 0.054);
                                                tkTietKiem.setTienLai(tkTietKiem.TienLaiDaGui());

                                                System.out.println("Nhập ngày bắt đầu (dd-MM-yyyy):");
                                                String NgayBatDau = sc.nextLine();
                                                LocalDate localDate = LocalDate.parse(NgayBatDau, formatter);
                                                tkTietKiem.setNgayBatDau(localDate);
                                                System.out.println("Gửi tiền thành công vào tài khoản tiết kiệm.");
                                                break;
                                            }
                                            case 2: {
                                                System.out.println("Số dư tài khoản tiết kiệm của bạn là: " + tkTietKiem.getSoDuTietKiem());
                                                break;
                                            }
                                            case 3: {
                                                tkTietKiem.TienLaiDaGui();
                                                System.out.println("Chọn:");
                                                System.out.println("1. Nhận lãi");
                                                System.out.println("2. Rút tiền ");
                                                int ChonRut = sc.nextInt();
                                                sc.nextLine();
                                                if (ChonRut == 1) {
                                                    tkTietKiem.TienLaiDaGui();
                                                    tkTietKiem.RutLai();
                                                } else if (ChonRut == 2) {
                                                    tkTietKiem.RutTien();
                                                    TKHT.GuiTien(tkTietKiem.getSoDuTietKiem());
                                                } else {
                                                    System.out.println("Lựa chọn không hợp lệ.");
                                                }
                                                break;
                                            }
                                            case 4: {
                                                tkTietKiem.TienLaiDaGui();
                                                System.out.println("Lãi suất của bạn là " + tkTietKiem.getLaiXuat() * 100 + "%");
                                                System.out.println("Tiền lãi của bạn là " + tkTietKiem.getTienLai() + " đồng");
                                                break;
                                            }
                                            case 5: {
                                                System.out.println("Thoát khỏi quản lý tài khoản tiết kiệm.");
                                                break;
                                            }
                                            default:
                                                System.out.println("Lựa chọn không hợp lệ.");
                                                break;
                                        }
                                        if (chonTK == 5) break;
                                    }
                                    break;
                                }
                                case 6: {

                                    while (true) {
                                        System.out.println("1. Gửi tiền vào tài khoản thanh toán");
                                        System.out.println("2. Rút tiền từ tài khoản thanh toán");
                                        System.out.println("3. Kiểm tra số dư tài khoản thanh toán");
                                        System.out.println("4. Thoát");

                                        int chonTT = sc.nextInt();
                                        sc.nextLine();

                                        switch (chonTT) {
                                            case 1: {
                                                System.out.println("Nhập số tiền muốn gửi: ");
                                                double soTienGui = sc.nextDouble();
                                                tkThanhToan.GuiTienThanhToan(soTienGui);
                                                break;
                                            }
                                            case 2: {
                                                System.out.println("Nhập số tiền muốn rút: ");
                                                double soTienRut = sc.nextDouble();
                                                tkThanhToan.RutTien(soTienRut);
                                                break;
                                            }
                                            case 3: {
                                                System.out.println("Số dư tài khoản thanh toán là: " + tkThanhToan.KiemTraSoDu());
                                                break;
                                            }
                                            case 4: {
                                                System.out.println("Thoát khỏi tài khoản thanh toán.");
                                                break;
                                            }
                                            default:
                                                System.out.println("Lựa chọn không hợp lệ.");
                                                break;
                                        }
                                        if (chonTT == 4) break;
                                    }
                                    break;
                                }
                                case 0: {
                                    System.out.println("Đăng xuất thành công.");
                                    break;
                                }
                                default:
                                    System.out.println("Lựa chọn không hợp lệ.");
                                    break;
                            }
                            if (chon == 0) break;
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
                    String TenDK = sc.nextLine();
                    if (!TK.KiemTraTaiKhoanTonTai(STK)) {
                        TK.DangKyTaiKhoang(STK, TenDK, MK);
                        System.out.println("Đăng ký tài khoản thành công.");
                    } else {
                        System.out.println("Số tài khoản đã tồn tại.");
                    }
                    break;
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }
}
