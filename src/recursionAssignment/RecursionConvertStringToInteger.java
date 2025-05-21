package recursionAssignment;

import java.util.Scanner;

public class RecursionConvertStringToInteger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(stringToInteger(s));
		sc.close();
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