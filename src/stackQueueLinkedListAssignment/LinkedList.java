package stackQueueLinkedListAssignment;

public class LinkedList {

	class Node {
		int val;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public void addFirst(int item) {
		Node nn = new Node();// 0, null
		nn.val = item;// 10, null
		if (size == 0) {
			head = nn;
			tail = nn;
			size++;
		} else {
			nn.next = head;
			head = nn;
			size++;
		}
	}

	// O(1)
	public void addLast(int item) {
		if (size == 0) {
			addFirst(item);
		} else {
			Node nn = new Node();
			nn.val = item;
			tail.next = nn;
			tail = nn;
			size++;
		}
	}

	// O(n)
	public void addAtIndex(int item, int k) {
		if (k == 0)
			addFirst(item);
		else if (k == size)
			addLast(item);
		else {
			Node nn = new Node();// 0, null
			nn.val = item;// 90, null
			Node prev = getNode(k - 1);
			nn.next = prev.next;
			prev.next = nn;
			size++;
		}
	}

	// O(n)
	private Node getNode(int k) {
		Node temp = head;
		for (int i = 0; i < k; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
//		System.out.println(".");
	}

	// O(1)
	public int size() {
		return size;
	}

	// O(1)
	public int getFirst() {
		return head.val;
	}

	// O(1)
	public int getLast() {
		return tail.val;
	}

	// O(n)
	public int getAtIndex(int k) {
		return getNode(k).val;
	}

	// O(1)
	public int removeFirst() {
		Node temp = head;
		if (size == 1) {
			head = null;
			tail = null;
			size = 0;
		} else {
			head = head.next;
			temp.next = null;
			size--;
		}
		return temp.val;
	}

	// O(n)
	public int removeLast() {
		if (size == 1)
			return removeFirst();
		else {
			Node prev = getNode(size - 2);
			int val = tail.val;
			prev.next = null;
			tail = prev;
			size--;
			return val;
		}
	}

	// O(n)
	public int removeAtIndex(int k) {
		if (k == 0)
			return removeFirst();
		else if (k == size - 1)
			return removeLast();
		else {
			Node prev = getNode(k - 1);
			Node curr = prev.next;
			prev.next = curr.next;
			curr.next = null;
			size--;
			return curr.val;
		}
	}

	public Node middleNode() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static boolean hasCycle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public Node reverseList(Node head) {
		return reverse(head, null);
	}

	public Node reverse(Node curr, Node prev) {

		if (curr == null) {
			return prev;
		}

		Node temp = reverse(curr.next, curr);
		curr.next = prev;
		return temp;
	}

	public Node oddEven() {
		Node curr = head;
		Node prev = head;
		Node ahead = prev;
		while (curr.val % 2 == 0) {
			curr = curr.next;
		}
		while (prev.val % 2 != 0) {
			prev = prev.next;
		}
		while (curr != null) {
			if (curr.next.val % 2 == 0) {
				prev.next = curr.next;
			}
		}
		return ahead;

	}

	public Node oddEven2() throws Exception {
		Node curr = head;
		if (curr == null)
			throw new Exception("No element");
		Node ahead = curr.next;
		Node prev = ahead;
		if (size <= 2)
			return head;
		while (curr.next != null && curr.next.next != null) {
			curr.next = curr.next.next;
			curr = curr.next;
			prev.next = curr.next;
			prev = prev.next;
		}
		curr.next = ahead;
		return head;
	}
}