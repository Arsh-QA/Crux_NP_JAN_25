package dpAssignment;

import java.util.*;

public class LengthOfLCS {

	public static int lcs(String A, String B) {
		int n = A.length();
		int m = B.length();

		int[][] dp = new int[n + 1][m + 1];

		// Bottom-up
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[n][m];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String A = sc.nextLine();
		String B = sc.nextLine();

		System.out.println(lcs(A, B));

		sc.close();
	}
}