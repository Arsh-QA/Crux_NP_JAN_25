package recursionAssignment;

import java.util.Scanner;

public class NthTriangleRecursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(triangle(n, 0));
		sc.close();
	}

	public static int triangle(int n, int sum) {
		if (n <= 1) {
			sum += 1;
			return sum;
		}
		return triangle(n - 1, sum) + n;
	}
}