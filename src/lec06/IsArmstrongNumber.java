package lec06;

import java.util.Scanner;

public class IsArmstrongNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(isArmstrongNumber(n));
		sc.close();
	}

	public static boolean isArmstrongNumber(int n) {
		int cod = countOfDigits(n);
		int sum = 0;
		int temp = n;
		while (n > 0) {
			int rem = n % 10;
			sum = (int) (sum + Math.pow(rem, cod));
			n = n / 10;
		}
		if (sum == temp) {
			return true;
		} else {
			return false;
		}
	}

	public static int countOfDigits(int n) {
		int c = 0;
		while (n > 0) {
			n = n / 10;
			c++;
		}
		return c;
	}

}
