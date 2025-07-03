package stackQueueLinkedListAssignment;

import java.util.Scanner;

public class TheQueueGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			if (n == 0)
				System.out.println("Valid");
			else {
				int[] arr = new int[n];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = sc.nextInt();
				}
				if (isValid(arr))
					System.out.println("Valid");
				else
					System.out.println("Invalid");
			}
			t--;
		}
		sc.close();
	}

	public static boolean isValid(int[] arr) {
		int push = 0;

		for (int j : arr) {
			if(push <0)
				return false;
			if (j == 1) {
				push++;
			} else if (j == 0) {
				push--;
			}
		}
		if (push >= 0)
			return true;
		else
			return false;
	}
}