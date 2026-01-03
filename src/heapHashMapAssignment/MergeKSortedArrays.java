package heapHashMapAssignment;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				pq.add(sc.nextInt());
			}
		}

		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
		sc.close();
	}
}