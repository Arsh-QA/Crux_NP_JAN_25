package arrayAssignment;

import java.util.Scanner;

public class TheWatermelonSplit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 2)
			System.out.println("NO");
		else if (n % 2 == 0) {
			System.out.println("YES");
		} else
			System.out.println("NO");
		sc.close();
	}
}