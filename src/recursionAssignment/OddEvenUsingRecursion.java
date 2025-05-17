package recursionAssignment;

import java.util.Scanner;

public class OddEvenUsingRecursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		print(n);
//		System.out.println("=================");
//		printEven(n);
//		System.out.println("=================");
		combinedPrint(n);
		sc.close();
	}

	public static void print(int n) {
		if (n < 1) {
			return;
		}

		if (n % 2 != 0) {
			System.out.println(n);
			print(n - 2);
		} else {
			System.out.println(n - 1);
			print(n - 3);
		}
	}

	public static void printEven(int n) {
		if (n == 0)
			return;

		if (n % 2 == 0) {
//			System.out.println("Entered this");
			printEven(n - 2);
			System.out.println(n);
		} else {
			printEven(n - 1);
		}
	}

	public static void combinedPrint(int n) {
		if (n < 1)
			return;
		if (n % 2 != 0) {
			System.out.println(n);
			combinedPrint(n - 2);
			if (n > 1)
				System.out.println(n - 1);
		} else {
			combinedPrint(n - 1);
			System.out.println(n);
		}
	}
}