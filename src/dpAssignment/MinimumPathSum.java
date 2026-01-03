package dpAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPathSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		// { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int[][] dp = new int[grid.length][grid[0].length];
		for (int[] a : dp)
			Arrays.fill(a, -1);
		System.out.println(pathSum(grid, 0, 0, dp));
		sc.close();
	}

	public static int pathSum(int[][] grid, int cr, int cc, int[][] dp) {
		if (cr == grid.length - 1 && cc == grid[0].length - 1)
			return grid[cr][cc];
		if (cr >= grid.length || cc >= grid[0].length)
			return Integer.MAX_VALUE;
		if (dp[cr][cc] != -1)
			return dp[cr][cc];
		int down = pathSum(grid, cr + 1, cc, dp);
		int right = pathSum(grid, cr, cc + 1, dp);
		return dp[cr][cc] = Math.min(down, right) + grid[cr][cc];
	}
}