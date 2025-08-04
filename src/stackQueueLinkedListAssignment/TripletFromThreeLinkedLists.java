package stackQueueLinkedListAssignment;

import java.util.Scanner;

public class TripletFromThreeLinkedLists {

	static class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

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

	public void addAtIndex(int idx, int item) throws Exception {
		if (idx == 0)
			addFirst(item);
		else if (idx == size)
			addLast(item);
		else {
			Node nn = new Node();
			nn.data = item;
			Node prev = getNode(idx - 1);
			nn.next = prev.next;
			prev.next = nn;
			size++;
		}
	}

	public int getFirst() {
		return head.data;
	}

	public int getLast() {
		return tail.data;
	}

	public int getAtIndex(int idx) throws Exception {
		return getNode(idx).data;
	}

	public int removeFirst() {
		Node temp = head;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			temp.next = null;
		}
		size--;
		return temp.data;
	}

	public int removeLast() throws Exception {
		if (size == 1) {
			return removeFirst();
		} else {
			Node temp = getNode(size - 2);
			int rv = temp.next.data;
			temp.next = null;
			tail = temp;
			size--;
			return rv;
		}
	}

	public int removeAtIndex(int idx) throws Exception {
		if (idx == 0)
			return removeFirst();
		else if (idx == size - 1)
			return removeLast();
		else {
			Node prev = getNode(idx - 1);
			Node nn = prev.next;
			int rv = nn.data;
			prev.next = nn.next;
			nn.next = null;
			size--;
			return rv;
		}
	}

	public Node getNode(int idx) throws Exception {
		if (idx < 0 || idx >= size) {
			throw new Exception("Index out of bound");
		}
		Node temp = head;
		while (idx > 0) {
			temp = temp.next;
			idx--;
		}
		return temp;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.print(".");
		System.out.println();
	}

	public int size() {
		return size;
	}

	public Node reverseList(Node head) {
		Node prev = null;
		Node curr = head;
		Node ahead = curr;
		while (curr != null) {
			ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		return prev;
	}

	public Node sortList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node mid = middleNode(head);
		Node headB = mid.next;
		mid.next = null;
		Node A = sortList(head);
		Node B = sortList(headB);
		return mergeTwoLists(A, B);
	}

	private Node mergeTwoLists(Node a, Node b) {
		Node dummy = new Node();
		Node temp = dummy;
		while (a != null && b != null) {
			if (b.data < a.data) {
				dummy.next = b;
				b = b.next;
				dummy = dummy.next;
			} else {
				dummy.next = a;
				a = a.next;
				dummy = dummy.next;
			}
		}
		if (a == null) {
			dummy.next = b;
		}
		if (b == null) {
			dummy.next = a;
		}
		return temp.next;
	}

	private Node middleNode(Node head2) {
		Node slow = head2;
		Node fast = head2;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public void findTriple(Node headA, Node headB, Node headC, int target) {
		headB = sortList(headB);
		headC = sortList(headC);

		Node a = headA;

		while (a != null) {
			Node b = headB;
			Node c = getTail(headC);
			while (b != null && c != null) {
				int sum = b.data + c.data;
				if (a.data + sum == target) {
					System.out.println(a.data + " " + b.data + " " + c.data);
					return;
				} else if (a.data + sum < target) {
					b = b.next;
				} else {
					Node temp = headC;
					while (temp.next != c && temp.next != null) {
						temp = temp.next;
					}
					c = temp;
				}
			}
			a = a.next;
		}
	}

	Node getTail(Node head) {
		while (head != null && head.next != null)
			head = head.next;
		return head;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Read sizes
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		TripletFromThreeLinkedLists listA = new TripletFromThreeLinkedLists();
		TripletFromThreeLinkedLists listB = new TripletFromThreeLinkedLists();
		TripletFromThreeLinkedLists listC = new TripletFromThreeLinkedLists();

		// Read three lists
		for (int i = 0; i < n; i++)
			listA.addLast(sc.nextInt());
		for (int i = 0; i < m; i++)
			listB.addLast(sc.nextInt());
		for (int i = 0; i < k; i++)
			listC.addLast(sc.nextInt());

		int target = sc.nextInt();

		TripletFromThreeLinkedLists helper = new TripletFromThreeLinkedLists();

		helper.findTriple(listA.head, listB.head, listC.head, target);

		sc.close();
	}
}