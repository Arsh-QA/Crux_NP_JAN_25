package binary2DArrayAssignment;

import java.util.Scanner;

public class MummysMotivationalSpeech {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// square matrix
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		if (checkLowerTriange(arr)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		sc.close();
	}

	public static boolean checkLowerTriange(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (j > i && arr[i][j] != 0)
					return false;
			}
		}
		return true;
	}
}