package stackQueueLinkedListAssignment;

public class CycleDetectionAndRemovalLL {

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
//			System.out.println(".");
	}

	public void createCycle() {
		Node nn = getNode(2);
		tail.next = nn;
	}

	public Node hasCycle() {
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

	// O(N^2)
	public void cycleRemove1() {
		Node meet = hasCycle();
		if (meet == null)
			return;
		Node start = head;
		while (start != null) {
			Node temp = meet;
			while (temp.next != meet) {
				if (temp.next == start) {
					temp.next = null;
					return;
				}
				temp = temp.next;
			}
			start = start.next;
		}
	}

	// O(N)
	public void cycleRemove2() {
		Node meet = hasCycle();
		if (meet == null)
			return;
		// count represents cycle length
		int count = 1;
		Node temp = meet;
		while (temp.next != meet) {
			count++;
			temp = temp.next;
		}
		// ek ko m distance chala do pehle
		Node fast = head;
		for (int i = 0; i < count; i++) {
			fast = fast.next;
		}
		Node slow = head;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = null;
	}
	
	// O(N)
		public void floyedCycleRemoval() {
			Node meet = hasCycle();
			if (meet == null)
				return;
			Node slow = head;
			Node fast = meet;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}

	public static void main(String[] args) {
		CycleDetectionAndRemovalLL cy = new CycleDetectionAndRemovalLL();
		cy.addLast(1);
		cy.addLast(2);
		cy.addLast(3);
		cy.addLast(4);
		cy.addLast(5);
		cy.addLast(6);
		cy.addLast(7);
		cy.addLast(8);
		cy.createCycle();
		cy.floyedCycleRemoval();
		cy.display();
	}
}
