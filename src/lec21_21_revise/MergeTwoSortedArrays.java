package lec21_21_revise;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = { 2, 3, 4, 5, 7, 8, 11 };
		int[] arr2 = { 1, 2, 5, 6, 9, };
		int[] ans = merge(arr1, arr2);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

	public static int[] merge(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[] ans = new int[n + m];

		int i = 0, j = 0, k = 0;

		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				ans[k] = arr1[i];
				i++;
				k++;
			} else {
				ans[k] = arr2[j];
				j++;
				k++;
			}

		}
		while (i < n) {
			ans[k] = arr1[i];
			i++;
			k++;
		}
		while (j < m) {
			ans[k] = arr2[j];
			j++;
			k++;
		}
		return ans;
	}

}
