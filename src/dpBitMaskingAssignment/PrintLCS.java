package dpBitMaskingAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class PrintLCS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int[][] dp = new int[s1.length()][s2.length()];
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++) {
//				dp[i][j] = -1;
//			}
//		}
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
//		System.out.println(lcs(s1, s2, 0, 0, dp));
		System.out.println(lcs2(s1, s2, s1.length() - 1, s2.length() - 1, dp));
		System.out.println(lcsBU(s1, s2));
		System.out.println(lcsStringBU(s1, s2));
		sc.close();
	}

	public static int lcs(String s1, String s2, int i, int j, int[][] dp) {
		if (i == s1.length() || j == s2.length())
			return 0;
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int ans = 0;
		if (s1.charAt(i) == s2.charAt(j)) {
			ans = 1 + lcs(s1, s2, i + 1, j + 1, dp);// dp[i+1][j+1]
		} else {
			int a = lcs(s1, s2, i + 1, j, dp);// dp[i+1][j]
			int b = lcs(s1, s2, i, j + 1, dp);// dp[i][j+1]
			ans = Math.max(a, b);
		}
		return dp[i][j] = ans;
	}

	public static int lcs2(String s1, String s2, int i, int j, int[][] dp) {
		if (i < 0 || j < 0)
			return 0;
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int ans = 0;
		if (s1.charAt(i) == s2.charAt(j)) {
			ans = 1 + lcs2(s1, s2, i - 1, j - 1, dp);// dp[i-1][j-1]
		} else {
			int a = lcs2(s1, s2, i - 1, j, dp);// dp[i-1][j]
			int b = lcs2(s1, s2, i, j - 1, dp);// dp[i][j-1]
			ans = Math.max(a, b);
		}
		return dp[i][j] = ans;
	}

	public static int lcsBU(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int ans = 0;
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					ans = 1 + dp[i - 1][j - 1];
				} else {
					int a = dp[i - 1][j];
					int b = dp[i][j - 1];
					ans = Math.max(a, b);
				}
				dp[i][j] = ans;
			}
		}

		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static String lcsStringBU(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					int a = dp[i - 1][j];
					int b = dp[i][j - 1];
					dp[i][j] = Math.max(a, b);
				}
			}
		}

		// Backtrack to find the actual LCS

		StringBuilder lcs = new StringBuilder();

		int i = s1.length();
		int j = s2.length();

		while (i > 0 && j > 0) {

			// Characters are same -> this character is part of LCS
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				lcs.append(s1.charAt(i - 1));

				i--;
				j--;
			} else {

				// Move in the direction of larger value
				if (dp[i - 1][j] > dp[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}

		// We built the string backwards
		return lcs.reverse().toString();
	}
}