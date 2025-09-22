package stackQueueLinkedListAssignment;

import java.util.*;

public class LLKReverse {

	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public Node() {

		}
	}

	private Node head;
	private Node tail;
	private int size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		LLKReverse ll = new LLKReverse();

		for (int i = 0; i < n; i++) {
			ll.addLast(sc.nextInt());
		}

		ll.reverse(k);
		ll.display();
	}

	private void reverse(int k) {
		Node curr = this.head;
		Node dummy = new Node();
		Node temp = dummy;
		Stack<Node> st = new Stack<>();
		while (curr != null) {
			Node node = new Node();
			node.data = curr.data;
			st.push(node);
			if (st.size() == k) {
				while (!st.isEmpty()) {
					dummy.next = st.pop();
					dummy = dummy.next;
				}
			}
			curr = curr.next;
		}
		while (!st.isEmpty()) {
			dummy.next = st.pop();
			dummy = dummy.next;
		}
		this.head = temp.next;
		this.tail = dummy;
	}

	public int size() {
		return this.size;
	}

	// O(1)
	public void addLast(int item) {
		Node node = new Node(item, null);
		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	// O(N)
	public void display() {
		Node node = this.head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}