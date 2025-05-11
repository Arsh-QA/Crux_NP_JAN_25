package assignment2;

import java.util.Scanner;

public class ShoppingGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int a = sc.nextInt();
			int h = sc.nextInt();
			winner(a, h);
			t--;
		}
		sc.close();
	}

	public static void winner(int a, int h) {
		int i = 1;
		while (a >= 0 && h >= 0) {
			a -= i;
			i += 1;
			h -= i;
			i += 1;
		}
		System.out.println();
		if (a < 0)
			System.out.print("Harshit");
		else
			System.out.print("Aayush");
	}

}
