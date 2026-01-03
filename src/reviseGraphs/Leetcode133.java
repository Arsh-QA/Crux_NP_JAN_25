package reviseGraphs;

import java.util.*;

public class Leetcode133 {

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

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;

		Map<Node, Node> map = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();

		// Clone the first node
		map.put(node, new Node(node.val, new ArrayList<>()));
		queue.add(node);

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			for (Node nei : curr.neighbors) {
				if (!map.containsKey(nei)) {
					map.put(nei, new Node(nei.val, new ArrayList<>()));
					queue.add(nei);
				}

				map.get(curr).neighbors.add(map.get(nei));
			}
		}
		return map.get(node);
	}
}