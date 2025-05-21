package recursionAssignment;

import java.util.Scanner;

public class RatChasesItsCheese {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] board = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		int[][] ans = new int[n][m];
		mazePath(board, 0, 0, ans);
		if (path == false) {
			System.out.println("NO PATH FOUND");
		}
		sc.close();
	}

	public static boolean path = false;

	public static void mazePath(char board[][], int cr, int cc, int[][] ans) {
		if (cr == board.length - 1 && cc == board[0].length - 1) {
			ans[cr][cc] = 1;
			display(ans);
			path = true;
			return;
		}
		if (cr < 0 || cr >= board.length || cc < 0 || cc >= board[0].length || board[cr][cc] == 'X') {
			return;
		}

		board[cr][cc] = 'X';
		ans[cr][cc] = 1;
		mazePath(board, cr - 1, cc, ans);// up
		mazePath(board, cr, cc - 1, ans);// left
		mazePath(board, cr + 1, cc, ans);// down
		mazePath(board, cr, cc + 1, ans);// right
		board[cr][cc] = 'O';
		ans[cr][cc] = 0;
	}

	public static void display(int[][] ans) {
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}