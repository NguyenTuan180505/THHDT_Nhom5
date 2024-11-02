package BankHom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyTaiKhoang {
    public List<TaiKhoan> DanhsachtaiKhoan;

    public QuanLyTaiKhoang() {
        DanhsachtaiKhoan = new ArrayList<TaiKhoan>();
    }

    public boolean KiemTraTaiKhoanTonTai(String SoTaiKhoan) {
        for (TaiKhoan TK1 : DanhsachtaiKhoan) {
            if (TK1.getSoTaiKhoan().equals(SoTaiKhoan)) {
                return true;
            }
        }
        return false;
    }

    public void DangKyTaiKhoang(String STK, String TenDK, String MK) {
        DanhsachtaiKhoan.add(new TaiKhoan(STK, TenDK, 0.0, MK));
        System.out.println("dang ky thanh cong");
    }


    public boolean DangNhapTaiKhoan(String STK, String MK) {
        for (TaiKhoan TK : DanhsachtaiKhoan) {
            if (TK.getSoTaiKhoan().equals(STK) && TK.getPasswork().equals(MK)) {
                System.out.println("dang nhap thành công");
                return true;
            }
        }
        return false;
    }

    public TaiKhoan timTaiKhoan(String soTaiKhoan) {
        for (TaiKhoan tk : DanhsachtaiKhoan) {
            if (tk.getSoTaiKhoan().equals(soTaiKhoan)) {
                return tk;
            }
        }
        return null;
    }

    public void hienThiDanhSachTaiKhoan() {
        for (TaiKhoan tk : DanhsachtaiKhoan) {
            System.out.println(tk);
        }
    }

}

