package interviewQuestions;

import java.util.*;

public class Graph {

	private HashMap<Integer, HashMap<Integer, Integer>> map;

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
		if (containsEdge(v1, v2)) {
			map.get(v1).remove(v2);
			map.get(v2).remove(v1);
		}
	}

	public void removeVertex(int v1) {
		for (int nbrs : map.get(v1).keySet()) {
			map.get(nbrs).remove(v1);
		}
		map.remove(v1);
	}

	public void display() {
		for (int key : map.keySet()) {
			System.out.println(key + " --> " + map.get(key));
		}
	}

	public boolean hasPath(int src, int dest, HashSet<Integer> visited) {
		if (src == dest) {
			return true;
		}
		visited.add(src);
		for (int nbrs : map.get(src).keySet()) {
			if (!visited.contains(nbrs)) {
				boolean ans = hasPath(nbrs, dest, visited);
				if (ans) {
					return ans;
				}
			}
		}
		visited.remove(src);
		return false;
	}

	public void printAllPath(int src, int dest, HashSet<Integer> visited, String ans) {
		if (src == dest) {
			System.out.println(ans + src);
			return;
		}

		visited.add(src);
		for (int nbrs : map.get(src).keySet()) {
			if (!visited.contains(nbrs)) {
				printAllPath(nbrs, dest, visited, ans + src);
			}
		}
		visited.remove(src);
	}

	public boolean BFS(int src, int dest) {
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		while (!q.isEmpty()) {
			// 1. remove
			int rv = q.poll();
			// 2. ignore if already visited
			if (visited.contains(rv)) {
				continue;
			}
			// 3. visited mark
			visited.add(rv);
			// 4. self work
			if (rv == dest) {
				return true;
			}
			// 5. add unvisited nbrs
			for (int nbrs : map.get(rv).keySet()) {
				if (!visited.contains(nbrs)) {
					q.add(nbrs);
				}
			}
		}
		return false;
	}

	public boolean DFS(int src, int dest) {
		HashSet<Integer> visited = new HashSet<>();
		Stack<Integer> s = new Stack<Integer>();
		s.push(src);
		while (!s.isEmpty()) {
			// 1. remove
			int rv = s.pop();
			// 2. ignore if already visited
			if (visited.contains(rv)) {
				continue;
			}
			// 3. visited mark
			visited.add(rv);
			// 4. self work
			if (rv == dest) {
				return true;
			}
			// 5. add unvisited nbrs
			for (int nbrs : map.get(rv).keySet()) {
				if (!visited.contains(nbrs)) {
					s.push(nbrs);
				}
			}
		}
		return false;
	}

	public void BFT() {

		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int src : map.keySet()) {
			if (visited.contains(src)) {
				continue;
			}
			q.add(src);
			while (!q.isEmpty()) {
				// 1. remove
				int rv = q.poll();
				// 2. ignore if already visited
				if (visited.contains(rv)) {
					continue;
				}
				// 3. visited mark
				visited.add(rv);
				// 4. self work
				System.out.print(rv + " ");
				// 5. add unvisited nbrs
				for (int nbrs : map.get(rv).keySet()) {
					if (!visited.contains(nbrs)) {
						q.add(nbrs);
					}
				}
			}
		}
		System.out.println();
	}

	public void DFT() {
		HashSet<Integer> visited = new HashSet<>();
		Stack<Integer> s = new Stack<Integer>();
		for (int src : map.keySet()) {
			if (visited.contains(src)) {
				continue;
			}
			s.push(src);
			while (!s.isEmpty()) {
				// 1. remove
				int rv = s.pop();
				// 2. ignore if already visited
				if (visited.contains(rv)) {
					continue;
				}
				// 3. visited mark
				visited.add(rv);
				// 4. self work
				System.out.print(rv + " ");
				// 5. add unvisited nbrs
				for (int nbrs : map.get(rv).keySet()) {
					if (!visited.contains(nbrs)) {
						s.push(nbrs);
					}
				}
			}
		}
		System.out.println();
	}
}
