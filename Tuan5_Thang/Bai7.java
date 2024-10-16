package Tuan2.Tuan5;

import java.util.*;

public class Bai7 {
    public static class SinhVien {
        private long MSV;
        private String Ten;
        private float DTB;

        @Override
        public String toString() {
            return "SinhVien{" +
                    "MSV=" + MSV +
                    ", Ten='" + Ten + '\'' +
                    ", DTB=" + DTB +
                    '}';
        }

        public float getDTB() {
            return DTB;
        }

        public void setDTB(float DTB) {
            this.DTB = DTB;
        }

        public String getTen() {
            return Ten;
        }

        public void setTen(String ten) {
            Ten = ten;
        }

        public long getMSV() {
            return MSV;
        }

        public void setMSV(long MSV) {
            this.MSV = MSV;
        }
    }

    List<SinhVien> danhSachSV = new ArrayList<SinhVien>();

    public void ThemSinhVien() {

        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhap so sinh vien: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            SinhVien sv = new SinhVien();
            System.out.println("Nhap ma sinh vien");
            sv.setMSV(sc.nextLong());
            System.out.println("Nhap ten sinh vien");
            sv.setTen(sc.next());
            System.out.println("Nhap diem trung binh");
            sv.setDTB(sc.nextFloat());
            this.danhSachSV.add(sv);
        }

    }

    public void xoaSinhVien(int index) {
        this.danhSachSV.remove(index);

    }

    public SinhVien timSVTheoMsv(long MSV) {
        return this.danhSachSV.stream().anyMatch(e -> e.getMSV() == MSV);
        // for (SinhVien sv : this.danhSachSV) {
        // if (sv.getMSV() == MSV) {
        // return sv;
        // }
        // }
        // return null;
    }

    public void sapXepTheoDiem() {
        Collections.sort(this.danhSachSV, new Comparator<SinhVien>() {
            public int compare(SinhVien sv1, SinhVien sv2) {
                return sv1.getDTB() < sv2.getDTB() ? 1 : -1;
            }
        });
    }

    public void inDanhSach() {
        for (SinhVien sv : this.danhSachSV) {
            System.out.println(sv);
        }
    }
}
