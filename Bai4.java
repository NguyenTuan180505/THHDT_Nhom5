package baitaptuan3;

import java.util.Scanner;

public class Bai4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhập số a: ");
		double a = sc.nextDouble();
		System.out.print("Nhập số b: ");
		double b = sc.nextDouble();
		System.out.print("Nhập số c: ");
		double c = sc.nextDouble();

		double min = a;

		if (b < min) {
			min = b;
		}
		if (c < min) {
			min = c;
		}

		System.out.println("Số nhỏ nhất là: " + min);
	}

}
