package Tuan2.Tuan5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bai2 {
    private List arr = new ArrayList<>();
    public void nhap() {

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so phan tu");
        n = sc.nextInt();
        System.out.println("Nhap vao mang so nguyen");
        for (int i = 0; i < n; i++) {
            arr.add(sc.next());
        }
    }
    public List reverseArr(){
          Collections.reverse(this.arr);
          return this.arr;
    }
}
