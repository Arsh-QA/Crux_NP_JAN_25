package heapHashMapAssignment;

import java.util.PriorityQueue;
import java.util.Scanner;

public class StringSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
			if (a.startsWith(b) || b.startsWith(a))
				return b.length() - a.length();
			return a.compareTo(b);
		});

		for (int i = 0; i < n; i++) {
			pq.add(sc.next());
		}

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}