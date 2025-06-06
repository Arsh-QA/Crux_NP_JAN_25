package stackQueueLinkedListAssignment;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStack {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		QueueUsingStack q = new QueueUsingStack();
		for (int i = 0; i < n; i++) {
			q.enqueue(i);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(q.dequeue() + " ");
		}
		sc.close();
	}

	Stack<Integer> st1 = new Stack<>();
	Stack<Integer> st2 = new Stack<>();

	public boolean isEmpty() {
		return st1.isEmpty() && st2.isEmpty();
	}

	public void enqueue(int x) {
		st1.push(x);
	}

	public int dequeue() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is empty");

		if (st2.isEmpty()) {
			while (!st1.isEmpty()) {
				st2.push(st1.pop());
			}
		}
		return st2.pop();
	}

	public int peek() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is empty");

		if (st2.isEmpty()) {
			while (!st1.isEmpty()) {
				st2.push(st1.pop());
			}
		}
		return st2.peek();
	}
}