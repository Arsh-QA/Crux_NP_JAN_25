package lec20_21_revise;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		int n = 100;
		primeSieve(n);
	}

	// index false = prime
	// index true = not prime
	public static void primeSieve(int n) {
		boolean[] prime = new boolean[n + 1];
		prime[0] = true;// not prime
		prime[1] = true;// not prime
		for (int i = 2; i * i < prime.length; i++) {
			if (prime[i] == false) {
				for (int j = 2; i * j < prime.length; j++) {
					prime[i * j] = true;
				}
			}
		}
		for (int i = 2; i < prime.length; i++) {
			if (prime[i] == false) {
				System.out.print(i + " ");
			}
		}
	}
}