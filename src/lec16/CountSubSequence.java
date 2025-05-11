package lec16;

public class CountSubSequence {

	public static void main(String[] args) {
		String ques = "abc";
		System.out.println("\n" + countSubSequence(ques, ""));
	}

	public static int countSubSequence(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return 1;
		}
		char ch = ques.charAt(0);
		int x = countSubSequence(ques.substring(1), ans);// No
		int y = countSubSequence(ques.substring(1), ans + ch);// Yes
		return x + y;
	}

	static int count = 0;

	public static void print(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + " ");
			count++;
			return;
		}
		char ch = ques.charAt(0);
		print(ques.substring(1), ans);// No
		print(ques.substring(1), ans + ch);// Yes
	}
}