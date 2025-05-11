package lec06;

public class Fun_Demo {

	public static void main(String[] args) {
		System.out.println("Hello");
		int a = 7;
		int b = 9;
		addition(a, b);
		System.out.println("Bye");
	}

	public static void addition(int a, int b) {
		int c = a + b;
		sub(c, a);
		System.out.println(c);
	}

	public static void sub(int a, int b) {
		int c = a - b;
		System.out.println(c);
	}

	public static void addition() {
		int a = 7;
		int b = 9;
		int c = a + b;
		sub();
		System.out.println(c);
	}

	public static void sub() {
		int a = 7;
		int b = 9;
		int c = a - b;
		System.out.println(c);
	}
}