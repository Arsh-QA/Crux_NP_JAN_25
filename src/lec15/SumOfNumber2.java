package lec15;

public class SumOfNumber2 {

	public static void main(String[] args) {
		int n = 110;
		System.out.println(sumOfNumber(n));
	}

	public static int sumOfNumber(int n) {
		if (n == 1)
			return 1;
		int sum = sumOfNumber(n - 1);
		return n + sum;
	}
}