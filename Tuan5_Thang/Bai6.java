package Tuan2.Tuan5;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Bai6 {
    private List arr = new ArrayList<>();
    public void nhap() {

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so phan tu");
        n = sc.nextInt();
        System.out.println("Nhap vao mang phan tu");
        for (int i = 0; i < n; i++) {
            this.arr.add(sc.next());
        }
    }
    public void themPhantu(int index, String  element ){
this.arr.add(index, element);
    }
    public void xoaPhanTu(int index){
        this.arr.remove(index);
    }
    public List in(){
        return this.arr;
    }


}
