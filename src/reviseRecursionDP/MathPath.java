package reviseRecursionDP;

public class MathPath {
	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		printPath(0, 0, n - 1, m - 1, "");
	}

	// cc --> current column
	// cr --> current row
	// ec --> end column
	// er --> end row
	public static void printPath(int cc, int cr, int ec, int er, String ans) {
		if (cc == ec && cr == er) {
			System.out.println(ans);
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}
		printPath(cc + 1, cr, ec, er, ans + "H");
		printPath(cc, cr + 1, ec, er, ans + "V");
	}
}