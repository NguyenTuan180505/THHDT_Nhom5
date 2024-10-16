package Tuan2.Tuan5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1 {
    private List<Integer> arr = new ArrayList<>();
    public void nhap() {

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so phan tu");
        n = sc.nextInt();
        System.out.println("Nhap vao mang so nguyen");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
    }
    public int Sum(){
        int sum = 0;
        for (int i = 0; i < this.arr.size(); i++) {
            sum += this.arr.get(i);
        }
        return sum;
    }



}
