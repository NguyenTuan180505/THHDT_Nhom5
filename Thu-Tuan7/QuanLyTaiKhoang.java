package BankHom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyTaiKhoang {
    public List<TaiKhoan> DanhsachtaiKhoan;

    public QuanLyTaiKhoang() {
        DanhsachtaiKhoan = new ArrayList<TaiKhoan>();
    }

    public void DangKyTaiKhoang(String STK, String TenDK, String MK) {
        for (TaiKhoan TK : DanhsachtaiKhoan) {
            if (TK.getSoTaiKhoan().equals(STK)) {
                System.out.println("Tai khoan da ton tai!");
            }
        }
        DanhsachtaiKhoan.add(new TaiKhoan(STK, TenDK, 0.0, MK));
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

        @Override
        public String toString() {
            return this.DanhsachtaiKhoan.toString();
        }
}
