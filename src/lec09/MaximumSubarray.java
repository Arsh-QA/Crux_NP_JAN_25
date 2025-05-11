package lec09;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] arr = { 5, 4, -1, 7, 8 };
		System.out.println(subarraySum(arr));
	}

	public static int subarraySum(int[] arr) {
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				ans = Math.max(ans, sum);
			}
		}
		return ans;
	}
}