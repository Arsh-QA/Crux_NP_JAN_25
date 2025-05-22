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
		splitArray(arr, 0, "", 0, "", 0);
		System.out.println(countSplits(arr, 0, "", 0, "", 0));
		sc.close();
	}

	public static void splitArray(int[] arr, int i, String ans, int sum, String ans1, int sum1) {
		if (i == arr.length) {
			if (sum == sum1) {
				System.out.println(ans + "and " + ans1);
			}
			return;
		}
		splitArray(arr, i + 1, ans + arr[i] + " ", sum + arr[i], ans1 + "", sum1);
		splitArray(arr, i + 1, ans + "", sum, ans1 + arr[i] + " ", sum1 + arr[i]);
	}

	public static int countSplits(int[] arr, int i, String ans, int sum, String ans1, int sum1) {
		if (i == arr.length) {
			if (sum == sum1) {
				return 1;
			}
			return 0;
		}
		int c1 = countSplits(arr, i + 1, ans + arr[i] + " ", sum + arr[i], ans1 + "", sum1);
		int c2 = countSplits(arr, i + 1, ans + "", sum, ans1 + arr[i] + " ", sum1 + arr[i]);
		return c1 + c2;
	}
}