package interviewQuestions;

import java.util.*;

public class FindIfPathExistsInGraph {

	class Solution {
		public boolean validPath(int n, int[][] edges, int source, int destination) {
			HashMap<Integer, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				map.put(i, new LinkedList<>());
			}
			for (int i = 0; i < edges.length; i++) {
				int a = edges[i][0];
				int b = edges[i][1];
				map.get(a).add(b);
				map.get(b).add(a);
			}

			return BFT(map, source, destination);
		}

		private boolean BFT(HashMap<Integer, List<Integer>> map, int source, int destination) {

			HashSet<Integer> visited = new HashSet<>();
			Queue<Integer> q = new LinkedList<>();
			q.add(source);
			while (!q.isEmpty()) {
				int rv = q.poll();

				if (visited.contains(rv)) {
					continue;
				}

				visited.add(rv);

				if (rv == destination) {
					return true;
				}

				for (int nbrs : map.get(rv)) {
					if (!visited.contains(nbrs)) {
						q.add(nbrs);
					}
				}
			}
			return false;
		}
	}
}