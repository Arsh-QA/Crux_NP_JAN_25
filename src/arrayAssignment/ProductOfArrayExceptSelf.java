package arrayAssignment;

import java.util.Scanner;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		product(arr);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}

	public static long[] product(long[] arr) {
		int n = arr.length;
		long[] leftArray = new long[n];
		long[] rightArray = new long[n];
		leftArray[0] = 1;
		for (int i = 1; i < n; i++) {
			leftArray[i] = arr[i - 1] * leftArray[i - 1];
		}
		rightArray[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			rightArray[i] = rightArray[i + 1] * arr[i + 1];
		}
		for (int i = 0; i < n; i++) {
			arr[i] = leftArray[i] * rightArray[i];
		}
		return arr;
	}
}