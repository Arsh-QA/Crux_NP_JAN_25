package dpBitMaskingAssignment;

import java.util.Scanner;

public class PlayingWithBits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		while (q > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int i = b;
			int count = 0;
			while (i >= a) {
				count += fastCount(i);
				i--;
			}
			System.out.print(count);
			q--;
		}
		sc.close();
	}

	public static int fastCount(int n) {
		int ans = 0;
		while (n > 0) {
			n = n & (n - 1);
			ans++;
		}
		return ans;
	}
}