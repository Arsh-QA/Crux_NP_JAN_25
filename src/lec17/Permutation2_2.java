package lec17;

public class Permutation2_2 {

	public static void main(String[] args) {
		String str = "abca";
		print(str, "");

	}

	public static void print(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (isPresent(str, ch, i + 1) == false) {
				String s1 = str.substring(0, i);
				String s2 = str.substring(i + 1);
				print(s1 + s2, ans + ch);
			}
		}
	}

	public static boolean isPresent(String str, char ch, int idx) {
		for (int i = idx; i < str.length(); i++) {
			if (str.charAt(i) == ch)
				return true;
		}
		return false;
	}

}
