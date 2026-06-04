package interviewQuestions;

import java.util.*;

public class RottingOranges {

	class Solution {
		public int orangesRotting(int[][] grid) {
			int rows = grid.length;
			int cols = grid[0].length;

			Queue<int[]> queue = new LinkedList<>();// each element holds an array with values - {rows, cols, time} time
													// - the minute at which the orange got rotten

			int fresh = 0;// count how many fresh oranges are still left

			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (grid[r][c] == 2) {
						queue.add(new int[] { r, c, 0 });
					} else if (grid[r][c] == 1) {
						fresh++;
					}
				}
			}
			int minutes = 0;// stores the final answer : the maximum time taken to rot an orange

			int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

			while (!queue.isEmpty()) {
				// remove
				int[] current = queue.poll();
				int r = current[0];
				int c = current[1];
				int time = current[2];

				// self work
				minutes = Math.max(minutes, time);

				for (int[] dir : directions) {
					int nr = r + dir[0];
					int nc = c + dir[1];

					// ignore: out of bounds
					if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
						continue;
					}

					// ignore: empty cell or already rotten/visited
					if (grid[nr][nc] != 1) {
						continue;
					}

					// mark visited: rot the fresh orange
					grid[nr][nc] = 2;

					fresh--;

					// add unvisited neighbour
					queue.add(new int[] { nr, nc, time + 1 });
				}
			}

			return fresh == 0 ? minutes : -1;
		}
	}
}