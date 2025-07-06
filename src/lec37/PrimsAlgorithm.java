package lec37;

import java.util.*;

public class PrimsAlgorithm {
	private HashMap<Integer, HashMap<Integer, Integer>> map;

	public PrimsAlgorithm(int v) {
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	public void primsAlgo() {
		PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(PrimsPair o1, PrimsPair o2) {
				return o1.cost - o2.cost;
			};
		});
		HashSet<Integer> visited = new HashSet<>();
		pq.add(new PrimsPair(1, 1, 0));
		while (!pq.isEmpty()) {
			// 1. Remove
			PrimsPair pr = pq.poll();
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
					pq.add(new PrimsPair(nbrs, pr.vtx, cost));
				}
			}
		}
	}

	class PrimsPair {
		int vtx;
		int acqVtx;
		int cost;

		public PrimsPair(int vtx, int acqVtx, int cost) {
			this.vtx = vtx;
			this.acqVtx = acqVtx;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return vtx + " " + acqVtx + " @ " + cost;
		}
	}

	public static void main(String[] args) {
		PrimsAlgorithm pa = new PrimsAlgorithm(7);
		pa.addEdge(1, 2, 2);
		pa.addEdge(2, 3, 3);
		pa.addEdge(1, 4, 10);
		pa.addEdge(4, 5, 8);
		pa.addEdge(3, 4, 1);
		pa.addEdge(5, 6, 5);
		pa.addEdge(5, 7, 6);
		pa.addEdge(6, 7, 4);
		pa.primsAlgo();

	}
}