package dpAssignment;

import java.util.Scanner;

public class CountOfDifferentWaysToExpressN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		System.out.println(count(n));
		System.out.println(countBU(n));
		sc.close();
	}

	public static int countBU(int n) {
		// Base Cases
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;

		for (int i = 4; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
		}
		return dp[dp.length - 1];
	}

	public static int count(int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		int a1 = count(n - 1);
		int a2 = count(n - 3);
		int a3 = count(n - 4);

		return a1 + a2 + a3;
	}
}