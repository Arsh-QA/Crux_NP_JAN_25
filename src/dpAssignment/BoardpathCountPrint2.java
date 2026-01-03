package dpAssignment;

import java.util.*;

public class BoardpathCountPrint2 {

	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // board size
		M = sc.nextInt(); // dice faces

		sc.close();

		// 1) DP to count total ways
		long[] dp = new long[N + 1];
		dp[0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int d = 1; d <= M; d++) {
				if (i - d >= 0) {
					dp[i] += dp[i - d];
				}
			}
		}

		// 2) Print all paths using simple recursion
		printPaths(0, "");
		
		System.out.println();

		// 3) Print number of ways
		System.out.println(dp[N]);

	}

	// Recursively print all paths (dice moves)
	static void printPaths(int pos, String path) {
		if (pos == N) {
			System.out.print(path + " ");
			return;
		}

		for (int d = 1; d <= M; d++) {
			if (pos + d <= N) {
				printPaths(pos + d, path + d);
			}
		}
	}
}