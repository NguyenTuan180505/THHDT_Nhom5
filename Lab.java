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
        person.setRole(VAITRO.NGUOIQUANTRI);
        person.setEmail("admin@gmail.com");
        person.setPassword("123");
        ds.themTK(person);
        DanhSachHoaDon danhSachHoaDon = new DanhSachHoaDon();
        try {
            danhSachHoaDon.docFile();

        }
        catch (Exception e) {
            System.out.println(e);
        }
  for(HOADON hoadon: danhSachHoaDon.getDsHoaDon()){
      System.out.println(hoadon);
  }

    }
}
