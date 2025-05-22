package recursionAssignment;

import java.util.Scanner;

public class CountRemoveReplaceHiPart2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(numberOfTimes(str));
		removeHi(str, "");
		replaceHi(str, "");
		sc.close();
	}

	public static int numberOfTimes(String ques) {
		if (ques.length() <= 1) {
			return 0;
		}
		if (ques.length() == 2) {
			if (ques.equals("hi")) {
				return 1;
			} else
				return 0;
		}

		String str = ques.substring(0, 2);
		if (str.equals("hi") && !ques.subSequence(2, 3).equals("t")) {
			return 1 + numberOfTimes(ques.substring(2));
		} else
			return numberOfTimes(ques.substring(1));
	}

	public static void removeHi(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		if (ques.length() == 1) {
			ans = ans + ques.substring(ques.length() - 1);
			System.out.println(ans);
			return;
		}
		if (ques.length() == 2) {
			if (ques.equals("hi")) {
				ans = ans + "";
				System.out.println(ans);
				return;
			} else {
				ans = ans + ques.substring(ques.length() - 2);
				System.out.println(ans);
				return;
			}
		}
		String str = ques.substring(0, 2);
		if (str.equals("hi") && !ques.subSequence(2, 3).equals("t")) {
			removeHi(ques.substring(2), ans);
		} else
			removeHi(ques.substring(1), ans + ques.charAt(0));
	}

	public static void replaceHi(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		if (ques.length() == 1) {
			ans = ans + ques.substring(ques.length() - 1);
			System.out.println(ans);
			return;
		}
		if (ques.length() == 2) {
			if (ques.equals("hi")) {
				ans = ans + "bye";
				System.out.println(ans);
				return;
			} else {
				ans = ans + ques.substring(ques.length() - 2);
				System.out.println(ans);
				return;
			}
		}
		String str = ques.substring(0, 2);
		if (str.equals("hi") && !ques.subSequence(2, 3).equals("t")) {
			replaceHi(ques.substring(2), ans + "bye");
		} else
			replaceHi(ques.substring(1), ans + ques.charAt(0));
	}
}