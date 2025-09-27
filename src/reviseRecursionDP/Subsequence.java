package reviseRecursionDP;

public class Subsequence {
	public static void main(String[] args) {
		String ques = "abc";
		printSubsequence(ques, "");
		System.out.println(countSubsequence(ques, ""));
	}

	public static void printSubsequence(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		printSubsequence(ques.substring(1), ans);
		printSubsequence(ques.substring(1), ans + ch);
	}

//	static int count = 0;

	public static int countSubsequence(String ques, String ans) {
		if (ques.length() == 0) {
//			System.out.println(ans);
			return 1;
		}
		char ch = ques.charAt(0);
		int a1 = countSubsequence(ques.substring(1), ans);
		int a2 = countSubsequence(ques.substring(1), ans + ch);
		return a1 + a2;
	}
}