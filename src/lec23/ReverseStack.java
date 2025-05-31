package lec23;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>(); // Implemented by Vector
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		System.out.println(st);
		reverse(st);
		System.out.println(st);
	}

	// O(n^2)
	private static void reverse(Stack<Integer> st) {
		if (st.isEmpty()) {
			return;
		}
		int x = st.pop();
		reverse(st);
		addLast(st, x);
	}

	private static void addLast(Stack<Integer> st, int item) {
		if (st.isEmpty()) {
			st.push(item);
			return;
		}
		int x = st.pop();
		addLast(st, item);
		st.push(x);
	}

}
