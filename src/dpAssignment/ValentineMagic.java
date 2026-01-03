package dpAssignment;

import java.util.*;

public class ValentineMagic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] boys = new int[N];
		int[] girls = new int[M];

		for (int i = 0; i < boys.length; i++) {
			boys[i] = sc.nextInt();
		}

		for (int i = 0; i < girls.length; i++) {
			girls[i] = sc.nextInt();
		}

		Arrays.sort(boys);
		Arrays.sort(girls);

		long INF = (long) 1e18;

		// dp[j] = best for current i boys and j girls

		long[][] dp = new long[N + 1][M + 1];

		for (int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], INF);
		}

		// base: 0 boys costs 0
		for (int j = 0; j <= M; j++)
			dp[0][j] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= M; j++) {
				long pair = dp[i - 1][j - 1] + Math.abs(boys[i - 1] - girls[j - 1]);
				long skip = dp[i][j - 1];

				dp[i][j] = Math.min(pair, skip);
			}
		}

		System.out.println(dp[N][M]);

		sc.close();

	}
}