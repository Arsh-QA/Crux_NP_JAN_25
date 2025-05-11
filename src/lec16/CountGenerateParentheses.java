package lec16;

import java.util.ArrayList;
import java.util.List;

public class CountGenerateParentheses {

	public static void main(String[] args) {
		int n = 3;
		List<String> al = new ArrayList<String>();
		System.out.println(countParentheses(n, 0, 0, "", al));
		System.out.println(al);
	}

	public static int countParentheses(int n, int open, int close, String ans, List<String> al) {
		if (open == n && close == n) {
			al.add(ans);
//			System.out.println(ans);
			return 1;
		}
		if (open > n || close > open)
			return 0;

		int a1 = countParentheses(n, open + 1, close, ans + "(", al);
		int a2 = countParentheses(n, open, close + 1, ans + ")", al);
		return a1 + a2;
	}
}