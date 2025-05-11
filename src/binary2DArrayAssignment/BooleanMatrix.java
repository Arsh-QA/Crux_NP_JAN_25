package binary2DArrayAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooleanMatrix {

	public static void main(String args[]) {
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
		List<int[]> onePositions = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 1) {
					onePositions.add(new int[] { i, j });
				}
			}
		}

		for (int[] pos : onePositions) {
			int row = pos[0];
			int col = pos[1];

			for (int j = 0; j < m; j++) {
				matrix[row][j] = 1;
			}

			for (int j = 0; j < n; j++) {
				matrix[j][col] = 1;
			}
		}
	}
}