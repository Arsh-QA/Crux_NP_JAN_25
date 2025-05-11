package recursionAssignment;

import java.util.Scanner;

public class RecursionKeypadCodes {

	static String[] keys = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wx", "yz" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = Integer.toString(n);
		int count = keypad(str, "");
		System.out.println();
		System.out.println(count);
		sc.close();
	}

	public static int keypad(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return 1;
		}
		char ch = str.charAt(0);
		String result = keys[ch - '0'];
		int count = 0;
		for (int i = 0; i < result.length(); i++) {
			count += keypad(str.substring(1), ans + result.charAt(i));
		}
		return count;
	}
}