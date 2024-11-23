package DanhSach;

import BanHang.NHAPHANG;
import Interface.DocGhiFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DanhSachNhapHang implements DocGhiFile {
    private List<NHAPHANG> dsNhapHang =new ArrayList<>();
    public DanhSachNhapHang() {}
    @Override
    public void ghiFile() throws Exception {

        try (FileOutputStream fileOut = new FileOutputStream("NhapHang.txt");
             ObjectOutputStream objectOut =  new ObjectOutputStream(fileOut)) {

            // Ghi từng đối tượng vào file
            for (NHAPHANG nhaphang : this.dsNhapHang) {
                objectOut.writeObject(nhaphang);
            }
            objectOut.flush();
            objectOut.close();

            System.out.println("Đã ghi thêm danh sách STAFF vào file NhapHang.txt");
        } catch (IOException ex) {
            System.out.println("Đã xảy ra lỗi khi ghi vào file: " + ex.getMessage());
        }
    }

@Override
    public void docFile() throws Exception {
        this.dsNhapHang = new ArrayList<>(); // Khởi tạo lại danh sách
        File file = new File("NhapHang.txt");
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + file.getName());
            return;
        }
        try (FileInputStream fileIn = new FileInputStream("NhapHang.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    NHAPHANG nhaphang = (NHAPHANG) objectIn.readObject();
                    this.dsNhapHang.add(nhaphang);
                } catch (EOFException e) {
                    // Kết thúc khi đến cuối file
                    break;
                }
            }
            System.out.println("Đã đọc danh sách  từ file NhapHang.txt");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Đã xảy ra lỗi khi đọc từ file: " + e.getMessage());
        }
    }
    public void Xuat(){
        for(NHAPHANG nhaphang : this.dsNhapHang){
            System.out.println(nhaphang);
        }
    }
    public void themNhapHang(NHAPHANG nhaphang){
        this.dsNhapHang.add(nhaphang);
    }

}
