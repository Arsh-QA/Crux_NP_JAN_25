package lec04;

public class CheckPrime {
	public static void main(String[] args) {
		int j = 1000000000;
		System.out.println(j);
		int n = 1000000000;
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				count++;
			}

		}
		if (count >= 1) {
			System.out.println("Not Prime");
		} else {
			System.out.println("Prime");
		}

	}
}
