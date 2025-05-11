package assignment2;

import java.util.Scanner;

public class BostonNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum1 = findPrimeFactors(n);
		int sum2 = findSumOfDigits(n);
		if (sum1 == sum2)
			System.out.println(1);
		else
			System.out.println(0);
		sc.close();
	}

	public static int findPrimeFactors(int n) {
		int sum = 0;
		while (n % 2 == 0) {
//			System.out.print(2 + " ");
			sum += 2;
			n /= 2;
		}
		for (int i = 3; i * i <= n; i += 2) {
			while (n % i == 0) {
//				System.out.print(i + " ");
				sum += findSumOfDigits(i);
				n /= i;
			}
		}

		if (n > 2) {
//			System.out.print(n);
			sum += findSumOfDigits(n);
		}
		return sum;
	}

	public static int findSumOfDigits(int n) {
		int sum = 0;
		while (n > 0) {
			int rem = n % 10;
			sum += rem;
			n /= 10;
		}
		return sum;
	}
}