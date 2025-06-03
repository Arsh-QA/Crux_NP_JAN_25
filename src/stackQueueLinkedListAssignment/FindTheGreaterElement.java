package stackQueueLinkedListAssignment;

import java.util.Scanner;
import java.util.Stack;

public class FindTheGreaterElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		nextGreater(arr);
		sc.close();
	}

	public static void nextGreater(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!st.isEmpty() && arr[(i + 1) % arr.length] > arr[st.peek()]) {
				ans[st.pop()] = arr[i];
			}
//			while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
//				ans[st.pop()] = arr[i];
//			}
			st.push(i);
		}
		while (!st.isEmpty()) {
			ans[st.pop()] = -1;
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}