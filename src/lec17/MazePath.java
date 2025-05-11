package lec17;

public class MazePath {

	public static void main(String[] args) {
		int n = 3;// row
		int m = 4;// col
		print(0, 0, n - 1, m - 1, "");
	}

	// cr -> current row | cc -> current column | er -> end row | ec -> end column
	public static void print(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}
		if (cr > er || cc > ec)
			return;
		print(cr, cc + 1, er, ec, ans + "H");
		print(cr + 1, cc, er, ec, ans + "V");
	}
}