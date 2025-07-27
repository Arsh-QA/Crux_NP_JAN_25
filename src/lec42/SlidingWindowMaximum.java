package lec42;

import java.util.*;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] result = maxSlidingWindow(arr, k);
		System.out.println(Arrays.toString(result));
		for (int i : result)
			System.out.print(i + " ");
	}

	public static int[] maxSlidingWindow(int[] arr, int k) {
		Deque<Integer> q = new LinkedList<>();
		int[] ans = new int[arr.length - k + 1];
		// 1st window
		for (int i = 0; i < k; i++) {
			while (!q.isEmpty() && arr[q.getLast()] < arr[i]) {
				q.removeLast();
			}
			q.add(i);
		}
		int j = 0;// ans wale array ka index track
		ans[j++] = arr[q.getFirst()];

		for (int i = k; i < arr.length; i++) {
			// Grow
			while (!q.isEmpty() && arr[q.getLast()] < arr[i]) {
				q.removeLast();
			}
			q.add(i);

			// Shrink
			if (q.getFirst() == i - k) {
				q.removeFirst();
			}

			// ans calculate
			ans[j++] = arr[q.getFirst()];
		}
		return ans;
	}
}