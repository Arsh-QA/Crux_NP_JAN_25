package assignment2;

import java.util.Scanner;

public class OddEven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			int sumOdd = 0;
			int sumEven = 0;
			while (temp > 0) {
				int rem = temp % 10;
				if (rem % 2 == 0) {
					sumEven += rem;
				} else {
					sumOdd += rem;
				}
				temp = temp / 10;
			}
			if (sumOdd % 3 == 0 || sumEven % 4 == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		sc.close();
	}
}