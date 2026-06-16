package interviewQuestions;

import java.util.*;

public class MaxAreaOfIsland {

	class Solution {
		public int maxAreaOfIsland(int[][] grid) {
			int rows = grid.length;
			int cols = grid[0].length;

			int maxArea = 0;

			int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (grid[r][c] == 1) {
						int area = 0;

						Queue<int[]> queue = new LinkedList<>();

						// mark visited
						grid[r][c] = 0;

						// add starting land cell
						queue.add(new int[] { r, c });

						while (!queue.isEmpty()) {

							// remove
							int[] current = queue.poll();
							int row = current[0];
							int col = current[1];

							// self work
							area++;

							for (int[] dir : directions) {
								int newRow = row + dir[0];
								int newCol = col + dir[1];

								// ignore out of bounds
								if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
									continue;
								}

								// ignore: water or already visited
								if (grid[newRow][newCol] == 0) {
									continue;
								}

								// mark visited
								grid[newRow][newCol] = 0;

								// add unvisited neighbours
								queue.add(new int[] { newRow, newCol });

							}

						}

						maxArea = Math.max(maxArea, area);
					}
				}
			}
			return maxArea;
		}
	}
}