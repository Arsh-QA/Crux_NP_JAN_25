package binary2DArrayAssignment;

import java.util.Scanner;

public class PaintersPartitionProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int painter = sc.nextInt();
		int nob = sc.nextInt();
		int[] boards = new int[nob];
		for (int i = 0; i < nob; i++) {
			boards[i] = sc.nextInt();
		}
		System.out.println(minimumTime(boards, painter));
		sc.close();
	}

	public static int minimumTime(int[] boards, int painter) {
		int low = 0;
		int high = 0;
		int ans = 0;
		for (int i = 0; i < boards.length; i++) {
//			low = Math.max(low, boards[i]);
			high = high + boards[i];
		}
		while (low <= high) {
			int mid = (low + high) / 2;
			if (isItPossible(boards, mid, painter)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static boolean isItPossible(int[] boards, int maxTime, int painters) {
		int painter = 1;
		int time = 0;
		for (int i = 0; i < boards.length;) {
			if (time + boards[i] <= maxTime) {
				time += boards[i];
				i++;
			} else {
				painter++;
				time = 0;
			}
			if (painter > painters) {
				return false;
			}
		}
		return true;
	}

	/*
	public static boolean isItPossible(int[] boards, int maxTime, int painters) {
		int time = 0;
		int paintersRequired = 1;
		for (int i = 0; i < boards.length; i++) {
			if (time + boards[i] > maxTime) {
				paintersRequired++;
				time = boards[i];
				if (paintersRequired > painters) {
					return false;
				}
			} else {
				time += boards[i];
			}
		}
		return true;
	}
	*/

}