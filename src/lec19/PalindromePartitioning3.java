package lec19;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning3 {

	public static void main(String[] args) {
		String s = "nitin";
		List<String> ll = new ArrayList<String>();
		List<List<String>> result = new ArrayList<List<String>>();
		palindrome(s, ll, result);
		System.out.println(result);
		System.out.println(result.size());
	}

	public static void palindrome(String ques, List<String> ll, List<List<String>> result) {
		if (ques.length() == 0) {
//			System.out.println(ll);
			result.add(new ArrayList<String>(ll));
			return;
		}
		for (int cut = 1; cut <= ques.length(); cut++) {
			String s = ques.substring(0, cut);
			if (isPalindrom(s)) {
				ll.add(s);
				palindrome(ques.substring(cut), ll, result);
				ll.remove(ll.size() - 1);
			}
		}
	}

	private static boolean isPalindrom(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}