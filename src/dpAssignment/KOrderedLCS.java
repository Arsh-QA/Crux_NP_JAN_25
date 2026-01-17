package dpAssignment;

import java.util.*;

public class KOrderedLCS {

	static int N, M, K;
	static int[] A, B;
	static int[][][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		A = new int[N];
		B = new int[M];

		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		for (int i = 0; i < M; i++)
			B[i] = sc.nextInt();

		dp = new int[N + 1][M + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				for (int k = 0; k <= K; k++) {

					// Skip A or B
					dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i][j - 1][k]);

					// Match without change
					if (A[i - 1] == B[j - 1]) {
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k] + 1);
					}

					// Match with change
					else if (k > 0) {
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k - 1] + 1);
					}
				}
			}
		}

		int ans = 0;
		for (int k = 0; k <= K; k++) {
			ans = Math.max(ans, dp[N][M][K]);
		}

		System.out.println(ans);
		sc.close();
	}
}