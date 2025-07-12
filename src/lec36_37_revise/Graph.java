package lec36_37_revise;

import java.util.*;

public class Graph {

	HashMap<Integer, HashMap<Integer, Integer>> map;

	public Graph(int v) {
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	public void addVertex(int v) {
		map.put(v, new HashMap<>());
	}

	public boolean containsEdge(int v1, int v2) {
		return map.get(v1).containsKey(v2);
	}

	public boolean containsVertex(int v1) {
		return map.containsKey(v1);
	}

	public int noOfEdge() {
		int sum = 0;
		for (int key : map.keySet()) {
			sum += map.get(key).size();
		}
		return sum / 2;
	}

	public void removeEdge(int v1, int v2) {
		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}

	public void removeVertex(int v) {
		for (int nbrs : map.get(v).keySet()) {
			map.get(nbrs).remove(v);
		}
		map.remove(v);
	}

	public void display() {
		for (int key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
	}

	public boolean hasPath(int src, int des, HashSet<Integer> visited) {
		if (src == des) {
			return true;
		}
		visited.add(src);
		for (int nbrs : map.get(src).keySet()) {
			if (!visited.contains(nbrs)) {
				boolean ans = hasPath(nbrs, des, visited);
				if (ans) {
					return ans;
				}
			}
		}
		return false;
	}

	public void printAllPath(int src, int des, HashSet<Integer> visited, String ans) {
		if (src == des) {
			System.out.println(ans + des);
			return;
		}
		visited.add(src);
		for (int nbrs : map.get(src).keySet()) {
			if (!visited.contains(nbrs)) {
				printAllPath(nbrs, des, visited, ans + src);
			}
		}
		visited.remove(src);
	}

	public boolean BFS(int src, int des) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		HashSet<Integer> visited = new HashSet<>();
		while (!q.isEmpty()) {
			// 1. Remove
			int rv = q.poll();

			// 2. Ignore if already visited
			if (visited.contains(rv))
				continue;

			// 3. Add visited
			visited.add(rv);

			// 4. Self Work
			if (rv == des)
				return true;

			// 5. Add unvisited nbrs(neighbours)
			for (int nbrs : map.get(rv).keySet()) {
				if (!visited.contains(nbrs))
					q.add(nbrs);
			}
		}
		return false;
	}

	public boolean DFS(int src, int des) {
		Stack<Integer> st = new Stack<>();
		st.add(src);
		HashSet<Integer> visited = new HashSet<>();
		while (!st.isEmpty()) {
			// 1. Remove
			int rv = st.pop();

			// 2. Ignore if already visited
			if (visited.contains(rv))
				continue;

			// 3. Add visited
			visited.add(rv);

			// 4. Self Work
			if (rv == des)
				return true;

			// 5. Add unvisited nbrs(neighbours)
			for (int nbrs : map.get(rv).keySet()) {
				if (!visited.contains(nbrs))
					st.push(nbrs);
			}
		}
		return false;
	}
}