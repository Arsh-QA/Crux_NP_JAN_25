package reviseRecursionDP;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		int[] arr = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
//		int zeroth = climbingStairs(arr, 0);
//		int first = climbingStairs(arr, 1);
//		System.out.println(Math.min(zeroth, first));
		System.out.println(climbingStairsBU(arr));
	}

	public static int climbingStairsBU(int[] arr) {
		int n = arr.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return arr[0];
		int[] dp = new int[n];
		dp[0] = arr[0];
		dp[1] = Math.min(arr[0], arr[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.min(dp[i - 1], dp[i - 2]) + arr[i];
		}
		return Math.min(dp[n - 1], dp[n - 2]);
	}

	public static int climbingStairs(int[] arr, int i) {
		if (i >= arr.length)
			return 0;
		int f = climbingStairs(arr, i + 1);
		int s = climbingStairs(arr, i + 2);
		return Math.min(f, s) + arr[i];
	}
}