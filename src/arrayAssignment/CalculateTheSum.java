package arrayAssignment;

import java.util.Scanner;

public class CalculateTheSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int x = sc.nextInt();
			arr = calculateTheSum(arr, x);
		}
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		int ans = (int) sum % 1000_000_007;
		System.out.println(ans);
		sc.close();
	}

	public static int[] calculateTheSum(int[] arr, int x) {
		int[] arr1 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (i - x >= 0)
				arr1[i] = arr[i] + arr[i - x];
			else
				arr1[i] = arr[i] + arr[arr.length - x];
		}
		return arr1;
	}

}