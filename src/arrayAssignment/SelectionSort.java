package arrayAssignment;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sort(arr);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minimumIdx = minimumIndex(arr, i);
			int temp = arr[i];
			arr[i] = arr[minimumIdx];
			arr[minimumIdx] = temp;
		}
	}

	public static int minimumIndex(int[] arr, int idx) {
		int mini = idx;
		for (int i = idx + 1; i < arr.length; i++) {
			if (arr[i] < arr[mini]) {
				mini = i;
			}
		}
		return mini;
	}
}