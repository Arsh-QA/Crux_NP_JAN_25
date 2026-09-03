package dpBitMaskingAssignment;

import java.util.Scanner;

public class MinimumTrialsNeededPlateDropping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int k = sc.nextInt(); // plates
			int n = sc.nextInt(); // floors

			int[][] dp = new int[k + 1][n + 1];

			// If there is only 1 plate, we must try floors one by one
			for (int floors = 1; floors <= n; floors++) {
				dp[1][floors] = floors;
			}

			// If there are 0 or 1 floors
			for (int plates = 1; plates <= k; plates++) {
				dp[plates][0] = 0;
				dp[plates][1] = 1;
			}

			for (int plates = 2; plates <= k; plates++) {
				for (int floors = 2; floors <= n; floors++) {
					dp[plates][floors] = Integer.MAX_VALUE;
					for (int x = 1; x <= floors; x++) {
						int breaks = dp[plates - 1][x - 1];
						int doesNotBreak = dp[plates][floors - x];

						int worstCase = 1 + Math.max(breaks, doesNotBreak);

						dp[plates][floors] = Math.min(dp[plates][floors], worstCase);
					}
				}
			}
			System.out.println(dp[k][n]);
		}
		sc.close();
	}
}