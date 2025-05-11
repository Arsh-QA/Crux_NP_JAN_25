package assignment2;

import java.util.Scanner;

public class OddEvenDigitsSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int oddDigitsSum = 0;
		int evenDigitsSum = 0;
		int count = 0;
		while (n > 0) {
			int rem = n % 10;
			if (count % 2 == 0)
				oddDigitsSum += rem;
			else
				evenDigitsSum += rem;
			count++;
			n /= 10;
		}
		System.out.println(oddDigitsSum);
		System.out.println(evenDigitsSum);
		sc.close();
	}
}