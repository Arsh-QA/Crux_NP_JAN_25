package lec18;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {
		int[] coin = { 2, 3, 5 };
		int amount = 8;
		List<Integer> ll = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		coinPermutation(coin, amount, "", 0, ll, result);
		System.out.println(result);
	}

	public static void coinPermutation(int[] coin, int amount, String ans, int idx, List<Integer> ll,
			List<List<Integer>> result) {
		if (amount == 0) {
			result.add(new ArrayList<>(ll));
			return;
		}
		for (int i = idx; i < coin.length; i++) {
			if (amount >= coin[i]) {
				ll.add(coin[i]);
				coinPermutation(coin, amount - coin[i], ans + coin[i], i, ll, result);
				ll.remove(ll.size() - 1);
			}
		}
	}
}