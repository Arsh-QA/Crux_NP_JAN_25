package lec41;

import java.util.Arrays;

public class MinimumFallingPathSum2 {

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
		if (cr == matrix.length - 1)
			return matrix[cr][cc];
		if (dp[cr][cc] != -100000)
			return dp[cr][cc];
		int ans = Integer.MAX_VALUE;
		for (int col = 0; col < matrix[0].length; col++) {
			if (col == cc)
				continue;
			ans = Math.min(ans, minimumFallingPathSum(matrix, cr + 1, col, dp));
		}
		return dp[cr][cc] = ans + matrix[cr][cc];
	}
}