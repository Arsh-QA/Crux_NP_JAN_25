package stackQueueLinkedListAssignment;

import java.util.Scanner;

public class LinkedListKAppend {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = n;
		LinkedList ll = new LinkedList();
		while (n > 0) {
			ll.addLast(sc.nextInt());
			n--;
		}
		int k = sc.nextInt();
		if(k > m) {
			k = k % m;
		}
		ll.kAppend(k);
		ll.display();
		sc.close();
	}
}