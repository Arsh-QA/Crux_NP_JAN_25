package dpAssignment;

public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(climb(n, ""));
		System.out.println(climbStairs(n));
	}

	public static int climbStairs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[dp.length - 1];
	}

	public static int climb(int n, String ans) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		int a1 = climb(n - 1, ans + 1);
		int a2 = climb(n - 2, ans + 2);
		return a1 + a2;
	}
}