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
		int pop = 0;

		for (int j : arr) {
			if (j == 1) {
				push++;
			} else {
				pop++;
			}
		}
		if (push >= pop)
			return true;
		else
			return false;
	}
}