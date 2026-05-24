package interviewQuestions;

import java.util.*;

public class DijkstraAlgo {
	private HashMap<Integer, HashMap<Integer, Integer>> map;

	public DijkstraAlgo(int v) {
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	public void dijkstra(int src) {
		HashSet<Integer> visited = new HashSet<>();
		PriorityQueue<DijkstraPair> pq = new PriorityQueue<>(new Comparator<DijkstraPair>() {

			@Override
			public int compare(DijkstraPair o1, DijkstraPair o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});
		pq.add(new DijkstraPair(src, "" + src, 0));
		while (!pq.isEmpty()) {
			DijkstraPair rp = pq.poll();
			if (visited.contains(rp.vtx)) {
				continue;
			}
			visited.add(rp.vtx);
			System.out.println(rp);
			for (int nbrs : map.get(rp.vtx).keySet()) {
				if (!visited.contains(nbrs)) {
					int cost = rp.cost + map.get(rp.vtx).get(nbrs);
					DijkstraPair np = new DijkstraPair(nbrs, rp.path + nbrs, cost);
					pq.add(np);
				}
			}
		}
	}

	class DijkstraPair {
		int vtx;
		String path;
		int cost;

		public DijkstraPair(int vtx, String path, int cost) {
			this.vtx = vtx;
			this.path = path;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return this.vtx + " " + this.path + " @ " + this.cost;
		}
	}

	public static void main(String[] args) {
		DijkstraAlgo dj = new DijkstraAlgo(7);
		dj.addEdge(1, 4, 2);
		dj.addEdge(1, 2, 4);
		dj.addEdge(2, 3, 5);
		dj.addEdge(3, 4, 1);
		dj.addEdge(4, 5, 6);
		dj.addEdge(5, 6, 11);
		dj.addEdge(7, 5, 1);
		dj.addEdge(6, 7, 3);
		dj.dijkstra(1);

	}
}