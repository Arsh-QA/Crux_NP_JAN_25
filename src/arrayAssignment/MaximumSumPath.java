package arrayAssignment;

import java.util.Scanner;

public class MaximumSumPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];
			for (int i = 0; i < n; i++) {
				arr1[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				arr2[i] = sc.nextInt();
			}
			System.out.println(maximumSum(arr1, arr2));
			t--;
		}
		sc.close();
	}

	public static int maximumSum(int[] arr1, int[] arr2) {
		int i = 0, s1 = 0;
		int j = 0, s2 = 0;
		int sum1 = 0;
		int sum2 = 0;
		int ans = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr1[i] > arr2[j]) {
				j++;
			} else {
				sum1 = sum(arr1, s1, i);
				sum2 = sum(arr2, s2, j);
				ans += Math.max(sum1, sum2);
				s1 = i + 1;
				s2 = j + 1;
				i++;
				j++;
			}
		}
		sum1 = sum(arr1, s1, arr1.length - 1);
		sum2 = sum(arr2, s2, arr2.length - 1);
		ans += Math.max(sum1, sum2);
		return ans;
	}

	public static int sum(int[] arr, int s1, int i) {
		int sum = 0;
		for (int k = s1; k <= i; k++) {
			sum += arr[k];
		}
		return sum;
	}
}