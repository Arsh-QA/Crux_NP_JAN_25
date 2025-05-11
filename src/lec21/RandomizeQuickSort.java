package lec21;

import java.util.Random;

public class RandomizeQuickSort {

	public static void main(String[] args) {
		int[] arr = { 5, 7, 2, 1, 8, 3, 4 };
		sort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void sort(int[] arr, int si, int ei) {
		if (si >= ei) {
			return;
		}
		int idx = partition(arr, si, ei);
		sort(arr, si, idx - 1);
		sort(arr, idx + 1, ei);
	}

	public static int partition(int[] arr, int si, int ei) {
		// si to ei-1 me se ek random index lena hai --> uss index value ei placed
		// karenge, then baaki
		// logic same hoga
		Random rn = new Random();
		int index = rn.nextInt(ei - si) + si;
		int tt = arr[ei];
		arr[ei] = arr[index];
		arr[index] = tt;
		int item = arr[ei];
		int idx = si;
		for (int i = si; i < ei; i++) {
			if (arr[i] < item) {
				int t = arr[i];
				arr[i] = arr[idx];
				arr[idx] = t;
				idx++;
			}
		}
		int t = arr[ei];
		arr[ei] = arr[idx];
		arr[idx] = t;
		return idx;
	}

}