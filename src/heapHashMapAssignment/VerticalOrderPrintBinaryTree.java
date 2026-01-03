package heapHashMapAssignment;

import java.util.*;

public class VerticalOrderPrintBinaryTree {

	static class Node {
		int val;
		Node left, right;

		Node(int v) {
			val = v;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // Number of levels
		int total = (1 << n) - 1; // Total elements in level order

		int[] arr = new int[total];
		for (int i = 0; i < total; i++) {
			arr[i] = sc.nextInt();
		}

		Node root = buildTree(arr);
		verticalTraversal(root);

		sc.close();

	}

	static Node buildTree(int[] arr) {
		if (arr.length == 0 || arr[0] == -1) {
			return null;
		}

		Node root = new Node(arr[0]);
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		int idx = 1;

		while (!q.isEmpty() && idx < arr.length) {
			Node curr = q.poll();

			// Left Child
			if (idx < arr.length && arr[idx] != -1) {
				curr.left = new Node(arr[idx]);
				q.add(curr.left);
			}

			idx++;

			// Right Child
			if (idx < arr.length && arr[idx] != -1) {
				curr.right = new Node(arr[idx]);
				q.add(curr.right);
			}

			idx++;
		}

		return root;
	}

	// Vertical Traversal
	static void verticalTraversal(Node root) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();

		Queue<Node> nodeQ = new LinkedList<>();
		Queue<Integer> hdQ = new LinkedList<>();

		nodeQ.add(root);
		hdQ.add(0);

		while (!nodeQ.isEmpty()) {
			Node curr = nodeQ.poll();
			int hd = hdQ.poll();

			map.putIfAbsent(hd, new ArrayList<>());
			map.get(hd).add(curr.val);

			if (curr.left != null) {
				nodeQ.add(curr.left);
				hdQ.add(hd - 1);
			}

			if (curr.right != null) {
				nodeQ.add(curr.right);
				hdQ.add(hd + 1);
			}
		}

		// Print all colums left -> right
		for (int hd : map.keySet()) {
			for (int val : map.get(hd)) {
				System.out.print(val + " ");
			}
		}
	}
}