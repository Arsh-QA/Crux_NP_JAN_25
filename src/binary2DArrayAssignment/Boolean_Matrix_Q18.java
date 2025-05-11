package binary2DArrayAssignment;

import java.util.*;

public class Boolean_Matrix_Q18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// Making boolean
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					// make all ith row elements as 1
					for (int k = 0; k < n; k++) {
						arr[i][k] = 1;
					}
					// make all jth column elements as 1
					for (int k = 0; k < m; k++) {
						arr[k][j] = 1;
					}
				}
			}
		}
		// print new matrix
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}