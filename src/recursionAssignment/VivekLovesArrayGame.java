package recursionAssignment;

import java.util.Scanner;

public class VivekLovesArrayGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(arrayGame(arr, 0, arr.length - 1));
			t--;
		}
		sc.close();
	}

	public static int arrayGame(int[] arr, int begIdx, int endIdx) {
		if (begIdx >= endIdx) {
			return 0;
		}
		for (int i = begIdx; i <= endIdx; i++) {
			if (divide(arr, begIdx, endIdx, i) != -1) {
				return 1 + Math.max(arrayGame(arr, begIdx, i), arrayGame(arr, i + 1, endIdx));
			}
		}
		return 0;
	}

	public static int divide(int[] arr, int begIdx, int endIdx, int idx) {
		int sumLeft = 0;
		for (int i = begIdx; i <= idx; i++) {
			sumLeft += arr[i];
		}

		int sumRight = 0;
		for (int i = idx + 1; i <= endIdx; i++) {
			sumRight += arr[i];
		}

		if (sumLeft == sumRight)
			return idx;
		return -1;
	}
}