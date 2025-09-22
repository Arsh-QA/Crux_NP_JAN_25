package lec40;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {
		String s = "FOOD";
		String t = "MONEY";
		System.out.println("Using DP Top Down");
		int[][] dp = new int[s.length()][t.length()];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		System.out.println(minOps(s, t, 0, 0, dp));
	}

	// Using Norman Recursion
	// i --> s
	// j --> t
	public static int editDistance(String s, String t, int i, int j) {
		if (i == s.length()) {
			return t.length() - j;
		}
		if (j == t.length()) {
			return s.length() - i;
		}
		int ans = 0;
		if (s.charAt(i) == t.charAt(j)) {
			ans = editDistance(s, t, i + 1, j + 1);// dp[i-1][j-1]
		} else {
			int D = editDistance(s, t, i + 1, j);// dp[i-1][j]
			int I = editDistance(s, t, i, j + 1);// dp[i][j-1]
			int R = editDistance(s, t, i + 1, j + 1);// dp[i-1][j-1]
			ans = 1 + Math.min(I, Math.min(D, R));
		}
		return ans;
	}

	public static int minOps(String s, String t, int i, int j, int[][] dp) {
		if (i == s.length())
			return t.length() - j;
		if (j == t.length())
			return s.length() - i;
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int ans = 0;
		if (s.charAt(i) == t.charAt(j)) {
			ans = minOps(s, t, i + 1, j + 1, dp);
		} else {
			int D = minOps(s, t, i + 1, j, dp);
			int R = minOps(s, t, i + 1, j + 1, dp);
			int I = minOps(s, t, i, j + 1, dp);
			ans = 1 + Math.min(R, Math.min(D, I));
		}
		return dp[i][j] = ans;
	}
}