package lec40;

import java.util.Arrays;

public class LowestCommonSubsequence {

	public static void main(String[] args) {
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println("Using Recursion");
		System.out.println(LCS(text1, text2, 0, 0));
		System.out.println("Using DP Top Down");
		int[][] dp = new int[text1.length()][text2.length()];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		System.out.println(LCSTD(text1, text2, 0, 0, dp));
		System.out.println("Using DP Bottom UP");
		System.out.println(LCSBU(text1, text2));
	}

	public static int LCSBU(String text1, String text2) {
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					int f = dp[i - 1][j];
					int s = dp[i][j - 1];
					dp[i][j] = Math.max(f, s);
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static int LCSTD(String text1, String text2, int i, int j, int[][] dp) {
		if (i == text1.length() || j == text2.length()) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int ans = 0;
		if (text1.charAt(i) == text2.charAt(j)) {
			ans = 1 + LCSTD(text1, text2, i + 1, j + 1, dp);
		} else {
			int f = LCSTD(text1, text2, i + 1, j, dp);
			int s = LCSTD(text1, text2, i, j + 1, dp);
			ans = Math.max(f, s);
		}
		return dp[i][j] = ans;
	}

	public static int LCS(String text1, String text2, int i, int j) {
		if (i == text1.length() || j == text2.length()) {
			return 0;
		}
		int ans = 0;
		if (text1.charAt(i) == text2.charAt(j)) {
			ans = 1 + LCS(text1, text2, i + 1, j + 1);
		} else {
			int f = LCS(text1, text2, i + 1, j);
			int s = LCS(text1, text2, i, j + 1);
			ans = Math.max(f, s);
		}
		return ans;
	}
}