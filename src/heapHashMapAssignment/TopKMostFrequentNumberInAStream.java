package heapHashMapAssignment;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

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
			topKFrequent(arr, k);
		}
		sc.close();
	}

	private static void topKFrequent(int[] arr, int k) {
//		HashMap<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < arr.length; i++) {
//			if (map.containsKey(arr[i]))
//				map.put(arr[i], map.get(arr[i]) + 1);
//			else
//				map.put(arr[i], 1);
//		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0]);
		System.out.print(pq.peek() + " ");
		for (int i = 1; i < k; i++) {
			if(pq.contains(arr[i])) {
				System.out.print(arr[i] + " ");
				continue;
			}
			pq.add(arr[i]);
		}
		for(int i = 0; i <k; i++) {
			System.out.println();
		}

	}
}