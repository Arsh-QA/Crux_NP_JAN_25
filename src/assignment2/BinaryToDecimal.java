package assignment2;

import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int ans = 0;
		int pos = 0;
		while (n > 0) {
			int r = n % 10;
			ans = ans + r * (int) (Math.pow(2, pos));
			n = n / 10;
			pos++;
		}
		System.out.println(ans);
		s.close();
	}
}