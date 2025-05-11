package stringAssignment;

import java.util.Scanner;

public class StringsOddEvenCharacter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		oddEvenCharacter(s);
		sc.close();
	}

	public static void oddEvenCharacter(String s) {
		String s1 = "";
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				s1 = s1 + (char) (s.charAt(i) + 1);
			} else {
				s1 = s1 + (char) (s.charAt(i) - 1);
			}
		}
		System.out.println(s1);
	}
}