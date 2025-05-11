package lec15;

public class PrintInc {

	public static void main(String[] args) {
		int n = 5;
		PI(n);
	}

	public static void PI(int n) {
		if (n == 0)// Base Case
			return;
		PI(n - 1);// SP
		System.out.println(n);// Self Work
	}
}