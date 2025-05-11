package recursionAssignment;

import java.util.Scanner;

public class SubsetProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ques = new int[n];
		for (int i = 0; i < n; i++) {
			ques[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println("\n" + subsets(ques, target, 0, ""));
		sc.close();
	}

	public static int subsets(int[] ques, int target, int i, String ans) {
		if (i == ques.length) {
			if (target == 0) {
				System.out.print(ans + "  ");
				return 1;
			}
			return 0;
		}

		int c1 = subsets(ques, target - ques[i], i + 1, ans + ques[i] + " ");
		int c2 = subsets(ques, target, i + 1, ans);
		return c1 + c2;
	}
}