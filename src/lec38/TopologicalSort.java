package lec38;

import java.util.*;

public class TopologicalSort {

	public static void main(String[] args) {
		TopologicalSort ts = new TopologicalSort(8);
		ts.addEdge(1, 2);
		ts.addEdge(1, 0);
		ts.addEdge(1, 4);
		ts.addEdge(4, 3);
		ts.addEdge(3, 2);
		ts.addEdge(4, 5);
		ts.addEdge(5, 7);
		ts.addEdge(6, 3);
		ts.addEdge(6, 7);
		ts.topologicalSort();
		System.out.println(ts.isCycle());
	}

	private HashMap<Integer, List<Integer>> map;

	public TopologicalSort(int v) {
		map = new HashMap<>();
		for (int i = 0; i < v; i++) {
			map.put(i, new ArrayList<>());
		}
	}

	public void addEdge(int v1, int v2) {
		map.get(v1).add(v2);
	}

	public int[] inDegree() {
		int[] in = new int[map.size()];
		for (int v : map.keySet()) {
			for (int nbrs : map.get(v)) {
				in[nbrs]++;
			}
		}
		return in;
	}

	public void topologicalSort() {
		int[] in = inDegree();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < in.length; i++) {
			if (in[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int v = q.poll();
			System.out.print(v + " ");
			for (int nbrs : map.get(v)) {
				in[nbrs]--;
				if (in[nbrs] == 0) {
					q.add(nbrs);
				}
			}
		}
		System.out.println();
	}

	public boolean isCycle() {
		int[] in = inDegree();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < in.length; i++) {
			if (in[i] == 0) {
				q.add(i);
			}
		}
		int c = 0;
		while (!q.isEmpty()) {
			int v = q.poll();
//			System.out.print(v + " ");
			for (int nbrs : map.get(v)) {
				in[nbrs]--;
				if (in[nbrs] == 0) {
					q.add(nbrs);
				}
			}
		}
		return c != map.size();// cycle hai --> true
	}
}