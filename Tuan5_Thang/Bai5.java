package Tuan2.Tuan5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai5 {

    private List<Integer> arr = new ArrayList<>();
    public void nhap() {

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so phan tu");
        n = sc.nextInt();
        System.out.println("Nhap vao mang so nguyen");
        for (int i = 0; i < n; i++) {
            this.arr.add(sc.nextInt());
        }
    }
    public void inTungPhanTU(){
        for (int i = 0; i < this.arr.size(); i++) {
            System.out.println(this.arr.get(i));
        }

    }
    public void inMang(){
        System.out.println(this.arr);
    }
}
