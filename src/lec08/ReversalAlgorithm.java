package lec08;

public class ReversalAlgorithm {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate(arr, k);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void rotate(int[] arr, int k) {
		int n = arr.length;
		k = k % n;// 0 to (n-1)
		// Starting ke n-k elements
		Reverse(arr, 0, n - k - 1);

		// Last ke k elements
		Reverse(arr, n - k, n - 1);

		// All elements
		Reverse(arr, 0, n - 1);
	}

	public static void Reverse(int[] arr, int i, int j) {
		while (i < j) {
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
	}
}