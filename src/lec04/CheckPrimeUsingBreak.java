package lec04;

public class CheckPrimeUsingBreak {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				count++;
				break;
			}

		}
		if (count >= 1) {
			System.out.println("Not prime");
		} else {
			System.out.println("Prime");
		}

	}
}
