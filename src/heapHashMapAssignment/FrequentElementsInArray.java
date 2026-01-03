package heapHashMapAssignment;

import java.util.*;

public class FrequentElementsInArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		// Step 1 : Count Frequencies
		Map<Integer, Integer> freq = new HashMap<>();
		for (int x : nums) {
			freq.put(x, freq.getOrDefault(x, 0) + 1);
		}

		// Step 2 : Create Buckets from freq 0..N
		List<Integer>[] bucket = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			bucket[i] = new ArrayList<>();
		}

		for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
			int number = e.getKey();
			int count = e.getValue();
			bucket[count].add(number);
		}

		// Step 3 : Traverse buckets from highest freq downwards
		List<Integer> result = new ArrayList<>();
		for (int i = n; i >= 0 && result.size() < k; i--) {
			if (!bucket[i].isEmpty()) {
				for (int num : bucket[i]) {
					result.add(num);
					if (result.size() == k) {
						break;
					}
				}
			}
		}

		// Step 4 : Final answer must be in sorted order
		Collections.sort(result);

		// Step 5 : Print output
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if (i < result.size() - 1) {
				System.out.print(" ");
			}
		}

		sc.close();
	}
}