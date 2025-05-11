package lec06;

import java.util.Scanner;

public class Inverse_Of_Number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(inverse(n));
		sc.close();
	}

	public static int inverse(int n) {
		int sum = 0;
		int pos = 1;
		while (n > 0) {
			int rem = n % 10;
			sum = (int) (sum + pos * Math.pow(10, rem - 1));
			pos++;
			n = n / 10;
		}
		return sum;
	}
}