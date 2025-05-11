package binary2DArrayAssignment;

import java.util.Scanner;

public class RotateImage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		rotateImage(arr);
		sc.close();
	}

	public static void rotateImage(int[][] arr) {
		for (int col = arr[0].length - 1; col >= 0; col--) {
			for (int row = 0; row < arr.length; row++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}
}