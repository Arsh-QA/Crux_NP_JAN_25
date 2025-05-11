package assignment2;

import java.util.Scanner;

public class ReplaceThemAll {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long mul = 1;
		long ans = 0;
		if (n == 0)
			System.out.println(5);
		else {
			while (n > 0) {
				long digit = n % 10;
				if (digit == 0) {
					digit = 5;
				}
				ans += digit * mul;
				mul = mul * 10;
				n = n / 10;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}