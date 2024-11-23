package DanhSach;

import Interface.DocGhiFile;
import Service.TaoMaNgauNhien;
import Service.Validator;
import TaiKhoan.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachTaiKhoan implements DocGhiFile {
    private List<PERSON> dsTaiKhoan= new ArrayList<>();
@Override
    public void ghiFile() throws Exception {

        try (FileOutputStream fileOut = new FileOutputStream("taikhoan.txt");
             ObjectOutputStream objectOut =  new ObjectOutputStream(fileOut)) {

            // Ghi từng đối tượng vào file
            for (Object tk : this.dsTaiKhoan) {

                if(tk instanceof KHACHHANG)
                {

                    KHACHHANG kh = (KHACHHANG) tk;
                    objectOut.writeObject(kh);

                }
                else if(tk instanceof NHANVIENKHO)
                {

                    NHANVIENKHO nv = (NHANVIENKHO) tk;
                    objectOut.writeObject(nv);

                }
                else if( tk instanceof NHANVIENBANHANG)
                {

                    NHANVIENBANHANG nv = (NHANVIENBANHANG)tk;
                    objectOut.writeObject(nv);
                }
                else  {

                    PERSON per = (PERSON) tk;
                    objectOut.writeObject(per);
                }
            }
            objectOut.flush();
            objectOut.close();

            System.out.println("Đã ghi thêm danh sách STAFF vào file taikhoan.txt");
        } catch (IOException ex) {
            System.out.println("Đã xảy ra lỗi khi ghi vào file: " + ex.getMessage());
        }
    }

@Override
    public void docFile() throws Exception {
        this.dsTaiKhoan = new ArrayList<>(); // Khởi tạo lại danh sách
        File file = new File("taikhoan.txt");
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + file.getName());
            return;
        }
        try (FileInputStream fileIn = new FileInputStream("taikhoan.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                        Object obj = objectIn.readObject();

                        if(obj instanceof KHACHHANG)
                        {
                            KHACHHANG tk = (KHACHHANG) obj;
                            this.dsTaiKhoan.add(tk);
                        }
                        else if(obj instanceof NHANVIENKHO)
                        {
                            NHANVIENKHO tk = (NHANVIENKHO) obj;
                            this.dsTaiKhoan.add(tk);
                        }
                        else if( obj instanceof NHANVIENBANHANG)
                        {

                            NHANVIENBANHANG tk = (NHANVIENBANHANG)obj;
                            this.dsTaiKhoan.add(tk);
                        }
                        else  {

                            PERSON tk = (PERSON) obj;
                            this.dsTaiKhoan.add(tk);
                        }

                } catch (EOFException e) {
                    // Kết thúc khi đến cuối file
                    break;
                }
            }
            System.out.println("Đã đọc danh sách  từ file taikhoan.txt");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Đã xảy ra lỗi khi đọc từ file: " + e.getMessage());
        }
    }

    public  void themTK(PERSON tk){
        this.dsTaiKhoan.add(tk);
        try {
            this.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void remove(){
        this.dsTaiKhoan.removeIf(e->e instanceof PERSON);
    }
    public  void Xuat (){
        if(this.dsTaiKhoan.isEmpty()){
            System.out.println("Danh sach rong");
        }
        for (PERSON tk : this.dsTaiKhoan) {

            System.out.println(tk);
        }
    }
    public Object dangNhap(String email,String mk){

          Object object= this.dsTaiKhoan.stream().filter( e->e.getEmail().equals(email) && e.getPassword().equals(mk)).findFirst().orElse(null);
          if(object== null)
              return null;
          if(object instanceof KHACHHANG){
              return  (KHACHHANG)object;
          }
          else if(object instanceof NHANVIENKHO){
              return  (NHANVIENKHO)object;
          }
          else if(object instanceof NHANVIENBANHANG){
              return  (NHANVIENBANHANG)object;
          }
          else if(object instanceof NHANVIENGIAOHANG) {
              return  (NHANVIENGIAOHANG) object;

          }
          else {
              return  (PERSON)object;
          }


    }
    public void dangKy(){
        Scanner sc = new Scanner(System.in);
        boolean emailValid = false, sdtValid = false, idValid = false;
        PERSON tk = new PERSON();
        System.out.println("Ban chua co tai khoan can dang ky");
        tk.setId(TaoMaNgauNhien.generateRandomString(5));
        while (!emailValid){
            try{
                String email;
                System.out.println("Nhap Email");
                email = sc.nextLine();
                Validator.isValidEmail(email);
                tk.setEmail(email);
                emailValid = true;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        while (!sdtValid){
            try {
                String sdt;
                System.out.println("Nhap SDT");
                sdt = sc.nextLine();
                Validator.isValidPhone(sdt);
                tk.setSDT(sdt);
                sdtValid = true;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }




        System.out.println("Nhap dia chi");
        tk.setAddress(sc.nextLine());
        System.out.println("Nhap Mat khau");
        tk.setPassword(sc.next());
        this.dsTaiKhoan.add(tk);
        try {
            this.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    public PERSON timSTK(String email){
        return  this.dsTaiKhoan.stream().filter(e->e.getEmail().equals(email)).findFirst().orElse(null);
    }
    public KHACHHANG timMaKH(String maKH){
        return  (KHACHHANG) this.dsTaiKhoan.stream().filter(e->e.getId().equals(maKH)).findFirst().orElse(null);
    }
    public void capnhatTK(PERSON tk) {
        this.dsTaiKhoan.replaceAll(e -> {
            if (e.getEmail().equals(tk.getEmail())) {
                return tk;
            }
            return e;
        });
    }
    public void taoTkNhanVienbanhang() {
        NHANVIENBANHANG nv = new NHANVIENBANHANG();
        nv.themMoi();
        this.dsTaiKhoan.add(nv);
        try {
            this.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void  taoTKNhanVienKho(){
        NHANVIENKHO nv = new NHANVIENKHO();
        nv.themMoi();
        this.dsTaiKhoan.add(nv);
        try {
            this.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void taoTkNhanVienGiaoHang(){
        NHANVIENGIAOHANG nhanviengiaohang =new NHANVIENGIAOHANG();
        nhanviengiaohang.themMoi();
        this.dsTaiKhoan.add(nhanviengiaohang);
        try {
            this.ghiFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
