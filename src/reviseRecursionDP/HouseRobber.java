package reviseRecursionDP;

import java.util.Arrays;

public class HouseRobber {
	public static void main(String[] args) {
		int[] arr = { 2, 7, 9, 3, 1 };
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
//		System.out.println(robber(arr, 0));
//		System.out.println(robberTD2(arr, arr.length - 1, dp));
		System.out.println(robberBU(arr));
	}

	public static int robberBU(int[] arr) {
		if (arr.length == 1) {
			return arr[0];
		}
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

	public static int robber(int[] arr, int idx) {
		if (idx >= arr.length) {
			return 0;
		}
		int rob = arr[idx] + robber(arr, idx + 2);
		int dontRob = robber(arr, idx + 1);
		return Math.max(rob, dontRob);
	}

	public static int robberTD(int[] arr, int idx, int[] dp) {
		if (idx >= arr.length) {
			return 0;
		}
		if (dp[idx] != -1)
			return dp[idx];
		int rob = arr[idx] + robberTD(arr, idx + 2, dp);
		int dontRob = robberTD(arr, idx + 1, dp);
		return dp[idx] = Math.max(rob, dontRob);
	}

	public static int robberTD2(int[] arr, int idx, int[] dp) {
		if (idx < 0) {
			return 0;
		}
		if (dp[idx] != -1)
			return dp[idx];
		int rob = arr[idx] + robberTD2(arr, idx - 2, dp);
		int dontRob = robberTD2(arr, idx - 1, dp);
		return dp[idx] = Math.max(rob, dontRob);
	}
}
