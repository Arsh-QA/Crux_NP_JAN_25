package lec40;

public class EditDistance2 {
	public static void main(String[] args) {
		String s = "FOOD";
		String t = "MONEY";
		System.out.println(editDistance(s, t, 0, 0));
	}

	// i --> s
	// j --> t
	public static int editDistance(String s, String t, int i, int j) {
		if (i == s.length()) {
			return t.length() - j;
		}
		if (j == t.length()) {
			return s.length() - i;
		}
		int ans = 0;
		if (s.charAt(i) == t.charAt(j)) {
			ans = editDistance(s, t, i + 1, j + 1);// dp[i-1][j-1]
		} else {
			int D = editDistance(s, t, i + 1, j);// dp[i-1][j]
			int I = editDistance(s, t, i, j + 1);// dp[i][j-1]
			int R = editDistance(s, t, i + 1, j + 1);// dp[i-1][j-1]
			ans = 1 + Math.min(I, Math.min(D, R));
		}
		return ans;
	}
}