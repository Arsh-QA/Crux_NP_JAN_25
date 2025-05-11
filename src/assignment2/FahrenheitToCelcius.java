package assignment2;

import java.util.Scanner;

public class FahrenheitToCelcius {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int min = s.nextInt();
		int max = s.nextInt();
		int step = s.nextInt();
		FTC(min, max, step);
		s.close();
	}

	public static void FTC(int min, int max, int step) {
		for (int f = min; f <= max; f = f + step) {
			int c = (int) (5 * (f - 32)) / 9;
			System.out.println(f + "\t" + c);
		}
	}
}