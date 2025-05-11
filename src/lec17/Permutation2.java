package lec17;

public class Permutation2 {

	public static void main(String[] args) {
		String str = "abca";
		print(str, "");
	}

	public static void print(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			if (isPresent(ques, ch, i + 1) == false) {
				String s1 = ques.substring(0, i);
				String s2 = ques.substring(i + 1);
				print(s1 + s2, ans + ch);
			}
		}
	}

	public static boolean isPresent(String str, char ch, int idx) {
		for (int i = idx; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				return true;
			}
		}
		return false;
	}
}