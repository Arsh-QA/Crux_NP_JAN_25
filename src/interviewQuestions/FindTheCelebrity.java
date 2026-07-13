package interviewQuestions;

import java.util.Stack;

public class FindTheCelebrity {

	public static void main(String[] args) {

	}

	public static int celebrity(int[][] arr) {
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			st.push(i);
		}

		// Elimination
		while (st.size() > 1) {
			int a = st.pop();
			int b = st.pop();
			if (arr[a][b] == 1) {
				st.push(b);
			} else {
				st.push(a);
			}
		}

		int cand = st.pop();
		for (int i = 0; i < arr.length; i++) {
			if (i == cand)
				continue;
			if (arr[cand][i] != 0 || arr[i][cand] == 0) {
				return -1;
			}
		}
		return cand;
	}
}