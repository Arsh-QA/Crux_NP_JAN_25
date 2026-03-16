package interviewQuestions;

import java.util.Scanner;

public class SubsetRecursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
//		printSubset(arr, 0, "", 0, target);
		System.out.println("\n" + printSubset(arr, 0, "", 0, target));
		sc.close();
	}

	public static int printSubset(int[] arr, int i, String ans, int sum, int target) {
		if (i == arr.length) {
			if (sum == target) {
				System.out.print(ans);
				return 1;
			}
			return 0;
		}
		int fs = printSubset(arr, i + 1, ans + arr[i] + " ", sum + arr[i], target);// element added
		int ss = printSubset(arr, i + 1, ans, sum, target);// no element added
		return fs + ss;
	}
}