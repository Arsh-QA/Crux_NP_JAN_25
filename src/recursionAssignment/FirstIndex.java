package recursionAssignment;

import java.util.Scanner;

public class FirstIndex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		System.out.println(firstIndex(arr, 0, m));
		sc.close();
	}

	public static int firstIndex(int[] arr, int idx, int m) {
		if (idx == arr.length)
			return -1;
		if (m == arr[idx]) {
			return idx;
		}
		return firstIndex(arr, idx + 1, m);
	}
}