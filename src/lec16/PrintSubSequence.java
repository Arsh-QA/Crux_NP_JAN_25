package lec16;

public class PrintSubSequence {

	public static void main(String[] args) {
		String ques = "abc";
		print(ques, "");
	}

	public static void print(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		char ch = ques.charAt(0);
		print(ques.substring(1), ans);// No
		print(ques.substring(1), ans + ch);// Yes
	}
}