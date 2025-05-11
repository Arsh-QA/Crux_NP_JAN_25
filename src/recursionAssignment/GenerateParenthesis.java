package recursionAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GenerateParenthesis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> al = new ArrayList<String>();
		generate(n, 0, 0, "", al);
		Collections.sort(al, Collections.reverseOrder());
		for(String s : al)
			System.out.println(s);
		sc.close();
	}

	public static void generate(int n, int op, int cl, String ans, List<String> al) {
		if (op == n && cl == n) {
//			System.out.println(ans);
			al.add(ans);
			return;
		}
		if (op > n || cl > n || cl > op) {
			return;
		}
		generate(n, op + 1, cl, ans + "(", al);
		generate(n, op, cl + 1, ans + ")", al);
	}
}