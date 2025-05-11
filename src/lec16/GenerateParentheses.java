package lec16;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		int n = 3;
		List<String> al = new ArrayList<String>();
		print(n, 0, 0, "", al);
		System.out.println(al);
	}

	public static void print(int n, int open, int close, String ans, List<String> al) {
		if (open == n && close == n) {
			al.add(ans);
//			System.out.println(ans);
			return;
		}
		if (open > n || close > open)
			return;

		print(n, open + 1, close, ans + "(", al);
		print(n, open, close + 1, ans + ")", al);
	}
}