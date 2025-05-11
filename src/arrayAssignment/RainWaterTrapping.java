package arrayAssignment;

import java.util.Scanner;

public class RainWaterTrapping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(rainWaterTrapping(arr));
			t--;
		}
		sc.close();
	}

	public static int rainWaterTrapping(int[] arr) {
		int n = arr.length;
		int[] leftArray = new int[n];
		int[] rightArray = new int[n];
		int maxLeft = arr[0];
		for (int i = 0; i < n; i++) {
			maxLeft = Math.max(maxLeft, arr[i]);
			leftArray[i] = maxLeft;
		}
		int maxRight = arr[n - 1];
		for (int i = n - 1; i >= 0; i--) {
			maxRight = Math.max(maxRight, arr[i]);
			rightArray[i] = maxRight;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + (Math.min(leftArray[i], rightArray[i]) - arr[i]);
		}
		return sum;
	}
}