package lec19;

import java.util.Scanner;

public class RatChasesItsCheese2 {

	static boolean path = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] maze = new char[n][m];
		for (int i = 0; i < maze.length; i++) {
			String s = sc.next();
			for (int j = 0; j < maze[0].length; j++) {
				maze[i][j] = s.charAt(j);
			}
		}
		int[][] ans = new int[n][m];
		printPath(maze, 0, 0, ans);
		if (path == false) {
			System.out.println("NO PATH FOUND");
		}
		sc.close();
	}

	public static void printPath(char[][] maze, int cr, int cc, int[][] ans) {
		if (cr == maze.length - 1 && cc == maze[0].length - 1) {
			ans[cr][cc] = 1;
			display(ans);
			path = true;
			return;
		}
		if (cc < 0 || cr < 0 || cc >= maze[0].length || cr >= maze.length || maze[cr][cc] == 'X') {
			return;
		}
		maze[cr][cc] = 'X';
		ans[cr][cc] = 1;
		int[] r = { -1, 0, 1, 0 };
		int[] c = { 0, -1, 0, 1 };
		for (int i = 0; i < r.length; i++) {
			printPath(maze, cr + r[i], cc + c[i], ans);
		}
//		printPath(maze, cr + r, cc+c, ans);// up
//		printPath(maze, cr, cc - 1, ans);// left
//		printPath(maze, cr + 1, cc, ans);// down
//		printPath(maze, cr, cc + 1, ans);// right
		maze[cr][cc] = 'O';
		ans[cr][cc] = 0;
	}

	private static void display(int[][] ans) {
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

}