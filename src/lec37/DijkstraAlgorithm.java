package lec37;

import java.util.*;

import lec37.PrimsAlgorithm.PrimsPair;

public class DijkstraAlgorithm {

	private HashMap<Integer, HashMap<Integer, Integer>> map;

	public DijkstraAlgorithm(int v) {
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	class DijkstraPair {
		int vtx;
		String acqPath;
		int cost;

		public DijkstraPair(int vtx, String acqPath, int cost) {
			this.vtx = vtx;
			this.acqPath = acqPath;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return vtx + " " + acqPath + " @ " + cost;
		}
	}

	public void dijkstraAlgo(int src) {
		PriorityQueue<DijkstraPair> pq = new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(DijkstraPair o1, DijkstraPair o2) {
				return o1.cost - o2.cost;
			};
		});
		HashSet<Integer> visited = new HashSet<>();
		pq.add(new DijkstraPair(src, "" + src, 0));
		while (!pq.isEmpty()) {
			// 1. Remove
			DijkstraPair pr = pq.poll();
			// 2. Ignore if already visited
			if (visited.contains(pr.vtx))
				continue;
			// 3. Marked Visited
			visited.add(pr.vtx);
			// 4. Self Work
			System.out.println(pr);// for sum , sum = sum + pr.cost;
			// 5. Add Unvisited Neighbours
			for (int nbrs : map.get(pr.vtx).keySet()) {
				if (!visited.contains(nbrs)) {
					int cost = map.get(pr.vtx).get(nbrs);
					pq.add(new DijkstraPair(nbrs, pr.acqPath + nbrs, pr.cost + cost));
				}
			}
		}
	}

	public static void main(String[] args) {
		DijkstraAlgorithm da = new DijkstraAlgorithm(7);
		da.addEdge(1, 2, 2);
		da.addEdge(2, 3, 3);
		da.addEdge(1, 4, 10);
		da.addEdge(4, 5, 8);
		da.addEdge(3, 4, 1);
		da.addEdge(5, 6, 5);
		da.addEdge(5, 7, 6);
		da.addEdge(6, 7, 4);
		da.dijkstraAlgo(5);
	}
}