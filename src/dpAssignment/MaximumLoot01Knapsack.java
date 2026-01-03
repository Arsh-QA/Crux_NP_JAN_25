package dpAssignment;

import java.util.*;

public class MaximumLoot01Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int W = sc.nextInt();

		int[] val = new int[n];
		int[] wt = new int[n];

		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			wt[i] = sc.nextInt();
		}

		int[] dp = new int[W + 1];

		for (int i = 0; i < n; i++) {
			for (int w = W; w >= wt[i]; w--) {
				dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
			}
		}

		System.out.println(dp[W]);

		sc.close();

	}
}