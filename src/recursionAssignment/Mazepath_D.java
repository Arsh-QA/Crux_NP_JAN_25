package recursionAssignment;

import java.util.Scanner;

public class Mazepath_D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		mazePath(0, 0, n - 1, m - 1, "");
		System.out.println();
		System.out.println(countMazePath(0, 0, n - 1, m - 1, ""));
		sc.close();
	}

	public static void mazePath(int cr, int cc, int n, int m, String ans) {
		if (cr == n && cc == m) {
			System.out.print(ans + " ");
			return;
		}
		if (cr > n || cc > m) {
			return;
		}

		mazePath(cr + 1, cc, n, m, ans + "V");
		mazePath(cr, cc + 1, n, m, ans + "H");
		mazePath(cr + 1, cc + 1, n, m, ans + "D");
	}

	public static int countMazePath(int cr, int cc, int n, int m, String ans) {
		if (cr == n && cc == m) {
//			System.out.print(ans + " ");
			return 1;
		}
		if (cr > n || cc > m) {
			return 0;
		}

		int c1 = countMazePath(cr + 1, cc, n, m, ans + "V");
		int c2 = countMazePath(cr, cc + 1, n, m, ans + "H");
		int c3 = countMazePath(cr + 1, cc + 1, n, m, ans + "D");
		return c1 + c2 + c3;
	}
}