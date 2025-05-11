package leetcodeQuestions1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetZeroes {

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
		setZeroes(arr);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	public static void setZeroes(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		List<int[]> zeroPositions = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					zeroPositions.add(new int[] { i, j });
				}
			}
		}

		for (int[] pos : zeroPositions) {
			int row = pos[0];
			int col = pos[1];

			for (int j = 0; j < m; j++) {
				matrix[row][j] = 0;
			}

			for (int j = 0; j < n; j++) {
				matrix[j][col] = 0;
			}
		}
	}
}