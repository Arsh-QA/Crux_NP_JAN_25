package lec17;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination2 {

	static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void main(String[] args) {
		String ques = "23";
		List<String> ll = new ArrayList<String>();
		letterCombinations(ques, "", ll);
		System.out.println(ll);
		// Leetcode corner case in which list is empty
//		if (digits.length() == 0) {
//            return ll;
//        }
	}

	public static void letterCombinations(String ques, String ans, List<String> ll) {
		if (ques.length() == 0) {
			ll.add(ans);
			return;
		}
		char ch = ques.charAt(0);
		String ops = key[ch - '0'];
		for (int i = 0; i < ops.length(); i++) {
			letterCombinations(ques.substring(1), ans + ops.charAt(i), ll);
		}
	}

}
