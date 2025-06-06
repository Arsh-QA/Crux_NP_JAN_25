package stringAssignment;

import java.util.Scanner;

public class StringsStringCompression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		compressedString(s);
		sc.close();
	}

	public static void compressedString(String s) {
		String s1 = "";
		for (int i = 0; i < s.length();) {
			char ch = s.charAt(i);
			int count = 0;
			while ((i < s.length()) && s.charAt(i) == ch) {
				count++;
				i++;
			}
			if (count > 1) {
				s1 = s1 + ch + count;
			} else {
				s1 = s1 + ch;
			}
		}
		System.out.println(s1);
	}
}