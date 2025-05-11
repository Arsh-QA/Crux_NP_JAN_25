package lec15;

public class SumOfNumber {

	public static void main(String[] args) {
		int n = 110;
		System.out.println(sumOfNumber(n));
	}

	public static int sumOfNumber(int n) {
		if (n == 1)// Base Case
			return 1;
		int ans = sumOfNumber(n - 1);// SP
		return n + ans;// SP + Self Work
	}
}