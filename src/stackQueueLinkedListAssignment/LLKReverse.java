package stackQueueLinkedListAssignment;

public class LLKReverse {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addLast(9);
		ll.addLast(4);
		ll.addLast(1);
		ll.addLast(7);
		ll.addLast(8);
		ll.addLast(3);
		ll.addLast(2);
		ll.addLast(6);
		ll.addLast(5);
		ll.display();
		ll.reverseKList(3);
		System.out.println();
		ll.reverseKGroup(ll.getNode(0), 3);
		ll.display();
	}
}