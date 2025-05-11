package arrayAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(majorityElement(arr));
		sc.close();
	}

	public static int majorityElement(int[] arr) {
		int ele = arr[0];
		int vote = 1;
		int i = 1;
		while (i < arr.length) {
			if (arr[i] == ele) {
				vote++;
			} else {
				vote--;
				if (vote == 0) {
					ele = arr[i];
					vote = 1;
				}
			}
			i++;
		}
		return ele;
	}
}