package binary2DArrayAssignment;

import java.util.Scanner;

public class FindSquareRoot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		System.out.println(squareRoot(n));
		sc.close();
	}

	public static long squareRoot(long n) {
		long low = 0;
		long high = n;
		long ans = -1;
		while (low <= high) {
			long mid = low + (high - low) / 2;
			if(mid * mid == n) {
				ans = mid;
				break;
			} else if(mid * mid < n) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid-1;
			}
		}
		return ans;
	}
}