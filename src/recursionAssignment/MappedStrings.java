package recursionAssignment;

import java.util.Scanner;

public class MappedStrings {

	char[] ch = { '0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String s = Integer.toString(n);
		mappedStrings(s, "");
		sc.close();
	}

	public static void mappedStrings(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int cut = 1; cut <= ques.length(); cut++) {
			String s = ques.substring(0, cut);
			mappedStrings(ques.substring(cut), ans + (stringToInteger(s)) + "|");
		}
	}

	public static int stringToInteger(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int len = s.length() - 1;
		int c = (int) s.charAt(0) - '0';
		return (int) (c * Math.pow(10, len)) + stringToInteger(s.substring(1));
	}
}