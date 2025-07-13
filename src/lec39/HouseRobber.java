package lec39;

import java.util.Arrays;

public class HouseRobber {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 9, 3, 1 };
		System.out.println("Using Recursion");
		System.out.println(robber(arr, 0));
		int[] dp = new int[arr.length + 1];
//		for (int i = 0; i < dp.length; i++)
//			dp[i] = -1;

		// OR
		Arrays.fill(dp, -1);
		System.out.println("Using DP Top Down");
		System.out.println(robberTD1(arr, 0, dp));
		int[] dp1 = new int[arr.length + 1];
		Arrays.fill(dp1, -1);
		System.out.println("Using DP Top Down - from Last");
		System.out.println(robberTD2(arr, arr.length - 1, dp1));
		System.out.println("Using DP Bottom Up");
		System.out.println(robberBU(arr));

	}

	public static int robberBU(int[] arr) {
		if (arr.length == 1)
			return arr[0];
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < dp.length; i++) {
			int rob = arr[i] + dp[i - 2];
			int dontRob = dp[i - 1];
			dp[i] = Math.max(rob, dontRob);
		}
		return dp[dp.length - 1];
	}

	public static int robberTD2(int[] arr, int i, int[] dp) {
		if (i < 0)
			return 0;
		if (dp[i] != -1)
			return dp[i];
		int rob = arr[i] + robberTD2(arr, i - 2, dp);
		int dontRob = robberTD2(arr, i - 1, dp);
		return dp[i] = Math.max(rob, dontRob);
	}

	public static int robberTD1(int[] arr, int i, int[] dp) {
		if (i >= arr.length)
			return 0;
		if (dp[i] != -1)
			return dp[i];
		int rob = arr[i] + robberTD1(arr, i + 2, dp);
		int dontRob = robberTD1(arr, i + 1, dp);
		return dp[i] = Math.max(rob, dontRob);
	}

	public static int robber(int[] arr, int i) {
		if (i >= arr.length)
			return 0;
		int rob = arr[i] + robber(arr, i + 2);
		int dontRob = robber(arr, i + 1);
		return Math.max(rob, dontRob);
	}
}