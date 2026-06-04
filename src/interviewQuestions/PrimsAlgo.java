package interviewQuestions;

import java.util.*;

public class PrimsAlgo {

	HashMap<Integer, HashMap<Integer, Integer>> map;

	public PrimsAlgo(int v) {
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	public int prims() {
		HashSet<Integer> visited = new HashSet<>();
		PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new Comparator<PrimsPair>() {

			@Override
			public int compare(PrimsPair o1, PrimsPair o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});
		int sum = 0;
		pq.add(new PrimsPair(3, 3, 0));
		while (!pq.isEmpty()) {
			PrimsPair rp = pq.poll();
			if (visited.contains(rp.vtx)) {
				continue;
			}
			visited.add(rp.vtx);
			System.out.println(rp);
			sum += rp.cost;
			for (int nbrs : map.get(rp.vtx).keySet()) {
				if (!visited.contains(nbrs)) {
					int cost = map.get(rp.vtx).get(nbrs);
					pq.add(new PrimsPair(nbrs, rp.vtx, cost));
				}
			}
		}
		return sum;
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
			return this.vtx + " " + this.acqVtx + " @ " + this.cost;
		}
	}

	public static void main(String[] args) {
		PrimsAlgo pa = new PrimsAlgo(7);
		pa.addEdge(1, 2, 2);
		pa.addEdge(1, 4, 5);
		pa.addEdge(2, 3, 3);
		pa.addEdge(4, 3, 4);
		pa.addEdge(4, 5, 7);
		pa.addEdge(5, 6, 1);
		pa.addEdge(5, 7, 6);
		pa.addEdge(6, 7, 8);
		System.out.println(pa.prims());
	}

}
