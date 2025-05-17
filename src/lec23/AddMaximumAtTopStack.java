package lec23;

import java.util.Stack;

public class AddMaximumAtTopStack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>(); // Implemented by Vector
		st.push(10);
		st.push(20);
		st.push(50);
		st.push(30);
		st.push(40);
		System.out.println(st);
		addMaximumAtTop(st);
		System.out.println(st);
	}

	private static void addMaximumAtTop(Stack<Integer> st) {
		Stack<Integer> maxStack = new Stack<>();
		int max = Integer.MIN_VALUE;
		for (int v : st) {
			if (v > max) {
				max = v;
			}
		}
		while (!st.isEmpty()) {
			maxStack.add(st.pop());
		}
		while (!maxStack.isEmpty()) {
			if (maxStack.peek() != max) {
				st.add(maxStack.pop());
			} else
				maxStack.pop();
		}
		st.add(max);
	}
}