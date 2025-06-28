package stackQueueLinkedListAssignment;

public class LinkedListKAppend {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		// 1 2 2 1 8 5 6
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(2);
		ll.addLast(1);
		ll.addLast(8);
		ll.addLast(5);
		ll.addLast(6);
		ll.display();
		ll.kAppend(3);
		ll.display();
	}
}