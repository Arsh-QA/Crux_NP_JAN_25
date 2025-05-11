package assignment2;

import java.util.Scanner;

public class PrintArmstrongNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int i = n1;
		while (i <= n2) {
			if (isArmstrongNumber(i))
				System.out.println(i);
			i++;
		}
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
