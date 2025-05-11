package stringAssignment;

import java.util.Scanner;

public class StringsDifferenceinAsciiCodes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		differenceInAsciiCodes(s);
		sc.close();
	}

	public static void differenceInAsciiCodes(String s) {
		String s1 = "" + s.charAt(0);
		for (int i = 0; i < s.length() - 1; i++) {
			int d = s.charAt(i + 1) - s.charAt(i);
			s1 = s1 + d;
			s1 = s1 + s.charAt(i + 1);
		}
		System.out.println(s1);
	}
}