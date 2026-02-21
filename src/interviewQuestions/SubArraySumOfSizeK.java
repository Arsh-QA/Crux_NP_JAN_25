package interviewQuestions;

public class SubArraySumOfSizeK {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 4, 5, 6, 7, 8, 9, 2, 3 };
		int k = 3;
		System.out.println(maxSumOfSizeK(arr, k));
	}

	public static int maxSumOfSizeK(int[] arr, int k) {
		// 1st window ka kaam

		int sum = 0;
		int ans = 0;

		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		ans = sum;

		for (int i = k; i < arr.length; i++) {
			sum += arr[i];// grow
			sum -= arr[i - k];// shrink
			ans = Math.max(ans, sum);
		}

		return ans;
	}
}