package stackQueueLinkedListAssignment;

public class SumOfTwoLinkedLists {

	public static void main(String[] args) {
		SumOfTwoLinkedLists sum1 = new SumOfTwoLinkedLists();
		sum1.addFirst(5);
		sum1.addFirst(6);
		sum1.addFirst(3);

		SumOfTwoLinkedLists sum2 = new SumOfTwoLinkedLists();
		sum2.addFirst(8);
		sum2.addFirst(4);
		sum2.addFirst(2);

		Node result = sum1.sumOfLinkedList(sum1.head, sum2.head);
		System.out.println(result.val);

	}

	public class Node {
		int val;
		Node next;

		Node() {
		}

		Node(int val) {
			this.val = val;
		}

		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

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

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
//		System.out.println(".");
	}

	public static Node reverseList(Node head) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		return prev;
	}

	Node start;

	public Node sumOfLinkedList(Node head1, Node head2) {
		Node newHead1 = reverseList(head1);
		Node newHead2 = reverseList(head2);
		int carry = 0;
		int value = 0;

		while (newHead1 != null && newHead2 != null) {
			value = (carry + newHead1.val + newHead2.val) % 10;
			carry = (carry + newHead1.val + newHead2.val) / 10;

			Node obj = new Node(value, null);
			if (start == null)
				start = obj;
			else {
				Node last = getLastNode();
				last.next = obj;
			}
			newHead1 = newHead1.next;
			newHead2 = newHead2.next;
		}

		while (newHead2 != null) {
			value = (carry + newHead2.val) % 10;
			carry = (carry + newHead2.val) / 10;

			Node obj = new Node(value, null);
			if (start == null)
				start = obj;
			else {
				Node last = getLastNode();
				last.next = obj;
			}
			newHead2 = newHead2.next;
		}

		while (newHead1 != null) {
			value = (carry + newHead1.val) % 10;
			carry = (carry + newHead1.val) / 10;

			Node obj = new Node(value, null);
			if (start == null)
				start = obj;
			else {
				Node last = getLastNode();
				last.next = obj;
			}
			newHead1 = newHead1.next;
		}

		if (carry > 0) {
			Node obj = new Node(carry);
			Node last = getLastNode();
			last.next = obj;
		}

		Node list = reverseList(start);

		return list;
	}

	private Node getLastNode() {
		Node temp = start;
		while (temp.next != null) {
			temp = temp.next;
		}
		return null;
	}
}