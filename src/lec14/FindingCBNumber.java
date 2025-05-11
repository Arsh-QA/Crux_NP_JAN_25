package lec14;

import java.util.Scanner;

public class FindingCBNumber {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int nos = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(ans(arr, nos));
			t--;
		}
	}

	public static int sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}

	public static int ans(int[] arr, int nos) {
		int hi = sum(arr);
		if (nos > arr.length) {
			return arr[arr.length - 1];
		}
		int lo = 0;
		int mid = 0;
		int ans = hi;
		while (lo < hi) {
			mid = (hi + lo) / 2;
			if (possible(arr, nos, mid)) {
				hi = mid;
				ans = mid;
			} else {
				lo = mid + 1;
			}
		}
		return ans;

	}

	public static boolean possible(int[] arr, int nos, int mid) {
		int sum = 0;
		int count = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (count > nos) {
				return false;
			}
			// if (i==0 && sum+arr[i]==mid && count<=nos){
			// return true;
			// }
			if (sum + arr[i] > mid) {
				sum = arr[i];
				count++;
				// System.out.println(i+" "+count+" "+mid);
			} else {
				sum = sum + arr[i];
			}
		}
		if (count <= nos) {
			return true;
		}
		return false;
	}
}