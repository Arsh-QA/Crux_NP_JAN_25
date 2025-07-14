package stackQueueLinkedListAssignment;

import java.util.LinkedList;
import java.util.Scanner;

public class TheQueueGameMonyBhaiya {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			if (isValid(arr))
				System.out.println("Valid");
			else
				System.out.println("Invalid");
		}
	}

	public static boolean isValid(int[] arr) {
		LinkedList<Integer> ll = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				ll.addLast(1);
			} else {
				if (ll.isEmpty())
					return false;
				else
					ll.removeFirst();
			}
		}
		return true;
	}
}