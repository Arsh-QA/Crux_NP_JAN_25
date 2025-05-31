package lec23;

import java.util.Stack;

public class StackJava {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>(); // Implemented by Vector
		// add
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);

		System.out.println(st);

		// get only top element
		System.out.println(st.peek());

		// remove
		System.out.println(st.pop());

		// size
		System.out.println(st.size());

		// empty or not
		System.out.println(st.isEmpty());

		// display
		for (int v : st) {
			System.out.print(v + " ");
		}
	}
}