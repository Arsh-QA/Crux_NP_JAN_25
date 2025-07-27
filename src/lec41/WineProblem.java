package lec41;

public class WineProblem {

	public static void main(String[] args) {
		int wine[] = { 2, 3, 1, 5, 4 };
		System.out.println(maximumProfits(wine, 0, wine.length - 1, 1));
		System.out.println(maximumProfits(wine));
	}

	public static int maximumProfits(int[] wine) {
		int[][] dp = new int[wine.length][wine.length];
		int year = wine.length;
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = wine[i] * year;
		}
		year--;
		for (int gap = 1; gap < wine.length; gap++) {
			for (int j = gap; j < wine.length; j++) {
				int i = j - gap;
				int f = wine[i] * year + dp[i + 1][j];
				int l = wine[j] * year + dp[i][j - 1];
				dp[i][j] = Math.max(f, l);
			}
			year--;
		}
		return dp[0][dp[0].length - 1];
	}

	public static int maximumProfits(int[] wine, int i, int j, int year) {
		if (i > j)
			return 0;
		int f = wine[i] * year + maximumProfits(wine, i + 1, j, year + 1);
		int l = wine[j] * year + maximumProfits(wine, i, j - 1, year + 1);
		return Math.max(f, l);
	}
}