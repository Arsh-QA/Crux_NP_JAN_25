package dpAssignment;

import java.util.*;

public class CountNumberOfBinaryStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();

			if (n == 1) {
				System.out.println(2);
				continue;
			}

			if (n == 2) {
				System.out.println(3);
				continue;
			}

			long prev2 = 2; // dp[1]
			long prev1 = 3; // dp[2]
			long curr = 0;

			for (int i = 3; i <= n; i++) {
				curr = prev1 + prev2;
				prev2 = prev1;
				prev1 = curr;
			}

			System.out.println(curr);
		}

		sc.close();

	}
}