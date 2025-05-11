package assignment2;

import java.util.Scanner;

public class ChewbaccaAndNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long mul = 1;
		long ans = 0;
		while (n > 0) {
			long rem = n % 10;
			if ((n != 9) && (9 - rem < rem)) {
				ans = ans + (9 - rem) * mul;
			} else {
				ans = ans + rem * mul;
			}
			n = n / 10;
			mul = mul * 10;
		}
		System.out.println(ans);

		sc.close();
	}
}
