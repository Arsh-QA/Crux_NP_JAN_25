package reviseLinkedList;

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
}