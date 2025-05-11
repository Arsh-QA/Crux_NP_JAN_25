package lec10;

import java.util.Arrays;

public class AggressiveCows {

	public static void main(String[] args) {
		int[] stall = { 1, 2, 8, 4, 9 };
		int noc = 3;
		Arrays.sort(stall);
		System.out.println(largestMinimum(stall, noc));
	}

	public static int largestMinimum(int[] stall, int noc) {
		int high = stall[stall.length - 1] - stall[0];
		int low = 0;
		int ans = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (isItPossible(stall, noc, mid)) {
				ans = mid;
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return ans;
	}

	public static boolean isItPossible(int[] stall, int noc, int mid) {
		int pos = stall[0];
		int cow = 1;
		for (int i = 1; i < stall.length; i++) {
			if (stall[i] - pos >= mid) {
				cow++;
				pos = stall[i];
			}
			if (cow == noc)
				return true;
		}
		return false;
	}
}