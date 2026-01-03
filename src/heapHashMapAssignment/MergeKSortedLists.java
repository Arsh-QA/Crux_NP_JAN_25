package heapHashMapAssignment;

import java.util.*;

public class MergeKSortedLists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int N = sc.nextInt();

		int total = K * N;

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		// Read all numbers and push into min-heap
		for (int i = 0; i < total; i++) {
			minHeap.offer(sc.nextInt());
		}

		// Output in sorted order
		StringBuilder sb = new StringBuilder();
		while (!minHeap.isEmpty()) {
			sb.append(minHeap.poll()).append(" ");
		}

		System.out.println(sb.toString().trim());
	}
}