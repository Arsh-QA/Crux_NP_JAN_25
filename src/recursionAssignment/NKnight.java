package recursionAssignment;

import java.util.Scanner;

public class NKnight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		int tk = n;
		print(board, tk, n, n, 0, 0);
		System.out.println();
		System.out.println(count(board, tk, n, n, 0, 0));
		sc.close();
	}

	public static void print(int[][] board, int tk, int totalRow, int totalCol, int row, int col) {
		if (tk == 0) {
			display(board);
			return;
		}
		if (col == totalCol) {
			col = 0;
			row++;
		}
		if (row == totalRow) {
			return;
		}
		if (isItSafe(board, row, col)) {
			board[row][col] = 1;
			print(board, tk - 1, totalRow, totalCol, row, col + 1);
			board[row][col] = 0;
		}
		print(board, tk, totalRow, totalCol, row, col + 1);
	}

	public static int count(int[][] board, int tk, int totalRow, int totalCol, int row, int col) {
		if (tk == 0) {
			return 1;
		}
		if (col == totalCol) {
			col = 0;
			row++;
		}
		if (row == totalRow) {
			return 0;
		}
		int a = 0;
		if (isItSafe(board, row, col)) {
			board[row][col] = 1;
			a = count(board, tk - 1, totalRow, totalCol, row, col + 1);
			board[row][col] = 0;
		}
		int b = count(board, tk, totalRow, totalCol, row, col + 1);
		return a + b;
	}

	private static boolean isItSafe(int[][] board, int row, int col) {
		// 2 vertical and 1 left horizontal
		if ((row - 2 >= 0) && (col - 1 >= 0) && board[row - 2][col - 1] == 1) {
			return false;
		}
		// 1 vertical and 2 left horizontal
		if ((row - 1 >= 0) && (col - 2 >= 0) && board[row - 1][col - 2] == 1) {
			return false;
		}
		// 2 vertical and 1 right horizontal
		if ((row - 2 >= 0) && (col + 1 < board[0].length) && board[row - 2][col + 1] == 1) {
			return false;
		}
		// 1 vertical and 2 right horizontal
		if ((row - 1 >= 0) && (col + 2 < board[0].length) && board[row - 1][col + 2] == 1) {
			return false;
		}
		return true;
	}

	public static void display(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1)
					System.out.print("{" + i + "-" + j + "}" + " ");
			}
		}
	}
}