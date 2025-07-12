package lec38;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BellmanFord {

	public static void main(String[] args) {
		BellmanFord bf = new BellmanFord(5);
		bf.addEdge(1, 2, 8);
		bf.addEdge(1, 3, 4);
		bf.addEdge(1, 4, 5);
		bf.addEdge(3, 4, -3);
		bf.addEdge(4, 5, 4);
		bf.addEdge(5, 2, 1);
		bf.addEdge(2, 5, -2);
		bf.BellManAlgo();

	}

	private HashMap<Integer, HashMap<Integer, Integer>> map;

	public BellmanFord(int v) {
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
	}

	class EdgePair {
		int e1, e2, cost;

		public EdgePair(int e1, int e2, int cost) {
			this.e1 = e1;
			this.e2 = e2;
			this.cost = cost;
		}
	}

	// O(N^2)
	public List<EdgePair> getAllEdge() {
		List<EdgePair> ll = new ArrayList<>();
		for (int e1 : map.keySet()) {
			for (int e2 : map.get(e1).keySet()) {
				int cost = map.get(e1).get(e2);
				ll.add(new EdgePair(e1, e2, cost));
			}
		}
		return ll;
	}

	//	O(N^2)
	public void BellManAlgo() {
		List<EdgePair> ll = getAllEdge();
		int v = map.size();
		int[] dis = new int[v + 1];
		// src = 1
		for (int i = 2; i < dis.length; i++) {
			dis[i] = 567899;
		}
		for (int i = 1; i <= v; i++) {
			for (EdgePair e : ll) {
				if (i == v && (dis[e.e2] > dis[e.e1] + e.cost)) {
					System.out.println("Negative Weight ka Cycle hai");
					return;
				}
				if (dis[e.e2] > dis[e.e1] + e.cost) {
					dis[e.e2] = dis[e.e1] + e.cost;
				}
			}
		}
		for (int i = 1; i < dis.length; i++) {
			System.out.print(dis[i] + " ");
		}
	}
}
