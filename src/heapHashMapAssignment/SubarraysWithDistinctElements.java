package heapHashMapAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarraysWithDistinctElements {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 3 };
		printSubArray(arr);
		System.out.println("*******************************");
//		distintElements(arr);
//		System.out.println("*******************************");

		System.out.println(sumOfLengths(arr));
	}

	public static int sumOfLengths(int[] arr) {
		int n = arr.length;
		final long MOD = 1_000_000_007L;
		long ans = 0;

		Set<Integer> set = new HashSet<>();
		int left = 0;

		for (int right = 0; right < n; right++) {
			// If duplicate found, shrink the window from left
			while (set.contains(arr[right])) {
				set.remove(arr[left]);
				left++;
			}

			set.add(arr[right]);

			long w = right - left + 1;
			long add = (w * (w + 1L) / 2L) % MOD;
			ans = (ans + add) % MOD;
		}

		return (int) ans;
	}

	public static void distintElements(int[] arr) {
//		HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
		ArrayList<ArrayList<Integer>> ll1 = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				ArrayList<Integer> ll = new ArrayList<>();
				for (int k = i; k <= j; k++) {
					ll.add(arr[k]);
				}
				ll1.add(ll);
			}
		}
		System.out.println(ll1);
	}

	public static void printSubArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
//				System.out.println(i + " - " + j);
				for (int k = i; k <= j; k++)
					System.out.print(arr[k] + " ");
				System.out.println();
			}
		}
	}
}