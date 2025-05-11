package leetcodeQuestions1;

import java.util.Arrays;

public class KokoEatingBananas {

	public static void main(String[] args) {
		int[] piles = { 332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077,
				337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728,
				941802184 };
		int h = 823855818;
		System.out.println(minEatingSpeed(piles, h));
	}

	public static int minEatingSpeed(int[] piles, int h) {
		int low = 1;
		int sum = 0;
		int ans = -1;
		for (int pile : piles) {
			sum = Math.max(pile, sum);
		}
		int high = sum;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (bananasEaten(mid, piles, h)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static boolean bananasEaten(int mid, int[] piles, int h) {
		int[] copy = new int[piles.length];
		for (int i = 0; i < piles.length; i++) {
			copy[i] = piles[i];
		}
		int hours = 0;
		for (int i = 0; i < copy.length;) {
			if (copy[i] <= mid) {
				hours++;
				i++;
			} else {
				copy[i] -= mid;
				hours++;
			}
			if (hours > h) {
				return false;
			}
		}
		return true;
	}

//	private static int bananasEaten(int bananas, int[] piles) {
//		int count = 0;
//		for (int i = 0; i < piles.length; i++) {
//			if (bananas >= piles[i]) {
//				count++;
//			} else if (bananas < piles[i]) {
//				count++;
//				int diff = piles[i] - bananas;
//				while (bananas < diff) {
//					diff = diff - bananas;
//					count++;
//				}
//				if (diff > 0)
//					count++;
//			}
//		}
//		return count;
//	}
}