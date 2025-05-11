package recursionAssignment;

import java.util.Scanner;

public class GenerateBinaryStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			String s = sc.next();
			generate(s, "");
			t--;
		}
		sc.close();
	}

	public static void generate(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		char ch = ques.charAt(0);
		if (ch == '0' || ch == '1') {
			generate(ques.substring(1), ans + ch);
		} else {
			generate(ques.substring(1), ans + "0");
			generate(ques.substring(1), ans + "1");
		}
	}
}