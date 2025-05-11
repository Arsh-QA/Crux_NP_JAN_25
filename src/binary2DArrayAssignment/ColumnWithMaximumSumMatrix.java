package binary2DArrayAssignment;

import java.util.Scanner;

public class ColumnWithMaximumSumMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int ans = Integer.MIN_VALUE;
		int idx = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += arr[j][i];
			}
			if (sum > ans) {
				ans = sum;
				idx = i;
			}
		}

		System.out.print(idx + 1);
		System.out.print(" " + ans);
		sc.close();
	}
}