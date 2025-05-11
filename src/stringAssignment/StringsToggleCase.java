package stringAssignment;

import java.util.Scanner;

public class StringsToggleCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		toggle(s);
		sc.close();
	}

	public static void toggle(String s) {
		String s1 = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - 'A' < 32) {
				s1 = s1 + (char) (s.charAt(i) + 32);
			} else {
				s1 = s1 + (char) (s.charAt(i) - 32);
			}
		}
		System.out.println(s1);
	}
}