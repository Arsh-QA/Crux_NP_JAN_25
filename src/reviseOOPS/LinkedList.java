package reviseOOPS;

public class LinkedList<T> {
	class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public void addFirst(T item) {
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
	public void addLast(T item) {
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
	public void addAtIndex(T item, int idx) throws Exception {
		if (idx == 0) {
			addFirst(item);
		} else if (idx == size) {
			addLast(item);
		} else {
			Node nn = new Node();
			nn.data = item;
			Node idx_1th = getNode(idx - 1);
			nn.next = idx_1th.next;
			idx_1th.next = nn;
			size++;
		}
	}

	// O(1)
	public T getFirst() {
		return head.data;
	}

	// O(1)
	public T getLast() {
		return tail.data;
	}

	// O(N)
	public T getAtIndex(int idx) throws Exception {
		Node nn = getNode(idx);
		return nn.data;
	}

	// O(1)
	public T removeFirst() {
		T rv = head.data;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node temp = head;
			head = head.next;
			temp.next = null;
		}
		size--;
		return rv;
	}

	// O(N)
	public T removeLast() throws Exception {
		if (size == 1)
			return removeFirst();
		else {
			T rv = tail.data;
			Node sl = getNode(size - 2);
			sl.next = null;
			tail = sl;
			size--;
			return rv;
		}
	}

	// O(N)
	public T removeAtIndex(int idx) throws Exception {
		if (idx == 0)
			return removeFirst();
		else if (idx == size - 1)
			return removeLast();
		else {
			Node prev = getNode(idx - 1);
			Node nn = prev.next;
			T rv = nn.data;
			prev.next = nn.next;
			nn.next = null;
			size--;
			return rv;
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

	private Node getNode(int idx) throws Exception {
		if (idx < 0 || idx > size)
			throw new Exception("Index out of range");
		Node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.addLast("Kaju");
		ll.addLast("Ankit");
		ll.addLast("Ankita");
		ll.addLast("Vishal");
		ll.addLast("Pooja");
		ll.addLast("Anku");
		ll.addLast("Puneet");
		ll.addLast("Anish");
		ll.display();
	}
}