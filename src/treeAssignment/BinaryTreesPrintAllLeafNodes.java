package treeAssignment;

import java.util.*;

public class BinaryTreesPrintAllLeafNodes {

	public static void main(String[] args) {
		BinaryTreesPrintAllLeafNodes ct = new BinaryTreesPrintAllLeafNodes();
		ct.printAllLeafNodes();
	}

	class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}

	private Node root;

	public void printAllLeafNodes() {
		printLeafNodes(root);
	}

	public void printLeafNodes(Node root) {
		if (root.left == null && root.right == null) {
			System.out.print(root.val + " ");
		}
		if (root.left == null || root.right == null)
			return;
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}

	public BinaryTreesPrintAllLeafNodes() {
		createTree();
	}

	private void createTree() {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		Node node = new Node(e);
		root = node;
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
			Node rv = q.poll();// remove first
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			if (c1 != -1) {
				Node nn = new Node(c1);
				rv.left = nn;
				q.add(nn);
			}
			if (c2 != -1) {
				Node nn = new Node(c2);
				rv.right = nn;
				q.add(nn);
			}
		}
		sc.close();
	}
}