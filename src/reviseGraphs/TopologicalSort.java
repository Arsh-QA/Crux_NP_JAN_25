package reviseGraphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

	public TopologicalSort(int v) {
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2) {
		map.get(v1).put(v2, 0);
	}

	public void topologicalSort() {
		Queue<Integer> qq = new LinkedList<>();
		int[] ind = indegree();
		for (int i = 1; i < ind.length; i++) {
			if (ind[i] == 0) {
				qq.add(i);
			}
		}

		while (!qq.isEmpty()) {
			int front = qq.poll();
			System.out.print(front + " ");

			for (int nbrs : map.get(front).keySet()) {
				ind[nbrs]--;
				if (ind[nbrs] == 0) {
					qq.add(nbrs);
				}
			}
		}
	}

	public int[] indegree() {
		int[] arr = new int[map.size() + 1];
		for (int key : map.keySet()) {

			for (int nbrs : map.get(key).keySet()) {
				arr[nbrs]++;
			}
		}
		return arr;
	}

	public boolean isCycle() {
		Queue<Integer> qq = new LinkedList<>();
		int[] ind = indegree();
		for (int i = 1; i < ind.length; i++) {
			if (ind[i] == 0) {
				qq.add(i);
			}
		}

		int count = 0;

		while (!qq.isEmpty()) {
			int front = qq.poll();
			count++;

			for (int nbrs : map.get(front).keySet()) {
				ind[nbrs]--;
				if (ind[nbrs] == 0) {
					qq.add(nbrs);
				}
			}
		}
		return count != map.size();
	}

	public static void main(String[] args) {
		TopologicalSort ts = new TopologicalSort(7);
		ts.addEdge(1, 2);
		ts.addEdge(1, 4);
		ts.addEdge(4, 3);
		ts.addEdge(3, 2);
		ts.addEdge(4, 5);
		ts.addEdge(5, 7);
		ts.addEdge(6, 3);
		ts.addEdge(6, 7);
//		ts.addEdge(3, 1);
		ts.topologicalSort();
		System.out.println();
		System.out.println(ts.isCycle());
	}
}