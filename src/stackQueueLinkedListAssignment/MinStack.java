package stackQueueLinkedListAssignment;

import java.util.*;

public class MinStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		MinStack ms = new MinStack();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("push")) {
				ms.push(sc.nextInt());
			} else if (arr[i].equals("pop")) {
				ms.pop();
			} else if (arr[i].equals("top")) {
				System.out.println(ms.top());
			} else if (arr[i].equals("getMin")) {
				System.out.println(ms.getMin());
			}
		}
		sc.close();
	}

	Stack<Integer> mainStack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	public void push(int item) {
		mainStack.push(item);
		if (minStack.isEmpty() || item <= minStack.peek()) {
			minStack.push(item);
		}
	}

	public void pop() {
		int popped = mainStack.pop();
		if (popped == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		return mainStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}