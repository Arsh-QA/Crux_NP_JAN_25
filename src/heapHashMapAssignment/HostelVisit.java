package heapHashMapAssignment;

import java.util.*;

public class HostelVisit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		int k = sc.nextInt();

		// max-heap : largest element at top
		PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		StringBuilder output = new StringBuilder();

		while (q-- > 0) {
			int type = sc.nextInt();

			if (type == 1) {
				long x = sc.nextLong();
				long y = sc.nextLong();

				long dist = x * x + y * y; // rocket distance

				if (maxHeap.size() < k) {
					maxHeap.add(dist);
				} else if (dist < maxHeap.peek()) {
					maxHeap.poll();
					maxHeap.add(dist);
				}
			} else { // type == 2
				output.append(maxHeap.peek()).append("\n");
			}
		}
		System.out.print(output.toString());
		sc.close();
	}
}