package dpAssignment;

import java.util.*;

public class PalindromePartitioning {
	// Function to return all palindromic partitions of a given string
	public static List<List<String>> partition(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];

		// Precompute dp[i][j] = true if s.substring(i, j+1) is a palindrome
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
				}
			}
		}

		List<List<String>> result = new ArrayList<>();
		backtrack(0, s, new ArrayList<>(), result, dp);
		return result;
	}

	private static void backtrack(int start, String s, List<String> current, List<List<String>> result,
			boolean[][] dp) {
		if (start == s.length()) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (int end = start; end < s.length(); end++) {
			if (dp[start][end]) {
				current.add(s.substring(start, end + 1));
				backtrack(end + 1, s, current, result, dp);
				current.remove(current.size() - 1);
			}
		}

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		List<List<String>> ans = partition(s);

		System.out.print("[");
		for (int i = 0; i < ans.size(); i++) {
			System.out.print("[");
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print("\"" + ans.get(i).get(j) + "\"");
				if (j != ans.get(i).size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
			if (i != ans.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");

		sc.close();
	}
}