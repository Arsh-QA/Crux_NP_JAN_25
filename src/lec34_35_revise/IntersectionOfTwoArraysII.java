package lec34_35_revise;

import java.util.*;

public class IntersectionOfTwoArraysII {

	public static void main(String[] args) {
		int[] arr1 = { 4, 9, 5 };
		int[] arr2 = { 9, 4, 9, 8, 4 };
		int[] a = intersect(arr1, arr2);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static int[] intersect(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			if (map.containsKey(arr1[i])) {
				map.put(arr1[i], map.get(arr1[i]) + 1);
			} else {
				map.put(arr1[i], 1);
			}
		}

		List<Integer> ll = new ArrayList<>();
		for (int i = 0; i < arr2.length; i++) {
			if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
				ll.add(arr2[i]);
				map.put(arr2[i], map.get(arr2[i]) - 1);
			}
		}

		int[] ans = new int[ll.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = ll.get(i);
		}

		return ans;
	}
}