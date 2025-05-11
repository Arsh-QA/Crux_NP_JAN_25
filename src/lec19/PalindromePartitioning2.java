package lec19;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning2 {

	public static void main(String[] args) {
		List<String> ll = new ArrayList<>();
		List<List<String>> result = new ArrayList<>();
		palindromePartitioning("nitin", ll, result);
		System.out.println(result);
	}

	public static void palindromePartitioning(String ques, List<String> ll, List<List<String>> result) {
		if (ques.length() == 0) {
//			System.out.println(ans);
			result.add(new ArrayList<>(ll));
			return;
		}
		for (int cut = 1; cut <= ques.length(); cut++) {
			String s = ques.substring(0, cut);
			if (isPalindrome(s)) {
				ll.add(s);
				palindromePartitioning(ques.substring(cut), ll, result);
				ll.remove(ll.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}