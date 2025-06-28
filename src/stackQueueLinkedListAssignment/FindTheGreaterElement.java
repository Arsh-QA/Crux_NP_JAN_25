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
//		int[] arr1 = new int[2 * n];
//		for (int i = 0; i < arr.length; i++) {
//			arr1[i] = arr[i];
//		}
//		for (int i = 0; i < arr.length; i++) {
//			arr1[i + arr.length] = arr[i];
//		}
		nextGreater(arr);
		sc.close();
	}

	public static void nextGreater(int[] arr1) {
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr1.length];
		for (int i = 0; i < 2 * arr1.length; i++) {
			int index = i % arr1.length;
			while (!st.isEmpty() && arr1[index] > arr1[st.peek()]) {
				ans[st.pop()] = arr1[index];
			}
			st.push(index);
		}
		while (!st.isEmpty()) {
			ans[st.pop()] = -1;
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}