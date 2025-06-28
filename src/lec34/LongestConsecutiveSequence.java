package lec34;

import java.util.*;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] arr = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutiveSequence(arr));
	}

	public static int longestConsecutiveSequence(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			int x = arr[i];
			if (!set.contains(x - 1)) {
				int c = 0;
				while (set.contains(x)) {
					c++;
					set.remove(x);
					x++;
				}
				ans = Math.max(ans, c);
			}
		}
		return ans;
	}
}