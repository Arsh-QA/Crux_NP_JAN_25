package arrayAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class TargetSumTriplets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		Arrays.sort(arr);
		targetSumTriplets(arr, target);
		sc.close();
	}

	public static void targetSumTriplets(int[] arr, int target) {
		int i = 0;
		int k = arr.length - 1;
		int j = i + 1;
		while (i < arr.length - 2) {
			while (j < k) {
				if (arr[j] + arr[k] > target - arr[i]) {
					k--;
				} else if (arr[j] + arr[k] < target - arr[i]) {
					j++;
				} else if (arr[j] + arr[k] == target - arr[i]) {
					System.out.println(arr[i] + ", " + arr[j] + " and " + arr[k]);
					j++;
					k--;
				}
			}
			i++;
			j = i + 1;
			k = arr.length - 1;
		}
	}
}