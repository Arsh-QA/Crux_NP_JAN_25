package interviewQuestions;

import java.util.*;

public class NumberOfIslands {

	class Solution {
		public int numIslands(char[][] grid) {
			int rows = grid.length;
			int cols = grid[0].length;

			int count = 0;
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (grid[r][c] == '1') {
						
						count++;

						bfs(grid, r, c);
					}
				}
			}

			return count;
		}

		public void bfs(char[][] grid, int sr, int sc) {
			Queue<int[]> q = new LinkedList<>();

			q.add(new int[] { sr, sc });

			// Mark visited immediately
			grid[sr][sc] = '0';

			int[][] dirs = {
					{-1, 0},
					{1, 0},
					{0, -1},
					{0, 1}
			};
			
			while (!q.isEmpty()) {
				int[] rv = q.poll();

				int r = rv[0];
				int c = rv[1];

				for (int[] d : dirs) {
					int nr = r + d[0];
					int nc = c + d[1];

					if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
						q.add(new int[] { nr, nc });

						// Mark Visited while adding
						grid[nr][nc] = '0';
					}
				}
			}
		}
	}
}