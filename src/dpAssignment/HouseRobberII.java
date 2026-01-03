package dpAssignment;

import java.util.Scanner;

public class HouseRobberII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(smartRobberII(arr));
		sc.close();
	}

	public static int smartRobberII(int[] arr) {
		int n = arr.length;
		if (n == 1)
			return arr[0];
		if (n == 2)
			return Math.max(arr[0], arr[1]);

		// Case 1 : Exclude last house
		int case1 = smartRobber(arr, 0, n - 2);

		// Case 2 : Exclude first house
		int case2 = smartRobber(arr, 1, n - 1);

		return Math.max(case1, case2);
	}

	public static int smartRobber(int[] arr, int start, int end) {
		int len = end - start + 1;
		int[] dp = new int[len];
		dp[0] = arr[start];
		if (len > 1) {
			dp[1] = Math.max(arr[start], arr[start + 1]);
		}
		for (int i = 2; i < len; i++) {
			int rob = arr[start + i] + dp[i - 2];
			int dontRob = dp[i - 1];
			dp[i] = Math.max(rob, dontRob);
		}
		return dp[len - 1];
	}
}