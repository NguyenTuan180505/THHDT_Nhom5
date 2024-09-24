package baitaptuan3;

import java.util.Scanner;

public class Bai6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập số thứ nhất: ");
		double num1 = sc.nextDouble();

		System.out.println("Nhập số thứ hai: ");
		double num2 = sc.nextDouble();

		System.out.println("Chọn phép tính: ");
		System.out.println("1. Cộng");
		System.out.println("2. Trừ");
		System.out.println("3. Nhân");
		System.out.println("4. Chia");

		int choice = sc.nextInt();
		double result;

		switch (choice) {
		case 1:
			result = num1 + num2;
			System.out.println("Kết quả: " + result);
			break;
		case 2:
			result = num1 - num2;
			System.out.println("Kết quả: " + result);
			break;
		case 3:
			result = num1 * num2;
			System.out.println("Kết quả: " + result);
			break;
		case 4:
			if (num2 != 0) {
				result = num1 / num2;
				System.out.println("Kết quả: " + result);
			} else {
				System.out.println("Không thể chia cho 0");
			}
			break;
		default:
			System.out.println("Lựa chọn không hợp lệ");
		}
	}

}
