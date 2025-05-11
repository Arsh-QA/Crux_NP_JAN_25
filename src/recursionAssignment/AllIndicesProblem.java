package recursionAssignment;

import java.util.Scanner;

public class AllIndicesProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		displayAllIndices(arr, m, 0, "");
		sc.close();
	}

	public static void displayAllIndices(int[] arr, int item, int idx, String ans) {
		if (idx == arr.length) {
			System.out.println(ans);
			return;
		}
		if (arr[idx] == item) {
			displayAllIndices(arr, item, idx + 1, ans + idx + " ");
		} else
			displayAllIndices(arr, item, idx + 1, ans);
	}
}