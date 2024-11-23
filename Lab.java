import DanhSach.DanhSachTaiKhoan;
import TaiKhoan.PERSON;
import Enum.VAITRO;
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
//        PERSON person = new PERSON();
//        person.setId("123");
//        person.setRole(VAITRO.NGUOIQUANTRI);
//        person.setEmail("admin@gmail.com");
//        person.setPassword("123");
//        ds.themTK(person);


//
//        DanhSach.DanhSachHoaDon danhSachHoaDon = new DanhSach.DanhSachHoaDon();
//        try {
//            danhSachHoaDon.docFile();
//
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//  for(BanHang.HOADON hoadon: danhSachHoaDon.getDsHoaDon()){
//      System.out.println(hoadon);
//  }

    }
}
