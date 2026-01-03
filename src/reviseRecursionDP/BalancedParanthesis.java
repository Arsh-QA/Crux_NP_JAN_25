package reviseRecursionDP;

public class BalancedParanthesis {
	public static void main(String[] args) {
		int n = 3;
		balancedParanthesis(n, 0, 0, "");
	}

	public static void balancedParanthesis(int n, int open, int close, String ans) {
		if (open == n && close == n) {
			System.out.print(ans + " ");
		}
		if (open < n) {
			balancedParanthesis(n, open + 1, close, ans + "(");
		}
		if (close < open) {
			balancedParanthesis(n, open, close + 1, ans + ")");
		}
	}
}