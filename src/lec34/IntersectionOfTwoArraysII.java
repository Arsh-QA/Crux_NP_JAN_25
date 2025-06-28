package lec34;

import java.util.*;

public class IntersectionOfTwoArraysII {

	public static void main(String[] args) {
		int[] nums1 = { 4, 9, 5 }, nums2 = { 9, 4, 9, 8, 4 };
		int[] ans = intersect(nums1, nums2);
		for (int j : ans) {
			System.out.print(j + " ");
		}
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i]))
				map.put(nums1[i], map.get(nums1[i]) + 1);
			else
				map.put(nums1[i], 1);
		}
		List<Integer> ll = new ArrayList<>();
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				ll.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		int[] arr = new int[ll.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ll.get(i);
		}
		return arr;
	}
}