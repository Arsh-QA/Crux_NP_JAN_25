package lec16prefix;

public class SubSequence {

	public static void main(String[] args) {
		String ques = "abc";
//		printSubSequence(ques, "");
//		System.out.println(count);

		System.out.println(countSubSequence(ques, ""));
	}

//	static int count = 0;

	public static void printSubSequence(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
//			count++;
			return;
		}
		char ch = ques.charAt(0);
		printSubSequence(ques.substring(1), ans);
		printSubSequence(ques.substring(1), ans + ch);
	}

	public static int countSubSequence(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
//			count++;
			return 1;
		}
		char ch = ques.charAt(0);
		int a1 = countSubSequence(ques.substring(1), ans);
		int a2 = countSubSequence(ques.substring(1), ans + ch);
		return a1 + a2;
	}
}