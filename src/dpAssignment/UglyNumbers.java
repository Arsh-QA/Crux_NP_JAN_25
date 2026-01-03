package dpAssignment;

import java.util.*;

public class UglyNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		// Precompute till max n (10000)
		int MAX = 10000;
		long[] dp = new long[MAX + 1];

		dp[1] = 1;
		int p2 = 1, p3 = 1, p5 = 1;

		for (int i = 2; i <= MAX; i++) {
			long n2 = dp[p2] * 2;
			long n3 = dp[p3] * 3;
			long n5 = dp[p5] * 5;

			long next = Math.min(n2, Math.min(n3, n5));
			dp[i] = next;

			if (next == n2)
				p2++;
			if (next == n3)
				p3++;
			if (next == n5)
				p5++;
		}

		// Answer test cases
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
		sc.close();
	}
}