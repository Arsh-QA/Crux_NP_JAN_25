package lec13;

import java.util.Scanner;

public class PlayingWithGoodString_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(lengthGoodString(str));
		sc.close();
	}

	public static int lengthGoodString(String s) {
		int ans = 0;
		int c = 0;
		for (int i = 0; i < s.length(); i++) {
			if (isVowels(s.charAt(i))) {
				c++;
			} else {
				ans = Math.max(ans, c);
				c = 0;
			}
		}
		ans = Math.max(ans, c);
		return ans;
	}

	public static boolean isVowels(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			return true;
		return false;
	}
}