package binary2DArrayAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class MurthalPrantha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int noc = sc.nextInt();
		int[] rank = new int[noc];
		for (int i = 0; i < noc; i++) {
			rank[i] = sc.nextInt();
		}
		Arrays.sort(rank);
		System.out.println(minutesRequired(n, rank));
		sc.close();
	}

	public static int minutesRequired(int n, int[] rank) {
		int highestRank = rank[rank.length - 1];
		int low = 0;
		int high = highestRank * (n * (n + 1) / 2);
		int ans = 0;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (paranthasMadeChatGPT(mid, rank) < n) {
				low = mid + 1;
			} else {
				ans = mid;
				high = mid - 1;
			}
		}
		return ans;
	}

	public static int paranthasMade(int mid, int[] rank) {
		int totalCount = 0;
		for (int i = 0; i < rank.length; i++) {
			int time = 0;
			int count = 0;
			while (time <= mid) {
				count = count + 1;
				if (time + count * rank[i] > mid)
					break;
				else
					time = time + count * rank[i];
			}
			count--;
			totalCount += count;
		}
		return totalCount;
	}

	public static int paranthasMadeChatGPT(int mid, int[] rank) {
		int totalCount = 0;
		for (int r : rank) {
			// Solve k(k+1)/2 * r <= mid for k
			int left = 0, right = (int) Math.sqrt(2 * mid / r);
			while (left <= right) {
				int k = (left + right) / 2;
				if (k * (k + 1) / 2 * r <= mid) {
					left = k + 1; // Try for a higher value of k
				} else {
					right = k - 1; // Reduce k
				}
			}
			totalCount += right; // Right will be the max k that satisfies the condition
		}
		return totalCount;
	}
}