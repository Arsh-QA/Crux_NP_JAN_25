package dpAssignment;

import java.util.Scanner;

public class SmartRobber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(smartRobber(arr));
		}
		sc.close();
	}

	public static int smartRobber(int[] arr) {
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
}