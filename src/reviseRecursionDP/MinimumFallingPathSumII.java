package reviseRecursionDP;

import java.util.Arrays;

public class MinimumFallingPathSumII {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int ans = Integer.MAX_VALUE;
		int[][] dp = new int[arr.length][arr[0].length];
		for (int[] a : dp) {
			Arrays.fill(a, Integer.MIN_VALUE);
		}
		for (int i = 0; i < arr.length; i++) {
			ans = Math.min(ans, minPathSum(arr, 0, i, dp));
		}
		System.out.println(ans);
	}

	private static int minPathSum(int[][] arr, int i, int j, int[][] dp) {
		if (i == arr.length - 1) {
			return arr[i][j];
		}
		if (dp[i][j] != Integer.MIN_VALUE) {
			return dp[i][j];
		}
		int ans = Integer.MAX_VALUE;
		for (int k = 0; k < dp[0].length; k++) {
			if (j != k) {
				ans = Math.min(ans, minPathSum(arr, i + 1, k, dp));
			}
		}
		return dp[i][j] = ans + arr[i][j];
	}
}