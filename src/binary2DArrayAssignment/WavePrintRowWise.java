package binary2DArrayAssignment;

import java.util.Scanner;

public class WavePrintRowWise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();// row
		int n = sc.nextInt();// column
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		wavePrint(arr);
		sc.close();
	}

	public static void wavePrint(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			if (row % 2 == 0) {
				for (int col = 0; col < arr[0].length; col++) {
					System.out.print(arr[row][col] + ", ");
				}
			} else {
				for (int col = arr[0].length - 1; col >= 0; col--) {
					System.out.print(arr[row][col] + ", ");
				}
			}
		}
		System.out.print("END");
	}
}