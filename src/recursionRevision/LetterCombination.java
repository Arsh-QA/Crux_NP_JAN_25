package recursionRevision;

public class LetterCombination {

	static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void main(String[] args) {
		String ques = "23";
		combinations(ques, "");
	}

	public static void combinations(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		char ch = ques.charAt(0);
		int num = ch - '0';
		String press = key[num];
		for (int i = 0; i < press.length(); i++) {
			combinations(ques.substring(1), ans + press.charAt(i));
		}
	}
}