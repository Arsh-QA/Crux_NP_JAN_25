package reviseOOPS;

// C
public interface StackI {

	public void fun();

	public void push(int item);

	public int pop();

	public int peek();

	public static final int x = 90;

	// Java 8 onwards - static method can have body
	static void f1() {

	}

	// Java 8 onwards - default method can have body
	default void f2() {

	}

	// Java 9 onwards - method can be private
	private void name() {

	}
}