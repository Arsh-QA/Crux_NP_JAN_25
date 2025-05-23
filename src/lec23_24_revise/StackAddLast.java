package lec23_24_revise;

import java.util.Stack;

public class StackAddLast {
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		System.out.println(st);
		insertLast(st, -6);
		System.out.println(st);
	}

	public static void insertLast(Stack<Integer> st, int item) {
		if (st.empty()) {
			st.push(item);
			return;
		}
		int x = st.pop();
		insertLast(st, item);
		st.push(x);
	}
}