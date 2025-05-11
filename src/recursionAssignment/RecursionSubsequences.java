package recursionAssignment;

import java.util.Scanner;

public class RecursionSubsequences {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ques = sc.next();
		System.out.println("\n" + subsequences(ques, ""));
		sc.close();
	}

	public static int subsequences(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return 1;
		}
		char ch = ques.charAt(0);
		int c1 = subsequences(ques.substring(1), ans);
		int c2 = subsequences(ques.substring(1), ans + ch);
		return c1 + c2;
	}
}