package recursionRevision;

public class MazePath {

	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		mazePath(0, 0, m - 1, n - 1, "");

	}

	public static void mazePath(int h, int v, int m, int n, String ans) {
		if (h == m && v == n) {
			System.out.println(ans);
			return;
		}
		if (h > m || v > n)
			return;
		mazePath(h + 1, v, m, n, ans + "H");
		mazePath(h, v + 1, m, n, ans + "V");
	}
}