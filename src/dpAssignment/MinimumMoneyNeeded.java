package dpAssignment;

import java.util.*;

public class MinimumMoneyNeeded {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int W = sc.nextInt();

		int[] val = new int[W + 1];
		for (int i = 1; i <= W; i++) {
			val[i] = sc.nextInt();
		}

		int INF = (int) 1e9;
		int[] dp = new int[W + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;

		for (int w = 1; w <= W; w++) {
			for (int i = 1; i <= w; i++) {
				if (val[i] != -1) { // packet available
					dp[w] = Math.min(dp[w], val[i] + dp[w - i]);
				}
			}
		}

		System.out.println(dp[W] >= INF ? -1 : dp[W]);

		sc.close();
	}
}