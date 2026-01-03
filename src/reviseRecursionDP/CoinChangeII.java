package reviseRecursionDP;

import java.util.Iterator;

public class CoinChangeII {

	public static void main(String[] args) {
		int[] coin = { 1, 2, 5 };
		int amount = 5;
		System.out.println(noOfWays(coin, amount, 0));
		System.out.println(noOfWaysBU(coin, amount));
	}

	public static int noOfWaysBU(int[] coin, int amount) {
		int dp[][] = new int[coin.length + 1][amount + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}

		for (int c = 1; c < dp.length; c++) {
			for (int am = 1; am < dp[0].length; am++) {
				int inc = 0;
				int exc = 0;
				if (am >= coin[c - 1]) {
					inc = dp[c][am - coin[c - 1]];
				}
				exc = dp[c - 1][am];
				dp[c][am] = inc + exc;
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static int noOfWays(int[] coin, int amount, int i) {
		if (amount == 0) {
			return 1;
		}

		if (i == coin.length) {
			return 0;
		}

		int inc = 0;
		int exc = 0;
		if (amount >= coin[i]) {
			inc = noOfWays(coin, amount - coin[i], i);
		}
		exc = noOfWays(coin, amount, i + 1);
		return inc + exc;
	}
}