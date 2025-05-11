package assignment2;

import java.util.Scanner;

public class PrintReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cod = 0;
		int temp = n;
		while (temp > 0) {
			int rem = temp % 10;
			cod++;
			temp /= 10;
		}
		int ans = 0;
		while (cod >= 0) {
			int rem = n % 10;
			ans = (int) (ans + rem * Math.pow(10, cod - 1));
			n /= 10;
			cod--;
		}
		System.out.println(ans);
		sc.close();
	}
}