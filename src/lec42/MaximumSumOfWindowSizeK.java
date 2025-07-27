package lec42;

public class MaximumSumOfWindowSizeK {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 4, 5, 7, 2, 3 };
		int k = 3;
		System.out.println(maximumSumOfWindowSizeK(arr, k));
	}

	public static int maximumSumOfWindowSizeK(int[] arr, int k) {
		// 1st Window
		int ans = 0, sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		ans = sum;
		for (int i = k; i < arr.length; i++) {
			// Grow
			sum += arr[i];

			// Shrink
			sum -= arr[i - k];

			// ans Calculate
			ans = Math.max(ans, sum);
		}
		return ans;
	}
}