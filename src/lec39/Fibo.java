package lec39;

public class Fibo {

	public static void main(String[] args) {
		int n = 5;
		System.out.println("Using Recursion");
		System.out.println(fibo(n));
		int[] dp = new int[n + 1];
		System.out.println("Using DP Top Down");
		System.out.println(fiboTD(n, dp));
		System.out.println("Using DP Bottom UP");
		System.out.println(fiboBU(n));
	}

	public static int fiboBU(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static int fiboTD(int n, int[] dp) {
		if (n <= 1)
			return n;
		if (dp[n] != 0) {// dp apply kara hai
			return dp[n];
		}
		int f1 = fiboTD(n - 1, dp);
		int f2 = fiboTD(n - 2, dp);
		return dp[n] = f1 + f2;// dp me yaad kiya hai
	}

	public static int fibo(int n) {
		if (n <= 1)
			return n;
		int f1 = fibo(n - 1);
		int f2 = fibo(n - 2);
		return f1 + f2;
	}
}