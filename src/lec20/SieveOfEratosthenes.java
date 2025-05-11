package lec20;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		int n = 121;
		System.out.println(checkPrime(n));
		System.out.println(primeSieve(n));
	}

	public static int primeSieve(int n) {
		int[] prime = new int[n];
		prime[0] = 1;// Not prime
		prime[1] = 1;// Not prime
		for (int i = 2; i * i < prime.length; i++) {
			if (prime[i] == 0) { // i is prime number
				for (int j = 2; i * j < prime.length; j++) {
					prime[i * j] = 1; // not prime
				}
			}
		}
		int count = 0;
		for (int i = 2; i < prime.length; i++) {
			if (prime[i] == 0) {
				count++;
			}
		}
		return count;
	}

	public static int checkPrime(int n) {
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
//				System.out.println(i);
				count++;
			}
		}
		return count;
	}

	public static boolean isPrime(int n) {
		int div = 2;
		while (div * div <= n) {
			if (n % div == 0)
				return false;
			div++;
		}
		return true;
	}

}
