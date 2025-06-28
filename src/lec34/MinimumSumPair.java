package lec34;

import java.util.PriorityQueue;

public class MinimumSumPair {

	public static void main(String[] args) {
		int[] arr = { };
		System.out.println(minimumSum(arr));
	}

	public static int minimumSum(int[] arr) {
		if (arr.length <= 1) {
			return arr.length == 1 ? arr[0] : 0;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		int sum = 0;
		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			sum += (a + b);
			pq.add(a + b);
		}
		return sum;
	}
}