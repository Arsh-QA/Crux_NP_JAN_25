package dpAssignment;

import java.util.*;

public class ExchangingCoins {

	static Map<Long, Long> memo = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		System.out.println(solve(n));
		sc.close();
	}

	public static long solve(long n) {
		if (n < 12) { // no benefit in breaking small coins
			return n;
		}

		if (memo.containsKey(n)) {
			return memo.get(n);
		}

		long result = solve(n / 2) + solve(n / 3) + solve(n / 4);
		memo.put(n, result);

		return result;
	}
}