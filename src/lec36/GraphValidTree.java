package lec36;

import java.util.*;

public class GraphValidTree {

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		GraphValidTree valid = new GraphValidTree();
		System.out.println(valid.validTree(n, edges));
	}

	public boolean validTree(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			map.get(a).add(b);
			map.get(b).add(a);
		}
		return DFT(map);
	}

	public boolean DFT(HashMap<Integer, List<Integer>> map) {
		Stack<Integer> st = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<>();
		int c = 0;
		for (int src : map.keySet()) {
			if (visited.contains(src))
				continue;
			c++;
			st.push(src);
			while (!st.isEmpty()) {
				// 1. Remove
				int r = st.pop();
				// 2. Ignore if already visited
				if (visited.contains(r)) {
					return false;// tree nhi hai kyunki cycle hai
				}
				// 3. Mark Visited
				visited.add(r);
				// 4. Self Work - No need
				// 5. Add unvisited neighbour
				for (int nbrs : map.get(r)) {
					if (!visited.contains(nbrs)) {
						st.push(nbrs);
					}
				}
			}
		}
		return c == 1;
	}
}