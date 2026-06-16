package interviewQuestions;

import java.util.*;

public class CloneGraph {
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	class Solution {
		public Node cloneGraph(Node node) {
			if (node == null) {
				return node;
			}

			Map<Node, Node> visited = new HashMap<>();

			Queue<Node> queue = new LinkedList<>();

			// mark visited
			visited.put(node, new Node(node.val));

			// add starting node
			queue.add(node);

			while (!queue.isEmpty()) {
				// remove
				Node current = queue.poll();

				// self work
				Node currentClone = visited.get(current);

				for (Node nbrs : current.neighbors) {

					// Ignore No need to ignore valid graph neighbors.
					// But if neighbor is not visited, create its clone.
					if (!visited.containsKey(nbrs)) {
						// mark visited
						visited.put(nbrs, new Node(nbrs.val));

						// add unvisited neighbors
						queue.add(nbrs);
					}

					// self/neighbor connection work
					currentClone.neighbors.add(visited.get(nbrs));
				}
			}
			return visited.get(node);
		}
	}
}