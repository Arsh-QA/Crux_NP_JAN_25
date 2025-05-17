package lec20;

public class SudokuSolver {

	public static void main(String[] args) {
		int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		int[][] grid1 = { { 3, 0, 4, 0, 8, 0, 2, 0, 6 }, { 0, 0, 9, 5, 0, 0, 0, 0, 0 }, { 6, 0, 0, 4, 0, 0, 0, 3, 9 },
				{ 0, 0, 0, 0, 0, 0, 8, 5, 0 }, { 5, 0, 0, 0, 0, 0, 0, 0, 7 }, { 0, 6, 7, 0, 0, 0, 0, 0, 0 },
				{ 4, 8, 0, 0, 0, 2, 0, 0, 5 }, { 0, 0, 0, 0, 0, 3, 9, 0, 0 }, { 1, 0, 5, 0, 4, 0, 7, 0, 3 } };

		print(grid1, 0, 0);
		for (int i = 0; i < grid1.length; i++) {
			for (int j = 0; j < grid1.length; j++) {
				System.out.print(grid1[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean print(int[][] grid, int row, int col) {
		if (col == 9) {
			row++;
			col = 0;
		}
		if (row == 9) {
			return true;
		}
		if (grid[row][col] != 0) {
			return print(grid, row, col + 1);
		} else {
			for (int val = 1; val <= 9; val++) {
				if (isItSafe(grid, row, col, val)) {
					grid[row][col] = val;
					boolean ans = print(grid, row, col + 1);
					if (ans) {
						return ans;
					}
					grid[row][col] = 0;
				}
			}
		}
		return false;
	}

	public static boolean isItSafe(int[][] grid, int row, int col, int val) {
		// row
		for (int c = 0; c < grid.length; c++) {
			if (grid[row][c] == val)
				return false;
		}

		// column
		for (int r = 0; r < grid.length; r++) {
			if (grid[r][col] == val)
				return false;
		}

		// 3X3 Matrix
		int r = row - row % 3;
		int c = col - col % 3;
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (grid[i][j] == val) {
					return false;
				}
			}
		}
		return true;
	}
}