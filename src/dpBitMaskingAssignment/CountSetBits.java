package dpBitMaskingAssignment;

import java.util.Scanner;

public class CountSetBits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			System.out.println(countSetBits(sc.nextInt()));
			t--;
		}
		sc.close();
	}

	public static int countSetBits(int n) {
		int ans = 0;
		while (n > 0) {
			n = n & (n - 1);
			ans++;
		}
		return ans;
	}
}