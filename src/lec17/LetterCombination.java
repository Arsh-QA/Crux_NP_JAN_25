package lec17;

import java.util.*;

public class LetterCombination {

	static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void main(String[] args) {
		String ques = "236";
		List<String> ll = new ArrayList<String>();
		letterCombinations(ques, "", ll);
		System.out.println(ll);
		// Leetcode corner case in which list is empty
//		if (digits.length() == 0) {
//      return ll;
//  }
	}

	public static void letterCombinations(String ques, String ans, List<String> ll) {
		if (ques.length() == 0) {
//			System.out.println(ans);
			ll.add(ans);
			return;
		}
		char ch = ques.charAt(0);// '2'
		String press = key[ch - '0'];
		for (int i = 0; i < press.length(); i++) {
			letterCombinations(ques.substring(1), ans + press.charAt(i), ll);
		}
	}
}