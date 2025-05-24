package lec25;

public class Addition {// Method Overloading

	public static void main(String[] args) {
		System.out.println(add(2, 7));
		System.out.println(add(2, 7, 9));
		System.out.println(add(2, 7, 9.6));
		System.out.println(add(2, 7, 1, 2, 1, 2, 34, 3, 134, 98493));
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static int add(int a, int b, int c) {
		return a + b + c;
	}

	public static int add(int a, int b, double c) {
		return (int) (a + b + c);
	}

	public static int add(int x, int... a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
}