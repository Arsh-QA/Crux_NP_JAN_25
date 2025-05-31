package lec27;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingLinkedList {

	public static void main(String[] args) {
//		LinkedList<Integer> ll = new LinkedList<>();
		Queue<Integer> ll = new LinkedList<>();
		ll.add(10);// add last --> enqueue
		ll.add(20);
		ll.add(30);
		ll.add(40);
		ll.add(50);
		ll.add(60);
		System.out.println(ll.remove());// remove first --> Dequeue
		System.out.println(ll.poll());// remove first --> Dequeue
		System.out.println(ll.peek());// get first
	}

}
