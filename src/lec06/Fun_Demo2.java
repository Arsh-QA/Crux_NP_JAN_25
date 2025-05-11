package lec06;

public class Fun_Demo2 {

	public static void main(String[] args) {
		System.out.println("Hello");
		int a = 7;
		int b = 9;
		addition(a, b);
		System.out.println(addition(a, b));
		System.out.println("Bye");

	}

	public static int addition(int a, int b) {
		int c = a + b;
		return c;
	}

}
