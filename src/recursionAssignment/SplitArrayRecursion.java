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
//		splitArray(arr, 0);
		recursionArray(arr, 0, 0);
		sc.close();
	}

	public static void recursionArray(int[] arr, int idx, int sum) {
		System.out.println("Entered Recursion function");
		if (idx == arr.length)
			return;
		sum += arr[idx];
		if (sum == sumOfRest(arr, idx + 1)) {
			for (int j = 0; j < arr.length; j++) {
				if (j == idx)
					System.out.print(arr[j] + " and ");
				else
					System.out.print(arr[j] + " ");
			}
		}
		recursionArray(arr, idx + 1, sum);
		sum -= arr[idx];
	}

	public static void splitArray(int[] arr, int idx) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == sumOfRest(arr, i)) {
				for (int j = 0; j < arr.length; j++) {
					if (j == i)
						System.out.print(arr[j] + " and ");
					else
						System.out.print(arr[j] + " ");
				}
			}
		}
	}

	public static int sumOfRest(int[] arr, int i) {
		int sum = 0;
		for (int j = i; j < arr.length; j++) {
			sum += arr[j];
		}
		return sum;
	}
}