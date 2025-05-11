package recursionAssignment;

import java.util.Scanner;

public class BoardPath_CountPrint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boardPath(n, m, 0, "");
		System.out.println();
		System.out.println(countBoardPath(n, m, 0, ""));
		sc.close();
	}

	public static void boardPath(int n, int m, int curr, String ans) {
		if (curr == n) {
			System.out.print(ans + " ");
			return;
		}
		if (curr > n)
			return;
		for (int i = 1; i <= m; i++) {
			boardPath(n, m, curr + i, ans + i);
		}
	}

	public static int countBoardPath(int n, int m, int curr, String ans) {
		if (curr == n) {
//			System.out.println(ans);
			return 1;
		}
		if (curr > n)
			return 0;
		int count = 0;
		for (int i = 1; i <= m; i++) {
			count += countBoardPath(n, m, curr + i, ans + i);
		}
		return count;
	}
}