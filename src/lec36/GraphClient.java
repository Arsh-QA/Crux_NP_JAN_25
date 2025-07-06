package lec36;

import java.util.HashSet;

public class GraphClient {
	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 4, 7);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 6);
		g.addEdge(5, 4, 2);
		g.addEdge(5, 6, 4);
		g.addEdge(5, 7, 3);
		g.addEdge(6, 7, 1);
		g.display();
		System.out.println(g.hasPath(1, 6, new HashSet<>()));
		g.printPath(1, 6, new HashSet<>(), "");
		System.out.println(g.BFS(1, 6));
		System.out.println(g.DFS(1, 6));
		g.BFT();
		g.DFT();
	}
}