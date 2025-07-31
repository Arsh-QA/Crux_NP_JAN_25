package reviseLinkedList;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {
		LinkedLiist li = new LinkedLiist();
		li.addFirst(10);
		li.addFirst(20);
		li.addFirst(30);
		li.addLast(40);
		li.addLast(42);
		li.addLast(67);
		li.addLast(90);
		li.display();
		System.out.println(li.getNode(2).data);
		li.addAtIndex(li.size() - 1, -20);
		li.display();
		System.out.println(li.removeFirst());
		System.out.println(li.removeLast());
		li.display();
		System.out.println(li.removeAtIndex(2));
		li.display();
//		LinkedList ll = new LinkedList();
//		ll.addFirst(10);
//		ll.addFirst(20);
//		ll.addFirst(30);
//		ll.addLast(40);
//		ll.addAtIndex(-20, 2);
//		ll.addLast(42);
//		ll.addLast(67);
//		ll.addLast(90);
//		ll.display();
//		System.out.println(ll.size());
////		System.out.println(ll.getFirst());
////		System.out.println(ll.getLast());
////		System.out.println(ll.getAtIndex(2));
//		System.out.println(ll.removeFirst());
//		ll.display();
//		System.out.println(ll.removeLast());
//		ll.display();
//		System.out.println(ll.removeAtIndex(2));
//		ll.display();
	}
}