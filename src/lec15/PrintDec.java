package lec15;

public class PrintDec {

	public static void main(String[] args) {
		int n = 5;
		PD(n);
	}

	public static void PD(int n) {
		if (n == 0)// Base Case
			return;
		System.out.println(n);// Self Work
		PD(n - 1);// SP
	}
}