package recursionAssignment;

import java.util.Scanner;

public class SplitArrayRecursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		recursionArray(arr, 0, n - 1);
		sc.close();
	}

	public static void recursionArray(int[] arr, int si, int ei) {

	}

	public static void display(int[] arr, int i) {
		for (int idx = 0; idx < arr.length; idx++) {
			if (idx == i)
				System.out.print(arr[idx] + " and ");
			else
				System.out.print(arr[idx] + " ");
		}
	}

	public static int divide(int[] arr, int begIdx, int endIdx, int idx) {
		int sumLeft = 0;
		for (int i = begIdx; i <= idx; i++) {
			sumLeft += arr[i];
		}

		int sumRight = 0;
		for (int i = idx + 1; i <= endIdx; i++) {
			sumRight += arr[i];
		}

		if (sumLeft == sumRight)
			return idx;
		return -1;
	}

}