package lec18;

public class CoinCombination2 {

	public static void main(String[] args) {
		int[] coin = { 2, 3, 5 };
		int amount = 8;
		coinPermutation(coin, amount, "", 0);
	}

	public static void coinPermutation(int[] coin, int amount, String ans, int idx) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = idx; i < coin.length; i++) {
			if (amount >= coin[i]) {
				coinPermutation(coin, amount - coin[i], ans + coin[i], i);
			}
		}
	}
}