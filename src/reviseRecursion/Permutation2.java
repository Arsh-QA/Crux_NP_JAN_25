package reviseRecursion;

public class Permutation2 {
	public static void main(String[] args) {
		String ques = "abca";
		printPermutation(ques, "");
	}

	public static void printPermutation(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			boolean val = true;
			for (int j = i + 1; j < ques.length(); j++) {
				if (ques.charAt(j) == ch) {
					val = false;
					break;
				}
			}
			if (val == true) {
				String s1 = ques.substring(0, i);
				String s2 = ques.substring(i + 1);
				printPermutation(s1 + s2, ans + ch);
			}
		}
	}
}