package stackQueueLinkedListAssignment;

import java.util.*;

public class SumOfTwoLinkedLists2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		SumOfTwoLinkedLists2 one = new SumOfTwoLinkedLists2();
		int i = 0;
		while (i < n) {
			one.addLast(sc.nextInt());
			i++;
		}

		SumOfTwoLinkedLists2 two = new SumOfTwoLinkedLists2();
		int j = 0;
		while (j < m) {
			one.addLast(sc.nextInt());
			j++;
		}

		one.reverse();

		sc.close();
	}

	public void reverse() {
		reverse(head, null);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	private void reverse(Node curr, Node prev) {
		if (curr == null) {
			return;
		}
		reverse(curr.next, curr);
		curr.next = prev;
	}

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		public Node() {

		}
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public void addFirst(int item) {
		Node nn = new Node();
		nn.data = item;
		if (size == 0) {
			head = nn;
			tail = nn;
		} else {
			nn.next = head;
			head = nn;
		}
		size++;
	}

	// O(1)
	public void addLast(int item) {
		if (size == 0) {
			addFirst(item);
		} else {
			Node nn = new Node();
			nn.data = item;
			tail.next = nn;
			tail = nn;
			size++;
		}
	}

	// O(N)
	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.print(".");
		System.out.println();
	}
}