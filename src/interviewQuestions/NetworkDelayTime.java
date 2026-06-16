package interviewQuestions;

import java.util.*;

public class NetworkDelayTime {

	class Solution {
		public int networkDelayTime(int[][] times, int n, int k) {
			List<List<int[]>> graph = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				graph.add(new ArrayList<>());
			}

			for (int[] time : times) {
				int source = time[0];
				int destination = time[1];
				int weight = time[2];

				graph.get(source).add(new int[] { destination, weight });
			}

			int[] distance = new int[n + 1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[k] = 0;

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

			pq.add(new int[] { k, 0 });

			while (!pq.isEmpty()) {
				int[] current = pq.poll();

				int node = current[0];
				int timeTaken = current[1];

				if (timeTaken > distance[node]) {
					continue;
				}

				for (int[] neighbour : graph.get(node)) {
					int nextNode = neighbour[0];
					int edgeWeight = neighbour[1];

					int newTime = timeTaken + edgeWeight;

					if (newTime < distance[nextNode]) {
						distance[nextNode] = newTime;
						pq.add(new int[] { nextNode, newTime });
					}
				}
			}

			int ans = 0;

			for (int i = 1; i < n; i++) {
				if (distance[i] == Integer.MAX_VALUE) {
					return -1;
				}

				ans = Math.max(ans, distance[i]);
			}

			return ans;
		}
	}
}