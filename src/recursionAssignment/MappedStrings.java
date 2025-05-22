package recursionAssignment;

import java.util.Scanner;

public class MappedStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String s = Integer.toString(n);
		mappedStrings(s, "");
		sc.close();
	}

	static char[] ch = { '0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static void mappedStrings(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int cut = 1; cut <= ques.length(); cut++) {
			String s = ques.substring(0, cut);
			if (Integer.parseInt(s) < 27 && Integer.parseInt(s) > 0) {
				mappedStrings(ques.substring(cut), ans + ch[Integer.parseInt(s)]);
			}
		}
	}
}