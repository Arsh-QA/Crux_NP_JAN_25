package lec13;

public class StringDemo3 {

	public static void main(String[] args) {
		System.out.println("hello" + 10 + 30 + "Bye");
		System.out.println("hello" + (10 + 30) + "Bye");
		System.out.println(10 + 30 + "hello" + "Bye");
		System.out.println("hello" + (10 + 30) + 90 + "Bye");
	}
}