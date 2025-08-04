package stackQueueLinkedListAssignment;

import java.util.Scanner;

public class LinkedLiist {

	class Node {
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

	// Add Two LinkedLists
	Node start = null;

	public Node add(Node head1, Node head2) throws Exception {
		Node list1 = reverseList(head1);
		Node list2 = reverseList(head2);
		int sum = 0;
		int carry = 0;
		while (list1 != null && list2 != null) {
			sum = (carry + list1.data + list2.data) % 10;
			carry = (carry + list1.data + list2.data) / 10;
			Node obj = new Node();
			obj.data = sum;
			if (start == null) {
				start = obj;
			} else {
				Node last = getLastNode();
				last.next = obj;
			}
			list1 = list1.next;
			list2 = list2.next;
		}
		while (list2 != null) {
			sum = (carry + list2.data) % 10;
			carry = (carry + list2.data) / 10;
			Node obj = new Node();
			obj.data = sum;
			if (start == null) {
				start = obj;
			} else {
				Node last = getLastNode();
				last.next = obj;
			}
			list2 = list2.next;
		}
		while (list1 != null) {
			sum = (carry + list1.data) % 10;
			carry = (carry + list1.data) / 10;
			Node obj = new Node();
			obj.data = sum;
			if (start == null) {
				start = obj;
			} else {
				Node last = getLastNode();
				last.next = obj;
			}
			list1 = list1.next;
		}

		if (carry > 0) {
			Node obj = new Node();
			obj.data = carry;
			Node last = getLastNode();
			last.next = obj;
		}
		Node headdd = reverseList(start);
		return headdd;
	}

	private Node getLastNode() {
		Node temp = start;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	public static void main(String[] args) throws Exception {
		LinkedLiist ll1 = new LinkedLiist();
		LinkedLiist ll2 = new LinkedLiist();

		Scanner sc = new Scanner(System.in);
		int l1 = sc.nextInt();
		int l2 = sc.nextInt();
		
		for (int i = 0; i < l1; i++) {
			ll1.addLast(sc.nextInt());
		}
		
		for (int i = 0; i < l2; i++) {
			ll2.addLast(sc.nextInt());
		}

		LinkedLiist result = new LinkedLiist();
		Node resHead = result.add(ll1.head, ll2.head);
		Node temp = resHead;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		sc.close();
	}

}