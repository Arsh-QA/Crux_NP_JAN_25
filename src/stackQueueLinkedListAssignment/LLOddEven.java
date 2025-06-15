package stackQueueLinkedListAssignment;

import java.util.Scanner;

public class LLOddEven {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList ll = new LinkedList();
		while (n > 0) {
			ll.addLast(sc.nextInt());
			n--;
		}
		ll.oddEven();
		ll.display();
		sc.close();
	}
}