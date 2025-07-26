package lec39_revise;

public class Fibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int fibo(int n) {
		if (n <= 1) {
			return n;
		}
		int f1 = fibo(n - 1);
		int f2 = fibo(n - 2);
		return f1 + f2;
	}
}