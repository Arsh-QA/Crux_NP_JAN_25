package dpAssignment;

import java.util.*;

public class ZeroNKnapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cap = sc.nextInt();

		int wt[] = new int[n];
		int val[] = new int[n];

		for (int i = 0; i < n; i++) {
			wt[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}

		// dp[c] = maximum value with capacity c

		int[] dp = new int[cap + 1];

		for (int c = 1; c <= cap; c++) {
			for (int i = 0; i < n; i++) {
				if (wt[i] <= c) {
					dp[c] = Math.max(dp[c], dp[c - wt[i]] + val[i]);
				}
			}
		}

		System.out.println(dp[cap]);

		sc.close();

	}
}