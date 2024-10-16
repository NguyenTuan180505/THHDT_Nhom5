package Tuan2.Tuan5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bai3 {
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
    public List sortArrAsc(){
        Collections.sort(arr);

        return this.arr;

    }
}
