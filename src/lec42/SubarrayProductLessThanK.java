package lec42;

public class SubarrayProductLessThanK {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 2, 4, 3 };
		int k = 10;
		System.out.println(productLessThanK(arr, k));
	}

	public static int productLessThanK(int[] arr, int k) {
		int ei = 0, si = 0, ans = 0, p = 1;
		while (ei < arr.length) {
			// Grow
			p = p * arr[ei];

			// Shrink
			while (p >= k && si <= ei) {
				p = p / arr[si];
				si++;
			}

			// ans calculate
			ans = ans + (ei - si + 1);
			ei++;
		}
		return ans;
	}

}
