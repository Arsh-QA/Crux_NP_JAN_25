package lec20_21_revise;

public class CheckPrime {

	public static void main(String[] args) {
		int n = 11;
		System.out.println(isPrime(n));
	}

	public static boolean isPrime(int n) {
		int div = 2;
		while (div * div <= n) {
			if (n % div == 0) {
				return false;
			}
			div++;
		}
		return true;
	}
}