import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DanhSachMaGiamGia {
    private List<MAGIAMGIA> danhSachMaGG;

    public DanhSachMaGiamGia(List<MAGIAMGIA> danhSachMaGG) {
        this.danhSachMaGG = danhSachMaGG;
    }
    public  DanhSachMaGiamGia() {
        danhSachMaGG = new ArrayList<MAGIAMGIA>();
    }

    public void ghiFile() throws Exception {

        try (FileOutputStream fileOut = new FileOutputStream("MaGiamGia.txt");
             ObjectOutputStream objectOut =  new ObjectOutputStream(fileOut)) {

            // Ghi từng đối tượng vào file
            for (MAGIAMGIA magiamgia : this.danhSachMaGG) {
                objectOut.writeObject(magiamgia);
            }
            objectOut.flush();
            objectOut.close();

            System.out.println("Đã ghi thêm danh sách STAFF vào file MaGiamGia.txt");
        } catch (IOException ex) {
            System.out.println("Đã xảy ra lỗi khi ghi vào file: " + ex.getMessage());
        }
    }
    public  MAGIAMGIA timMGG(String maGG){
        return  this.danhSachMaGG.stream().filter(e->e.getMa().equals(maGG)).findFirst().orElse(null);
    }
    public void themMGG(MAGIAMGIA magiamgia){
        this.danhSachMaGG.add(magiamgia);
    }
    public void xuatMGG(){
        for(MAGIAMGIA magiamgia : this.danhSachMaGG){
            System.out.println(magiamgia);
        }
    }

    public void docFile() throws Exception {
        this.danhSachMaGG = new ArrayList<>(); // Khởi tạo lại danh sách
        File file = new File("MaGiamGia.txt");
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + file.getName());
            return;
        }
        try (FileInputStream fileIn = new FileInputStream("MaGiamGia.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    MAGIAMGIA magiamgia = (MAGIAMGIA) objectIn.readObject();
                    this.danhSachMaGG.add(magiamgia);
                } catch (EOFException e) {
                    // Kết thúc khi đến cuối file
                    break;
                }
            }
            System.out.println("Đã đọc danh sách  từ file MaGiamGia.txt");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Đã xảy ra lỗi khi đọc từ file: " + e.getMessage());
        }
    }
}
