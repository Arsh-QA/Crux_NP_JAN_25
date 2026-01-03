package reviseRecursionDP;

import java.util.Arrays;

public class MinCostClimbingStairs2 {

	public static void main(String[] args) {
		int[] arr = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };

		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);

		int zero = minCost(arr, 0, dp);
		int one = minCost(arr, 1, dp);
		System.out.println(Math.min(zero, one));

		System.out.println(minCost(arr));
	}

	public static int minCost(int[] arr, int i, int[] dp) {
		if (i >= arr.length) {
			return 0;
		}

		if (dp[i] != -1)
			return dp[i];

		int first = minCost(arr, i + 1, dp);// dp[i+1];
		int sec = minCost(arr, i + 2, dp);// dp[i+2];
		return dp[i] = Math.min(first, sec) + arr[i];// dp[i] = Math.min(dp[i+1], dp[i+2]) + arr[i];
	}

	public static int minCost(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = arr[1];

		for (int i = 2; i < dp.length; i++) {
			int first = dp[i - 1];
			int sec = dp[i - 2];
			dp[i] = Math.min(first, sec) + arr[i];
		}

		return Math.min(dp[dp.length - 2], dp[dp.length - 1]);
	}
}