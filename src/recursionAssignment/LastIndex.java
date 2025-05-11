package recursionAssignment;

import java.util.Scanner;

public class LastIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		System.out.println(lastIndex(arr, 0, m, -1));
		sc.close();
	}

	public static int lastIndex(int[] arr, int idx, int m, int ans) {
		if (idx == arr.length)
			return ans;
		if (m == arr[idx]) {
			ans = idx;
		}
		return lastIndex(arr, idx + 1, m, ans);
	}
}