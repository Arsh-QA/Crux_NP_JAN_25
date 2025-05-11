package lec21;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 7, 2, 5, 4, 1 };
		int[] result = sort(arr, 0, arr.length - 1);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static int[] sort(int[] arr, int si, int ei) {
		if (si == ei) {
			int[] bs = new int[1];
			bs[0] = arr[si];
			return bs;
		}
		int mid = (si + ei) / 2;
		int[] f = sort(arr, si, mid);
		int[] s = sort(arr, mid + 1, ei);
		return merge(f, s);
	}

	public static int[] merge(int[] arr1, int[] arr2) {
		int n = arr1.length, m = arr2.length;
		int i = 0, j = 0, k = 0;
		int[] ans = new int[n + m];
		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				ans[k] = arr1[i];
				k++;
				i++;
			} else {
				ans[k] = arr2[j];
				k++;
				j++;
			}
		}
		while (i < n) {
			ans[k] = arr1[i];
			k++;
			i++;
		}
		while (j < m) {
			ans[k] = arr2[j];
			k++;
			j++;
		}
		return ans;
	}
}