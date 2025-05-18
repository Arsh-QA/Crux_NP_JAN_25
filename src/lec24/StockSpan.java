package lec24;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
//		int[] arr = { 4, 5, 2, 10 };
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		calculateSpan(arr);
		sc.close();
	}

	public static void calculateSpan(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
				st.pop();
			}
			// calculate span
			if (!st.isEmpty()) {
				ans[i] = i - st.peek();
			} else {
				ans[i] = i + 1;
			}
			st.push(i);
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}