package lec37;

import java.util.*;

public class IsGraphBipartite {

	class Solution {
		public boolean isBipartite(int[][] graph) {
			Queue<IsBipartite> q = new LinkedList<>();
			HashMap<Integer, Integer> visited = new HashMap<>();
			for (int i = 0; i < graph.length; i++) {// all vtx
				if (visited.containsKey(i)) {
					continue;
				}
				q.add(new IsBipartite(i, 0));
				// BFS
				while (!q.isEmpty()) {
					// 1. Remove
					IsBipartite bp = q.poll();
					// 2. Ignore if already visited
					if (visited.containsKey(bp.vtx)) {
						if (visited.get(bp.vtx) != bp.dis) {
							return false;
						}
						continue;
					}
					// 3. Marked Visited
					visited.put(bp.vtx, bp.dis);
					// 4. Self Work - No Need
					// 5. Add Unvisited Neighbours
					for (int nbrs : graph[bp.vtx]) {
						if (!visited.containsKey(nbrs)) {
							q.add(new IsBipartite(nbrs, bp.dis + 1));
						}
					}
				}
			}
			return true;
		}
	}

	class IsBipartite {
		int vtx;
		int dis;

		public IsBipartite(int vtx, int dis) {
			this.vtx = vtx;
			this.dis = dis;
		}
	}
}