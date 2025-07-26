package lec40;

import java.util.Arrays;

public class CoinChangeII {

	public static void main(String[] args) {
		int[] coin = { 1, 2, 5 };
		int amount = 5;
		System.out.println("Using Recursion");
		System.out.println(coinChange(coin, amount, 0));

		System.out.println("Using DP Top Down");
		int[][] dp = new int[coin.length][amount + 1];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		System.out.println(coinChangeTD(coin, amount, 0, dp));

		System.out.println("Using DP Bottom UP");
		System.out.println(coinChangeBU(coin, amount));
	}

	public static int coinChangeBU(int[] coin, int amount) {
		int[][] dp = new int[coin.length + 1][amount + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int am = 1; am <= amount; am++) {
				int inc = 0;
				int exc = 0;
				if (am >= coin[i - 1]) {
					inc = dp[i][am - coin[i - 1]];
				}
				exc = dp[i - 1][am];
				dp[i][am] = inc + exc;
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static int coinChangeTD(int[] coin, int amount, int i, int[][] dp) {
		if (amount == 0) {
			return 1;
		}
		if (i == coin.length) {
			return 0;
		}
		if (dp[i][amount] != -1) {
			return dp[i][amount];
		}
		int inc = 0;
		int exc = 0;
		if (amount >= coin[i]) {
			inc = coinChangeTD(coin, amount - coin[i], i, dp);
		}
		exc = coinChangeTD(coin, amount, i + 1, dp);
		return dp[i][amount] = inc + exc;
	}

	public static int coinChange(int[] coin, int amount, int i) {
		if (amount == 0) {
			return 1;
		}
		if (i == coin.length) {
			return 0;
		}
		int inc = 0;
		int exc = 0;
		if (amount >= coin[i]) {
			inc = coinChange(coin, amount - coin[i], i);
		}
		exc = coinChange(coin, amount, i + 1);
		return inc + exc;
	}
}