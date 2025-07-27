package lec41;

public class OptimalGameStrategyII {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 13, 4 };
		System.out.println(optimalGameStrategy(arr, 0, arr.length - 1));
	}

	public static int optimalGameStrategy(int[] arr, int i, int j) {
		if (i > j)
			return 0;
		int f = arr[i] + Math.min(optimalGameStrategy(arr, i + 2, j), optimalGameStrategy(arr, i + 1, j - 1));
		int l = arr[j] + Math.min(optimalGameStrategy(arr, i + 1, j - 1), optimalGameStrategy(arr, i, j - 2));

		return Math.max(f, l);
	}
}