package baitaptuan3;

import java.util.Scanner;

public class Bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap so can kiem tra");
		int NumBer = sc.nextInt();
		if (NumBer > 0) {
			System.out.println("so :" + NumBer + "la so duong");
		} else if (NumBer < 0) {

			System.out.println("so :" + NumBer + "la so am");
		} else {
			System.out.println("so :" + NumBer + "=0");
		}

	}
}
