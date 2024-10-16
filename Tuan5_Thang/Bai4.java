package Tuan2.Tuan5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai4 {
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
    public void findMaxElementAppear (){
        int max=1 ;
        int indexMax = 0;
    for (int i = 0; i < this.arr.size(); i++) {
        int count = 0 ;
         for (int j = i; j < this.arr.size(); j++) {
             if (this.arr.get(i).equals(this.arr.get(j))) {
                 count ++;
             }
}
         if (count > max) {
             max = count ;
             indexMax = i ;
         }


    }
    System.out.println();
    if (max > 1)
    System.out.println(this.arr.get(indexMax));
    else System.out.println("cac phan tu xuat hien nhu nhau");

    }
}
