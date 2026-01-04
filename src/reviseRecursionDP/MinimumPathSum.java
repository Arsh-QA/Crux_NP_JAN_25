package reviseRecursionDP;

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(pathSum(arr, 0, 0));
	}

	public static int pathSum(int[][] arr, int cr, int cc) {
		if (cr == arr.length - 1 && cc == arr[0].length - 1)
			return arr[cr][cc];
		if (cr >= arr.length || cc >= arr[0].length)
			return Integer.MAX_VALUE;

		int down = pathSum(arr, cr + 1, cc);
		int right = pathSum(arr, cr, cc + 1);

		return Math.min(down, right) + arr[cr][cc];
	}
}