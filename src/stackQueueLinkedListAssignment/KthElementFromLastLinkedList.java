package stackQueueLinkedListAssignment;

import java.util.Scanner;
import java.util.Stack;

public class KthElementFromLastLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		int n = Integer.MIN_VALUE;
		while (n != -1) {
			ll.addLast(sc.nextInt());
			n = ll.getLast();
		}
		int k = sc.nextInt();
		System.out.println(ll.kthElementFromLast(k));
		sc.close();
	}
}