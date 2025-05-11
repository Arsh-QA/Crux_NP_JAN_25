package arrayAssignment;

import java.util.Scanner;

public class MaximumCircularSum {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(printMaximumSum(arr));
			t--;
		}
		sc.close();
	}

	public static int printMaximumSum(int[] arr) {
		// Normal Kadance
		int ans = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			ans = Math.max(ans, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		boolean neg = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				neg = false;
				break;
			}
		}
		if (neg == true) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > max)
					max = arr[i];
			}
			return max;
		} else {
			// Negative Kadance
			int totalSum = 0;
			for (int i = 0; i < arr.length; i++) {
				totalSum += arr[i];
			}
			for (int i = 0; i < arr.length; i++) {
				arr[i] *= -1;
			}
			int ans1 = Integer.MIN_VALUE;
			int sum1 = 0;
			for (int i = 0; i < arr.length; i++) {
				sum1 += arr[i];
				ans1 = Math.max(sum1, ans1);
				if (sum1 < 0)
					sum1 = 0;
			}
			int negK = totalSum + ans1;
			return Math.max(ans, negK);
		}
	}
}