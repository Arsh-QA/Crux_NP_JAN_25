package heapHashMapAssignment;

import java.util.*;

public class UnlockKSwaps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextLong();

		int arr[] = new int[n];

		Map<Integer, Integer> pos = new HashMap<>();

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			pos.put(arr[i], i);
		}

		for (int i = 0; i < n && k > 0; i++) {
			int expected = n - i; // The number we want in this position (largest remaining)
			if (arr[i] != expected) {
				int currentPos = pos.get(expected);

				// Swap arr[i] and arr[currentPos]
				pos.put(arr[i], currentPos);
				pos.put(arr[currentPos], i);

				int temp = arr[i];
				arr[i] = arr[currentPos];
				arr[currentPos] = temp;

				k--;
			}
		}

		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}