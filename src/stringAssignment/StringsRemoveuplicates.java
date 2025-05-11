package stringAssignment;

import java.util.Scanner;

public class StringsRemoveuplicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		removeDuplicates(s);
		sc.close();
	}

	public static void removeDuplicates(String s) {
		String s1 = "";
		for (int i = 0; i < s.length();) {
			char ch = s.charAt(i);
			while ((i < s.length()) && s.charAt(i) == ch) {
				i++;
			}
			s1 = s1 + ch;
		}
		System.out.println(s1);
	}
}