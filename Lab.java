import BanHang.HOADON;
import DanhSach.DanhSachHoaDon;
import DanhSach.DanhSachNhapHang;
import DanhSach.DanhSachTaiKhoan;
import TaiKhoan.NHANVIENBANHANG;
import TaiKhoan.NHANVIENKHO;
import TaiKhoan.PERSON;
import Enum.VAITRO;
import Enum.TrangThai;

import java.time.LocalDate;

public class Lab {
    public static void main(String[] args) {
        DanhSachTaiKhoan ds = new DanhSachTaiKhoan();
        try {
            ds.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }


        ds.Xuat();
        PERSON person = new PERSON();
        person.setId("123");
        person.setRole(VAITRO.NGUOIQUANTRI);
        person.setEmail("admin@gmail.com");
        person.setPassword("123");
        ds.themTK(person);
        try {
            ds.ghiFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
//

    }
}
