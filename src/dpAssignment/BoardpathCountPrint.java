package dpAssignment;

import java.util.*;

public class BoardpathCountPrint {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // board size
		int M = sc.nextInt(); // dice faces

		long[] dp = new long[N + 1];
		dp[0] = 1; // base case

		// Count ways using DP
		for (int i = 1; i <= N; i++) {
			long ways = 0;
			for (int k = 1; k <= M && i - k >= 0; k++) {
				ways += dp[i - k];
			}
			dp[i] = ways;
		}

		long count = dp[N];

		// DP for storing paths
		ArrayList<String>[] paths = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			paths[i] = new ArrayList<>();
		}

		paths[0].add(""); // base case

		for (int i = 1; i <= N; i++) {
			for (int k = 1; k <= M && i - k >= 0; k++) {
				for (String prev : paths[i - k]) {
					paths[i].add(prev + k);
				}
			}
		}

		// Print all paths
		for (String p : paths[N]) {
			System.out.print(p + " ");
		}

		System.out.println();
		System.out.print(count);

		sc.close();
	}
}