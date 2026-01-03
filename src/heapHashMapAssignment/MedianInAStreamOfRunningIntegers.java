package heapHashMapAssignment;

import java.util.*;

public class MedianInAStreamOfRunningIntegers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int i = 0;
			while (i < n) {
				arr[i] = sc.nextInt();
				i++;
			}
			PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> high = new PriorityQueue<>();
			int[] arr1 = new int[arr.length];
			for (int j = 0; j < arr.length; j++) {
				if (low.isEmpty() || arr[j] < low.peek()) {
					low.add(arr[j]);
				} else {
					high.add(arr[j]);
				}
				if (low.size() + 1 == high.size()) {
					arr1[j] = high.peek();
				} else if (low.size() == high.size() + 1) {
					arr1[j] = low.peek();
				} else if (low.size() > high.size() + 1) {
					high.add(low.poll());
					arr1[j] = (low.peek() + high.peek()) / 2;
				} else if (low.size() + 1 < high.size()) {
					low.add(high.poll());
					arr1[j] = (low.peek() + high.peek()) / 2;
				} else {
					arr1[j] = (low.peek() + high.peek()) / 2;
				}
			}
			for (int k = 0; k < arr1.length; k++) {
				if (k != arr1.length - 1)
					System.out.print(arr1[k] + " ");
				else
					System.out.println(arr1[k]);
			}
			System.out.println();
		}
		sc.close();
	}
}