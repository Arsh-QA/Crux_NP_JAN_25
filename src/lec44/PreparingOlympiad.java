package lec44;

import java.util.Scanner;

public class PreparingOlympiad {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		int x = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(preparing(c, l, r, x));
		sc.close();
	}

	public static int preparing(int[] c, int l, int r, int x) {
		int n = c.length;
		int count = 0;
		for (int i = 3; i < (1 << n); i++) {
			if (fastSetBit(i) >= 2 && pattern(i, c, l, r, x)) {
				count++;
			}
		}
		return count;
	}

	private static boolean pattern(int i, int[] c, int l, int r, int x) {
		int idx = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while (i > 0) {
			if ((i & 1) != 0) {
				sum = sum + c[idx];
				min = Math.min(min, c[idx]);
				max = Math.max(max, c[idx]);
			}
			idx++;
			i >>= 1;
		}
		return sum >= l && sum <= r && max - min >= x;
	}

	public static int fastSetBit(int n) {
		int c = 0;
		while (n > 0) {
			c++;
			n = (n & (n - 1));
		}
		return c;
	}
}