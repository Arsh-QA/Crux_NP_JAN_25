package lec23_revise;

import java.util.Stack;

public class AddLastInStack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.add(10);
		st.add(20);
		st.add(30);
		st.add(40);
		st.add(50);
		System.out.println(st);
		addLast(st, 7);
		System.out.println(st);
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