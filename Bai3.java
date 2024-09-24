package baitaptuan3;

import java.util.Scanner;

public class Bai3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhập hệ số a: ");
		double a = sc.nextDouble();
		System.out.print("Nhập hệ số b: ");
		double b = sc.nextDouble();
		System.out.print("Nhập hệ số c: ");
		double c = sc.nextDouble();

		double delta = b * b - 4 * a * c;

		if (a == 0) {
			if (b != 0) {
				System.out.println("Phương trình có một nghiệm: " + (-c / b));
			} else {
				System.out.println(c == 0 ? "Phương trình vô số nghiệm" : "Phương trình vô nghiệm");
			}
		} else {
			if (delta > 0) {
				double x1 = (-b + Math.sqrt(delta)) / (2 * a);
				double x2 = (-b - Math.sqrt(delta)) / (2 * a);
				System.out.println("Phương trình có 2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
			} else if (delta == 0) {
				double x = -b / (2 * a);
				System.out.println("Phương trình có nghiệm kép: x = " + x);
			} else {
				System.out.println("Phương trình vô nghiệm");
			}
		}
	}

}
