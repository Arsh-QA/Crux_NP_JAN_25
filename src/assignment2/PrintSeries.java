package assignment2;

import java.util.Scanner;

public class PrintSeries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int k = 1;
		int count = 0;
		while (count < n1) {
			int j = 3 * k + 2;
			if (j % n2 != 0) {
				System.out.println(j);
				count++;
			}
			k++;
		}
		sc.close();
	}
}