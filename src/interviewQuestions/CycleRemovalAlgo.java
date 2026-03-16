package interviewQuestions;

public class CycleRemovalAlgo {

	private class Node {
		int val;
		Node next;

	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public void addLast(int item) {
		Node nn = new Node();
		nn.val = item;
		if (size == 0) {
			head = nn;
			tail = nn;
			size++;
		} else {
			tail.next = nn;
			tail = nn;
			size++;
		}
	}

	private Node getNode(int k) {

		Node temp = head;
		for (int i = 0; i < k; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void CreateCycle() {
		tail.next = getNode(2);
	}

	public Node hasCycle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}

	public void removeCycle() {
		Node meet = hasCycle(head);
		if (meet == null)
			return;
		int count = 1;
		Node temp = meet;
		while (temp.next != meet) {
			count++;
			temp = temp.next;
		}
		Node fast = head;
		for (int i = 0; i < count; i++) {
			fast = fast.next;
		}
		Node slow = head;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
	}

	public void floyedCycleRemoval() {
		Node meet = hasCycle(head);
		if (meet == null)
			return;
		Node slow = head;
		Node fast = meet;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
	}

	public void Display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + "-->");
			temp = temp.next;
		}
		System.out.println(".");

	}

	public static void main(String[] args) {
		CycleRemovalAlgo cl = new CycleRemovalAlgo();
		cl.addLast(10);
		cl.addLast(20);
		cl.addLast(30);
		cl.addLast(40);
		cl.addLast(50);
		cl.addLast(60);
		cl.addLast(70);
		cl.addLast(80);
		cl.CreateCycle();
		cl.Display();
	}

}