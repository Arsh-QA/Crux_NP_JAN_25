package lec23_revise;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {

	}

	public static void reverse(Stack<Integer> st) {
		if (st.isEmpty()) {
			return;
		}
		int x = st.pop();
		reverse(st);
		addLast(st, x);
	}

	public static void addLast(Stack<Integer> st, int item) {
		if (st.isEmpty()) {
			st.add(item);
			return;
		}
		int x = st.pop();
		addLast(st, item);
		st.add(x);
	}

}
