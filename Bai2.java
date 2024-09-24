package baitaptuan3;

import java.util.Scanner;

public class Bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap diem trung binh");
		double dtb = sc.nextDouble();
		if (dtb >= 8.5)
			System.out.println("gioi");

		else if (dtb >= 7)
			System.out.println("kha");

		else if (dtb >= 5.5)
			System.out.println("trung binh");
		else
			System.out.println("yeu");

	}
}
