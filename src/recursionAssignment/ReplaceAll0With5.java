package recursionAssignment;

import java.util.Scanner;

public class ReplaceAll0With5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		replace(n, "");
		sc.close();
	}

	public static void replace(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		int r = n % 10;
		if (r == 0)
			replace(n / 10, 5 + ans);
		else
			replace(n / 10, r + ans);
	}
}