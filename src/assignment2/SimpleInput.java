package assignment2;

import java.util.Scanner;

public class SimpleInput {
	public static void main(String[] args) {
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		while (sum >= 0) {
			int n = sc.nextInt();
			sum += n;
			if (sum < 0)
				break;
			else
				System.out.println(n);
		}
		sc.close();
	}
}