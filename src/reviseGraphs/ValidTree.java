package reviseGraphs;

import java.util.*;

public class ValidTree {
	class Solution {
		public boolean validTree(int n, int[][] edges) {
			HashMap<Integer, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				map.put(i, new ArrayList<>());
			}
			for (int i = 0; i < edges.length; i++) {
				int v1 = edges[i][0];
				int v2 = edges[i][1];
				map.get(v1).add(v2);
				map.get(v2).add(v1);
			}

			Stack<Integer> s = new Stack<>();
			HashSet<Integer> visited = new HashSet<>();
			int count = 0;
			for (int key : map.keySet()) {
				if (visited.contains(key)) {
					continue;
				}
				count++;
				s.push(key);
				while (!s.isEmpty()) {
					// 1. remove
					int rv = s.pop();

					// 2. Ignore if already visited
					if (visited.contains(rv)) {
						return false;
					}

					// 3. Add Visited
					visited.add(rv);

					// 4. Self Work
					// Not required in this case

					// 5. Add unvisited nbrs
					for (int nbrs : map.get(rv)) {
						if (!visited.contains(nbrs)) {
							s.push(nbrs);
						}
					}
				}
			}
			return count == 1;
		}
	}
}
