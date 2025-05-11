package binary2DArrayAssignment;

import java.util.Scanner;

public class PiyushAndMagicalPark {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// rows
		int m = sc.nextInt();// columns
		int k = sc.nextInt();// minimum strength required
		int s = sc.nextInt();// current strength
		char[][] arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.next().charAt(0);
			}
		}
		int sLeft = escapeOrNot(arr, k, s);// strength left
		if (sLeft > k) {
			System.out.println("Yes");
			System.out.println(sLeft);
		} else
			System.out.println("No");
		sc.close();
	}

	public static int escapeOrNot(char[][] arr, int k, int s) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] == '.')
					s -= 2;
				if (arr[row][col] == '*')
					s += 5;
				if (arr[row][col] == '#')
					break;
				if (col < arr[0].length - 1)
					s -= 1;
			}
			if (s < k)
				break;
		}
		return s;
	}
}