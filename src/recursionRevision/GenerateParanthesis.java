package recursionRevision;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public static void main(String[] args) {
		int n = 3;
		List<String> al = new ArrayList<String>();
		generate(0, 0, n, "", al);
		for(String s : al) {
			System.out.print(s + " ");
		}
	}

	public static void generate(int op, int cl, int n, String ans, List<String> al) {
		if (op == n && cl == n) {
			System.out.println(ans);
			al.add(ans);
			return;
		}
		if (op > n || cl > op) {
			return;
		}
		generate(op + 1, cl, n, ans + '(', al);
		generate(op, cl + 1, n, ans + ')', al);
	}
}