package binary2DArrayAssignment;

import java.util.Scanner;

public class BooleanMatrixChatGPT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		setOnes(arr);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	public static void setOnes(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		boolean[] row = new boolean[n];
		boolean[] col = new boolean[m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 1) {
					row[i] = true;
					col[j] = true;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (row[i] || col[j]) {
					matrix[i][j] = 1;
				}
			}
		}
	}
}