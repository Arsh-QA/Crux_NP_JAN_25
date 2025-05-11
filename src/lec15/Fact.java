package lec15;

public class Fact {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(fac(n));
	}

	public static int fac(int n) {
		if (n == 0)// Base Case
			return 1;

		int fn = fac(n - 1);// SP
		return n * fn;// SP + Self Work
	}
}