package lec41;

import java.util.Arrays;

public class MinimumFallingPathSum {

	public static void main(String[] args) {
		int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		int ans = Integer.MAX_VALUE;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int[] a : dp)
			Arrays.fill(a, -100000);
		for (int i = 0; i < matrix[0].length; i++)
			ans = Math.min(ans, minimumFallingPathSum(matrix, 0, i, dp));
		System.out.println(ans);
	}

	public static int minimumFallingPathSum(int[][] matrix, int cr, int cc, int[][] dp) {
		if (cc < 0 || cc >= matrix[0].length)
			return Integer.MAX_VALUE;
		if (cr == matrix.length - 1)
			return matrix[cr][cc];
		if (dp[cr][cc] != -100000)
			return dp[cr][cc];
		int ld = minimumFallingPathSum(matrix, cr + 1, cc - 1, dp);
		int rd = minimumFallingPathSum(matrix, cr + 1, cc + 1, dp);
		int d = minimumFallingPathSum(matrix, cr + 1, cc, dp);
		int ans = Math.min(rd, Math.min(ld, d)) + matrix[cr][cc];
		return dp[cr][cc] = ans;
	}
}