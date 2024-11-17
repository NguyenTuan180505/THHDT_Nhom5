import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DanhSachSanPham {
     private List<SANPHAM > dsSanPham = new ArrayList<SANPHAM>();

    public void ghiFile() throws Exception {

        try (FileOutputStream fileOut = new FileOutputStream("SanPham.txt");
             ObjectOutputStream objectOut =  new ObjectOutputStream(fileOut)) {

            // Ghi từng đối tượng vào file
            for (SANPHAM sp : this.dsSanPham) {
                objectOut.writeObject(sp);
            }
            objectOut.flush();
            objectOut.close();

            System.out.println("Đã ghi thêm danh sách STAFF vào file SanPham.txt");
        } catch (IOException ex) {
            System.out.println("Đã xảy ra lỗi khi ghi vào file: " + ex.getMessage());
        }
    }


    public void docFile() throws Exception {
        this.dsSanPham = new ArrayList<>(); // Khởi tạo lại danh sách
        File file = new File("SanPham.txt");
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + file.getName());
            return;
        }
        try (FileInputStream fileIn = new FileInputStream("SanPham.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    SANPHAM sp = (SANPHAM) objectIn.readObject();
                    this.dsSanPham.add(sp);
                } catch (EOFException e) {
                    // Kết thúc khi đến cuối file
                    break;
                }
            }
            System.out.println("Đã đọc danh sách  từ file SanPham.txt");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Đã xảy ra lỗi khi đọc từ file: " + e.getMessage());
        }
    }
    public List<SANPHAM> getDsSanPham() {
        return dsSanPham;
    }

    public void setDsSanPham(List<SANPHAM> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }
    public  void themSanPham(SANPHAM sanpham){
        this.dsSanPham.add(sanpham);
    }
    public void xuatSanPham(){
        for (SANPHAM sp : this.dsSanPham) {
            System.out.println(sp);
        }
    }

    public  SANPHAM timSanPham (String maSp){
return  this.dsSanPham.stream().filter(e->e.getMaSP().equals(maSp)).findFirst().orElse(null);
    }
    public void capNhatSanPham(SANPHAM sanpham){
        this.dsSanPham.replaceAll(e -> {
            if (e.getMaSP().equals(sanpham.getMaSP()) ){
                return  sanpham;
            }
            return e;
        });

    }
}
