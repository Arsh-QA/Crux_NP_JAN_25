package dpBitMaskingAssignment;

import java.util.*;
import java.math.BigInteger;

public class TillingProblemI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		BigInteger[] dp = new BigInteger[n + 1];

		System.out.println(countWays(n));
		System.out.println(countWays(n, dp));
		System.out.println(countWaysBU(n));
		sc.close();
	}

	private static BigInteger countWaysBU(int n) {

		if (n == 0) {
			return BigInteger.ONE;
		}

		BigInteger[] dp = new BigInteger[n + 1];

		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}

		return dp[n];
	}

	private static BigInteger countWays(int n, BigInteger[] dp) {

		// Successfully filled the board
		if (n == 0) {
			return BigInteger.ONE;
		}

		// Invalid state
		if (n < 0) {
			return BigInteger.ZERO;
		}

		// Already calculated
		if (dp[n] != null) {
			return dp[n];
		}

		BigInteger vertical = countWays(n - 1, dp);
		BigInteger horizontal = countWays(n - 2, dp);

		return dp[n] = vertical.add(horizontal);

	}

	private static BigInteger countWays(int n) {

		// Successfully filled the board
		if (n == 0) {
			return BigInteger.ONE;
		}

		// Invalid State
		if (n < 0) {
			return BigInteger.ZERO;
		}

		// Place 1 vertical tile
		BigInteger vertical = countWays(n - 1);

		// Place 2 horizontal tiles
		BigInteger horizontal = countWays(n - 2);

		return vertical.add(horizontal);
	}
}