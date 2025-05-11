package recursionAssignment;

import java.util.Scanner;

public class RecursionLexicographicalOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		lexicographical(n, 0);
	}

	public static void lexicographical(int n, int curr) {
		if (curr > n)
			return;
		System.out.print(curr + " ");
		int i = 0;
		if (curr == 0) {
			i = 1;
		}
		for (; i <= 9; i++) {
			lexicographical(n, curr * 10 + i);
		}
	}
}