package stringAssignment;

import java.util.Scanner;

public class CanYouReadThis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		readThis(s);
		sc.close();
	}

	public static void readThis(String s) {
		for (int i = 0; i < s.length();) {
			if (s.charAt(i) - 'A' <= 26) {
				int j = i + 1;
				String s1 = "";
				while ((j < s.length()) && (s.charAt(j) - 'A') > 26) {
					j++;
				}
				s1 = s1 + s.substring(i, j);
				System.out.println(s1);
				i = j;
			} else {
				i++;
			}
		}
	}
}