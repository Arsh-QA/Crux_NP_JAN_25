package lec39;

import java.util.Arrays;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		int[] dp = new int[cost.length + 1];
		Arrays.fill(dp, -1);
		int f = climbingStairs(cost, 0, dp);
		int s = climbingStairs(cost, 1, dp);
		System.out.println(Math.min(f, s));
	}

	public static int climbingStairs(int[] cost, int i, int[] dp) {
		if (i >= cost.length) {
			return 0;
		}
		if (dp[i] != -1) {
			return dp[i];
		}
		int f = climbingStairs(cost, i + 1, dp);
		int s = climbingStairs(cost, i + 2, dp);
		return dp[i] = Math.min(f, s) + cost[i];
	}

}
