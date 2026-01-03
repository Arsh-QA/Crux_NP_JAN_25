package reviseRecursionDP;

public class Knapsack {

	public static void main(String[] args) {
		int[] wt = { 1, 2, 3, 2, 2 };
		int[] val = { 8, 4, 0, 5, 3 };
		int cap = 4;
		System.out.println(maximumValue(wt, val, cap, 0));
	}

	public static int maximumValue(int[] wt, int[] val, int cap, int i) {
		if (i == wt.length || cap == 0)
			return 0;
		int inc = 0;
		int exc = 0;

		if (cap >= wt[i]) {
			inc = val[i] + maximumValue(wt, val, cap - wt[i], i + 1);
		}

		exc = maximumValue(wt, val, cap, i + 1);
		return Math.max(inc, exc);
	}
}
