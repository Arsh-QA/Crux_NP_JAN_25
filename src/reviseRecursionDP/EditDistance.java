package reviseRecursionDP;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {
		String s = "FOOD";
		String t = "MONEY";
		System.out.println(editDistance(s, t, 0, 0));

		int[][] dp = new int[s.length()][t.length()];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}

		System.out.println(editDistanceTD(s, t, 0, 0, dp));

		System.out.println(editDistanceBU(s, t));

	}

	public static int editDistanceBU(String s, String t) {
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int ans = 0;
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					ans = dp[i - 1][j - 1];
				} else {
					int D = dp[i - 1][j];
					int I = dp[i][j - 1];
					int R = dp[i - 1][j - 1];
					ans = Math.min(I, Math.min(D, R)) + 1;
				}
				dp[i][j] = ans;
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static int editDistanceTD(String s, String t, int i, int j, int[][] dp) {
		if (i == s.length() - 1)
			return t.length() - j;
		if (j == t.length() - 1)
			return s.length() - i;
		if (dp[i][j] != -1)
			return dp[i][j];
		int ans = 0;
		if (s.charAt(i) == t.charAt(j)) {
			ans = editDistanceTD(s, t, i + 1, j + 1, dp);// dp[i+1][j+1]
		} else {
			int D = editDistanceTD(s, t, i + 1, j, dp);// dp[i+1][j]
			int I = editDistanceTD(s, t, i, j + 1, dp);// dp[i][j+1]
			int R = editDistanceTD(s, t, i + 1, j + 1, dp);// dp[i+1][j+1]
			ans = Math.min(I, Math.min(D, R)) + 1;
		}
		return dp[i][j] = ans;
	}

	// i --> s, j --> t
	public static int editDistance(String s, String t, int i, int j) {
		if (i == s.length() - 1)
			return t.length() - j;
		if (j == t.length() - 1)
			return s.length() - i;
		int ans = 0;
		if (s.charAt(i) == t.charAt(j)) {
			ans = editDistance(s, t, i + 1, j + 1);
		} else {
			int D = editDistance(s, t, i + 1, j);
			int I = editDistance(s, t, i, j + 1);
			int R = editDistance(s, t, i + 1, j + 1);
			ans = Math.min(I, Math.min(D, R)) + 1;
		}
		return ans;
	}
}