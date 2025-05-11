package recursionAssignment;

import java.util.Scanner;

public class ReplaceAllπ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n > 0) {
			String ques = sc.next();
			replace(ques, "");
			n--;
		}
		sc.close();
	}

	public static void replace(String ques, String ans) {
		if (ques.length() == 1) {
			System.out.println(ans + ques.charAt(ques.length() - 1));
			return;
		}
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		String subString = ques.substring(0, 2);
		if (subString.equals("pi"))
			replace(ques.substring(2), ans + 3.14);
		else
			replace(ques.substring(1), ans + ques.charAt(0));
	}
}