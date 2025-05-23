package lec23_24_revise;

import java.util.Stack;

public class StackReverse {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		System.out.println(st);
		reverse(st);
		System.out.println(st);
	}

	private static void reverse(Stack<Integer> st) {
		if (st.empty()) {
			return;
		}
		int x = st.pop();
		reverse(st);
		insertLast(st, x);
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