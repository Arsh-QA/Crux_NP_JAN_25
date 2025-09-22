package reviseGraphs;

import java.util.*;

public class TraversalGraph {

	public static void main(String[] args) {
		TraversalGraph tg = new TraversalGraph(7);
		tg.addEdge(1, 4, 6);
		tg.addEdge(1, 2, 10);
		tg.addEdge(2, 3, 7);
		tg.addEdge(3, 4, 5);
		tg.addEdge(4, 5, 1);
		tg.addEdge(5, 6, 4);
		tg.addEdge(7, 5, 2);
		tg.addEdge(6, 7, 3);
		tg.BFT();
		tg.DFT();
	}

	HashMap<Integer, HashMap<Integer, Integer>> map;

	public TraversalGraph(int v) {
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	public void BFT() {
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		for (int key : map.keySet()) {
			if (visited.contains(key)) {
				continue;
			}
			q.add(key);
			while (!q.isEmpty()) {
				// 1. remove
				int rv = q.poll();

				// 2. Ignore if already visited
				if (visited.contains(rv)) {
					continue;
				}

				// 3. Add Visited
				visited.add(rv);

				// 4. Self Work
				System.out.print(rv + " ");

				// 5. Add unvisited nbrs
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
		Stack<Integer> s = new Stack<>();
		HashSet<Integer> visited = new HashSet<>();
		for (int key : map.keySet()) {
			if (visited.contains(key)) {
				continue;
			}
			s.push(key);
			while (!s.isEmpty()) {
				// 1. remove
				int rv = s.pop();

				// 2. Ignore if already visited
				if (visited.contains(rv)) {
					continue;
				}

				// 3. Add Visited
				visited.add(rv);

				// 4. Self Work
				System.out.print(rv + " ");

				// 5. Add unvisited nbrs
				for (int nbrs : map.get(rv).keySet()) {
					if (!visited.contains(nbrs)) {
						s.push(nbrs);
					}
				}
			}
		}
		System.out.println();
	}

	// Using BFS - My code
	public void shortestPath(int src, int dest, String path) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		HashSet<Integer> visited = new HashSet<>();
		while (!q.isEmpty()) {
			// 1. remove
			int rv = q.poll();

			// 2. ignore if already exists
			if (visited.contains(rv))
				continue;

			// 3. visisted add
			visited.add(rv);

			// 4. self work
			if (rv == dest) {
				System.out.println(path + rv);
				return;
			} else {
				path = path + rv;
			}

			// 5. add unvisited nbrs
			for (int nbrs : map.get(rv).keySet()) {
				if (!visited.contains(nbrs)) {
					q.add(nbrs);
				}
			}
		}
	}

	// ChatGPT Code
	class Pair {
		int node;
		String path;

		Pair(int node, String path) {
			this.node = node;
			this.path = path;
		}
	}

	public void shortestPath1(int src, int dest) {
		Queue<Pair> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();

		q.add(new Pair(src, src + " "));

		while (!q.isEmpty()) {
			Pair rv = q.poll();

			if (visited.contains(rv.node))
				continue;

			visited.add(rv.node);

			// Found destination
			if (rv.node == dest) {
				System.out.println("Shortest Path: " + rv.path);
				return;
			}

			// Add unvisited neighbors
			for (int nbr : map.get(rv.node).keySet()) {
				if (!visited.contains(nbr)) {
					q.add(new Pair(nbr, rv.path + nbr + " "));
				}
			}
		}
	}

	// ChatGPT Code - 2 - Queue of Lists (cleaner than strings)
	public void shortestPath2(int src, int dest) {
		Queue<List<Integer>> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();

		q.add(Arrays.asList(src));

		while (!q.isEmpty()) {
			List<Integer> path = q.poll();
			int lastNode = path.get(path.size() - 1);

			if (visited.contains(lastNode))
				continue;

			visited.add(lastNode);

			if (lastNode == dest) {
				System.out.println("Shortest Path: " + path);
				return;
			}

			for (int nbr : map.get(lastNode).keySet()) {
				if (!visited.contains(nbr)) {
					List<Integer> newPath = new ArrayList<>(path);
					newPath.add(nbr);
					q.add(newPath);
				}
			}
		}
	}

	// Monu Bhaiya Code :
	public void shortestPath(int src, int dest) {
		Queue<List<Integer>> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		// Start path from src
		List<Integer> startPath = new ArrayList<>();
		startPath.add(src);
		q.add(startPath);

		while (!q.isEmpty()) {
			// Remove
			List<Integer> path = q.poll();
			int last = path.get(path.size() - 1);

			// If destination reached
			if (last == dest) {
				System.out.println(path);
				return;
			}

			// Ignore if already visited
			if (visited.contains(last))
				continue;
			visited.add(last);

			// Add neighbors with extended path
			for (int nbr : map.get(last).keySet()) {
				if (!visited.contains(nbr)) {
					List<Integer> newPath = new ArrayList<>(path);
					newPath.add(nbr);
					q.add(newPath);
				}
			}
		}
		System.out.println("No path exists!");
	}

}