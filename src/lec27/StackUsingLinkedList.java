package lec27;

import java.util.LinkedList;

public class StackUsingLinkedList {

	private LinkedList<Integer> ll = new LinkedList<>();

	public void push(int item) {
		ll.addFirst(item);
	}

	public int pop() {
		return ll.remove();// remove first
	}

	public int peek() {
		return ll.get(0);
	}

	public int size() {
		return ll.size();
	}

	public void display() {
		System.out.println(ll);
	}

	public boolean isEmpty() {
		return ll.size() == 0;
	}

	public static void main(String[] args) {
		StackUsingLinkedList sl = new StackUsingLinkedList();
		sl.push(10);
		sl.push(20);
		sl.push(30);
		sl.push(40);
		sl.push(50);
		sl.push(60);
		sl.display();
	}

}