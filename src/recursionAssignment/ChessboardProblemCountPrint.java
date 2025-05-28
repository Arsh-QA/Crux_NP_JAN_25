package recursionAssignment;

import java.util.Scanner;

public class ChessboardProblemCountPrint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		printPath(board, 0, 0, "{0-0}");
		System.out.println();
		System.out.println(countPath(board, 0, 0));
		sc.close();
	}

	public static void printPath(int[][] board, int cr, int cc, String path) {
		if (cr == board.length - 1 && cc == board[0].length - 1) {
			System.out.print(path + " ");
			return;
		}

		if (cr >= board.length || cc >= board[0].length) {
			return;
		}

		printPath(board, cr + 2, cc + 1, path + "K" + "{" + (cr + 2) + "-" + (cc + 1) + "}");
		printPath(board, cr + 1, cc + 2, path + "K" + "{" + (cr + 1) + "-" + (cc + 2) + "}");
		if (cc == 0 || cc == board[0].length - 1 || cr == 0 || cr == board.length - 1) {
			for (int i = 1; i < board[0].length; i++) {
				printPath(board, cr, cc + i, path + "R" + "{" + (cr) + "-" + (cc + i) + "}");
				printPath(board, cr + i, cc, path + "R" + "{" + (cr + i) + "-" + cc + "}");
			}
		}
		if (cr == cc || cr + cc == board.length - 1) {
			for (int i = 1; i < board.length; i++) {
				printPath(board, cr + i, cc + i, path + "B" + "{" + (cr + i) + "-" + (cc + i) + "}");
			}
		}
	}

	public static int countPath(int[][] board, int cr, int cc) {
		if (cr == board.length - 1 && cc == board[0].length - 1) {
			return 1;
		}

		if (cr >= board.length || cc >= board[0].length) {
			return 0;
		}
		int count = 0;

		count += countPath(board, cr + 1, cc + 2);
		count += countPath(board, cr + 2, cc + 1);
		if (cc == 0 || cc == board[0].length - 1 || cr == 0 || cr == board.length - 1) {
			for (int i = 1; i < board[0].length; i++) {
				count += countPath(board, cr, cc + i);
				count += countPath(board, cr + i, cc);
			}
		}
		if (cr == cc || cr + cc == board.length - 1) {
			for (int i = 1; i < board.length; i++) {
				count += countPath(board, cr + i, cc + i);
			}
		}
		return count;
	}
}