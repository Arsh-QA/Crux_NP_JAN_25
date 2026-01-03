package heapHashMapAssignment;

import java.util.*;

public class TopKMostFrequentNumberInAStream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			Map<Integer, Integer> freq = new HashMap<>();

			for (int i = 0; i < n; i++) {
				int num = arr[i];
				freq.put(num, freq.getOrDefault(num, 0) + 1);

				// Define Priority Queue based on frequence and value
				PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
					if (freq.get(a).equals(freq.get(b)))
						return a - b;
					return freq.get(b) - freq.get(a);
				});
				pq.addAll(freq.keySet());

				int count = 0;
				List<Integer> top = new ArrayList<>();
				while (!pq.isEmpty() && count < k) {
					top.add(pq.poll());
					count++;
				}

				// Print top k (or less if distinct < k)
				for (int val : top) {
					System.out.print(val + " ");
				}
			}
			System.out.println();
		}
		sc.close();
	}
}