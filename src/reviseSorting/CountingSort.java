package reviseSorting;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		int arr[] = { 2, 1, 1, 0, 1, 2, 5, 4, 0, 2, 8, 7, 9, 2, 6, 1, 9 };
		int ansArr[] = sort(arr);
		System.out.println(Arrays.toString(ansArr));
	}

	public static int[] sort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		int[] freq = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			freq[arr[i]]++;
		}
		for (int i = 1; i < freq.length; i++) {
			freq[i] = freq[i] + freq[i - 1];
		}
		int[] newArr = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int idx = freq[arr[i]] - 1;
			newArr[idx] = arr[i];
			freq[arr[i]]--;
		}
		return newArr;
	}
}