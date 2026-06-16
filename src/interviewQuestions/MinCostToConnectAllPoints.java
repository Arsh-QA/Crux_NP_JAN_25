package interviewQuestions;

import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

	class Solution {
		public int minCostConnectPoints(int[][] points) {
			int n = points.length;

			boolean[] visited = new boolean[n];
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

			pq.add(new int[] { 0, 0 }); // {pointIndex, cost}

			int totalCost = 0;
			int connectedPoints = 0;

			while (connectedPoints < n) {
				int[] current = pq.poll();

				int pointIndex = current[0];
				int cost = current[1];

				if (visited[pointIndex]) {
					continue;
				}

				visited[pointIndex] = true;
				totalCost += cost;
				connectedPoints++;

				for (int next = 0; next < n; next++) {
					if (!visited[next]) {
						int distance = Math.abs(points[pointIndex][0] - points[next][0])
								+ Math.abs(points[pointIndex][1] - points[next][1]);
						pq.add(new int[] { next, distance });
					}
				}
			}

			return totalCost;
		}
	}
}