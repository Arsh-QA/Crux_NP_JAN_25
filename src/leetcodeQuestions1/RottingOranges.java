package leetcodeQuestions1;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 0 - empty cell
	// 1 - fresh orange
	// 2 - rotten orange

	public static int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0)
			return -1;
		int rows = grid.length;
		int cols = grid[0].length;

		Queue<int[]> queue = new LinkedList<>();
		int freshOranges = 0;

		// Step 1 - Count fresh oranges and enqueue all initial rotten ones
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 2) {
					queue.offer(new int[] { r, c });
				} else if (grid[r][c] == 1) {
					freshOranges++;
				}

			}
		}

		// If no fresh oranges, return 0

		if (freshOranges == 0)
			return 0;

		int minutes = 0;
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		// Step 2 : BFS
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean rottenThisRound = false;

			for (int i = 0; i < size; i++) {
				int[] point = queue.poll();
				int r = point[0];
				int c = point[1];

				for (int[] direction : directions) {
					int newRow = r + direction[0];
					int newCol = c + direction[1];

					// If in bounds and fresh
					if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {

						grid[newRow][newCol] = 2;
						queue.offer(new int[] { newRow, newCol });
						freshOranges--;
						rottenThisRound = true;
					}
				}
			}

			// Increase time only if at least one orange rotten this round
			if (rottenThisRound)
				minutes++;
		}
		return freshOranges == 0 ? minutes : -1;
	}
}
