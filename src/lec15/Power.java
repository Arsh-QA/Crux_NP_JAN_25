package lec15;

public class Power {

	public static void main(String[] args) {
		int a = 3;
		int n = 4;
		System.out.println(pow(a, n));

	}

	public static int pow(int a, int n) {
		if (n == 0)// Base Case
			return 1;

		int b = pow(a, n - 1);// SP
		return a * b;// SP + Self Work
	}
}