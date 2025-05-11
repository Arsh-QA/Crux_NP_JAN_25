package arrayAssignment;

import java.util.Scanner;

public class NobitaScoredGoodMarks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int x = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(minimumCandles(x, n));
			t--;
		}
		sc.close();
	}

	public static int minimumCandles(int x, int n) {
		int rem = x % n;
		if (rem == 0)
			return 0;
		while (x > 0) {
			rem = x % n;
			if (n - rem > rem) {
				return rem;
			} else
				return n - rem;
		}
		return 0;
	}
}
