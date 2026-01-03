package dpAssignment;

import java.util.*;

public class CoinChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int amount = sc.nextInt();
		int[] coin = new int[n];
		for (int i = 0; i < coin.length; i++) {
			coin[i] = sc.nextInt();
		}
//		System.out.println(coinChange(coin, amount, 0));

//		int[][] dp = new int[coin.length][amount + 1];
//		for (int[] a : dp) {
//			Arrays.fill(a, -1);
//		}
//		System.out.println(coinChangeTD(coin, amount, 0, dp));
		System.out.println(coinChangeBU(coin, amount));
		sc.close();
	}

	public static long coinChangeBU(int[] coin, int amount) {
		final int MOD = 1_000_000_007;
		long[][] dp = new long[coin.length + 1][amount + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int am = 1; am <= amount; am++) {
				long inc = 0;
				long exc = 0;
				if (am >= coin[i - 1]) {
					inc = (dp[i][am - coin[i - 1]]) % MOD;
				}
				exc = dp[i - 1][am];
				dp[i][am] = inc + exc;
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static int coinChangeTD(int[] coin, int amount, int i, int[][] dp) {
		if (amount == 0)
			return 1;
		if (i == coin.length)
			return 0;
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