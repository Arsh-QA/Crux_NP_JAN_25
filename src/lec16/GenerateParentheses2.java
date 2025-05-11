package lec16;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses2 {

	public static void main(String[] args) {
		int n = 3;
		List<String> al = new ArrayList<String>();
		generateParentheses(n, 0, 0, "", al);
		System.out.println(al);
	}

	public static void generateParentheses(int n, int open, int close, String ans, List<String> al) {
		if (open == n && close == n) {
			al.add(ans);
//			System.out.println(ans);
			return;
		}
		if (open > n || close > open)
			return;

		generateParentheses(n, open + 1, close, ans + "(", al);
		generateParentheses(n, open, close + 1, ans + ")", al);
	}
}