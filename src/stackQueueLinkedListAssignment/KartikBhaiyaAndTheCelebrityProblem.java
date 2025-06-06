package stackQueueLinkedListAssignment;

import java.util.Scanner;
import java.util.Stack;

public class KartikBhaiyaAndTheCelebrityProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		if (celebrity(arr) == -1) {
			System.out.println("No Celebrity");
		} else
			System.out.println(celebrity(arr));
		sc.close();
	}

	private static int celebrity(int[][] arr) {
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			st.push(i);
		}
		while (st.size() > 1) {
			int a = st.pop();
			int b = st.pop();
			if (arr[a][b] == 1) {
				st.push(b);
			} else {
				st.push(a);
			}
		}
		int candidate = st.pop();
		for (int i = 0; i < arr.length; i++) {
			if (i == candidate) {
				continue;
			}
			if (arr[candidate][i] == 1 || arr[i][candidate] == 0) {
				return -1;
			}
		}
		return candidate;
	}
}