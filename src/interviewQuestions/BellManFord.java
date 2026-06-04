package interviewQuestions;

import java.util.*;

public class BellManFord {

	HashMap<Integer, HashMap<Integer, Integer>> map;

	public BellManFord(int v) {
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
	}

	public void BellManFordAlgo(int src) {
		int v = map.size();
		int[] dist = new int[v + 1];
		for (int i = 1; i < dist.length; i++) {
			dist[i] = 10000_000;
		}
		dist[src] = 0;
		List<EdgePair> ll = allEdge();
		for (int i = 1; i <= v; i++) {
			for (EdgePair e : ll) {
				if (i == v && dist[e.e2] > dist[e.e1] + e.cost) {
					System.out.println("-ve Weight Cycle");
					return;
				}
				if (dist[e.e2] > dist[e.e1] + e.cost) {
					dist[e.e2] = dist[e.e1] + e.cost;
				}
			}
		}

		for (int i = 1; i < dist.length; i++) {
			System.out.print(dist[i] + " ");
		}
	}

	public class EdgePair {
		int e1;
		int e2;
		int cost;

		public EdgePair(int e1, int e2, int cost) {
			this.e1 = e1;
			this.e2 = e2;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return this.e1 + " " + this.e2 + " @ " + this.cost;
		}
	}

	public List<EdgePair> allEdge() {
		List<EdgePair> ll = new ArrayList<>();
		for (int e1 : map.keySet()) {
			for (int e2 : map.get(e1).keySet()) {
				int cost = map.get(e1).get(e2);
				ll.add(new EdgePair(e1, e2, cost));
			}
		}
		return ll;
	}

	public static void main(String[] args) {
		BellManFord bf = new BellManFord(5);
		bf.addEdge(1, 2, 8);
		bf.addEdge(1, 3, 4);
		bf.addEdge(1, 4, 5);
		bf.addEdge(3, 4, -3);
		bf.addEdge(4, 5, 4);
		bf.addEdge(5, 2, 1);
		bf.addEdge(2, 5, -2);
		bf.BellManFordAlgo(1);
	}
}