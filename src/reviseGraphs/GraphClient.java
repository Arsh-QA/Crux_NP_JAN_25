package reviseGraphs;

import java.util.HashSet;

public class GraphClient {
	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdge(1, 4, 6);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 4, 5);
		g.addEdge(4, 5, 1);
		g.addEdge(5, 6, 4);
		g.addEdge(7, 5, 2);
		g.addEdge(6, 7, 3);
		g.display();
//		g.removeVertex(4);
//		System.out.println("********************");
//		g.display();
		System.out.println(g.hasPath(1, 6, new HashSet<Integer>()));
		g.printAllPath(1, 6, new HashSet<Integer>(), "");
		System.out.println(g.BFS(1, 6));
		System.out.println(g.DFS(1, 6));

		TraversalGraph tg = new TraversalGraph(7);
		tg.addEdge(1, 4, 6);
		tg.addEdge(1, 2, 10);
		tg.addEdge(2, 3, 7);
		tg.addEdge(3, 4, 5);
		tg.addEdge(4, 5, 1);
		tg.addEdge(5, 6, 4);
		tg.addEdge(7, 5, 2);
		tg.addEdge(6, 7, 3);
		tg.shortestPath(1, 6, "");
		tg.shortestPath1(1, 6);
		tg.shortestPath2(1, 6);
	}
}