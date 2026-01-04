package reviseRecursionDP;

public class WineProblem {

	public static void main(String[] args) {
		int[] wine = { 2, 3, 5, 1, 4 };
		System.out.println(maximumProfit(wine, 0, wine.length - 1, 1));
		System.out.println(maximumProfiBU(wine));
	}

	public static int maximumProfit(int[] wine, int i, int j, int year) {
		if (i > j) {
			return 0;
		}

		int fs = year * wine[i] + maximumProfit(wine, i + 1, j, year + 1);
		int ls = year * wine[j] + maximumProfit(wine, i, j - 1, year + 1);
		return Math.max(fs, ls);
	}

	public static int maximumProfiBU(int[] wine) {
		int[][] dp = new int[wine.length][wine.length];
		int year = wine.length;
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = wine[i] * year;
		}
		year--;
		for (int slide = 1; slide < dp.length; slide++) {
			for (int j = slide; j < dp.length; j++) {
				int i = j - slide;
				int fs = year * wine[i] + dp[i + 1][j];
				int ls = year * wine[j] + dp[i][j - 1];
				dp[i][j] = Math.max(fs, ls);
			}
			year--;
		}
		return dp[0][dp.length - 1];
	}
}