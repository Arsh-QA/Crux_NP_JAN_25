package dpBitMaskingAssignment;

import java.util.Scanner;

public class UltraFastMathematicians {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			String str1 = sc.next();
			String str2 = sc.next();
			StringBuilder strbr = new StringBuilder();
			for (int i = 0; i < str1.length(); i++) {
				char a = str1.charAt(i);
				char b = str2.charAt(i);
				int c = (a ^ b);
				strbr.append(c);
			}
			System.out.println(strbr);
			t--;
		}
		sc.close();
	}
}