package heapHashMapAssignment;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FindKthLargestNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(findKthLargest(arr, k));
		sc.close();
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			pq.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > pq.peek()) {
				pq.poll();
				pq.add(nums[i]);
			}
		}
		return pq.peek();
	}
}