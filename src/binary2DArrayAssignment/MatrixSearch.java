package binary2DArrayAssignment;

public class MatrixSearch {

	public static void main(String[] args) {

	}

	public static int searchMatrix(int[][] matrix, int target) {
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target) {
				return 1;
			} else if (matrix[row][col] > target) {
				col--;
			} else {
				row++;
			}
		}
		return 0;
	}
}