package assignment2;

import java.util.Scanner;

public class LCM {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n1 = s.nextInt();
		int n2 = s.nextInt();
		int product = n1 * n2;
		int rem = 1;
		while (n2 > 0) {
			rem = n1 % n2;
			n1 = n2;
			n2 = rem;
		}
		System.out.println(product / n1);
		s.close();
	}
}