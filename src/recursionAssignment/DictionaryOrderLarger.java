package recursionAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DictionaryOrderLarger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		List<String> al = new ArrayList<>();
		dictionaryOrder(s, "", s, al);
		Collections.sort(al);
		for (String ans : al) {
			System.out.println(ans);
		}
		sc.close();
	}

	public static void dictionaryOrder(String ques, String ans, String s, List<String> al) {
		if (ques.length() == 0) {
			if (ans.compareTo(s) > 0)
				al.add(ans);
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String s1 = ques.substring(0, i);
			String s2 = ques.substring(i + 1);
			dictionaryOrder(s1 + s2, ans + ch, s, al);
		}
	}

	public static int compareTo(String s1, String s2) {
		if (s1 == s2)
			return 0;
		int len = Math.min(s1.length(), s2.length());
		for (int i = 0; i < len; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return s1.charAt(i) - s2.charAt(i);
			}
		}
		return s1.length() - s2.length();
	}
}