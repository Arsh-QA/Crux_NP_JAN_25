package lec40;

import java.util.Arrays;

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println("Using DP Top Down");
		int[][] dp = new int[s.length()][t.length()];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		System.out.println(coinChange(s, t, 0, 0, dp));
	}

	// s --> coin --> i | t --> amount --> j
	public static int coinChange(String s, String t, int i, int j, int[][] dp) {
		if (j == t.length())
			return 1;

		if (i == s.length())
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int inc = 0;
		int exc = 0;
		if (s.charAt(i) == t.charAt(j)) {
			inc = coinChange(s, t, i + 1, j + 1, dp);
		}
		exc = coinChange(s, t, i + 1, j, dp);
		return dp[i][j] = inc + exc;
	}

}
