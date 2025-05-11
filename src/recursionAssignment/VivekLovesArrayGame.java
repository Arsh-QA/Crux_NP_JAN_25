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
//			System.out.println(divideEqualArray(arr, 0, arr.length - 1));
			for (int i = 0; i < arr.length; i++) {
				System.out.println(divideEqualArray(arr, i));
			}
//			 int points = arrayGame(arr, 0, arr.length - 1);
//			System.out.println(points);
			t--;
		}
		sc.close();
	}

	public static void arrayGame(int[] arr, int begIdx, int endIdx) {
		
		for (int i = begIdx; i < endIdx; i++) {
			int idx = divideEqualArray(arr, begIdx);
			if (idx != -1) {
				arrayGame(arr, begIdx, idx);
				arrayGame(arr, idx + 1, endIdx);
			}
		}
	}

	public static int divideEqualArray(int[] arr, int idx) {
		int sum1 = 0;
		for (int i = 0; i <= idx; i++) {
			sum1 += arr[i];
		}
		int sum2 = 0;
		for (int i = idx + 1; i < arr.length; i++) {
			sum2 += arr[i];
		}
		if (sum1 == sum2) {
			return idx;
		} else {
			return -1;
		}
	}
}