package lec23;

import java.util.Stack;

public class AddLastInStack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>(); // Implemented by Vector
		// add
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		System.out.println(st);
		addLast(st, 7);
		System.out.println(st);
	}

	// O(n)
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