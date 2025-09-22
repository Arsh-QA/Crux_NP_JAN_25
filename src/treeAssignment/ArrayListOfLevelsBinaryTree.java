package treeAssignment;

import java.util.*;

public class ArrayListOfLevelsBinaryTree {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayListOfLevelsBinaryTree m = new ArrayListOfLevelsBinaryTree();
		BinaryTree bt1 = m.new BinaryTree();
		System.out.println(bt1.levelArrayList());
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public ArrayList<ArrayList<Integer>> levelArrayList() {
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			if (root == null)
				return result;
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int levelSize = queue.size();
				ArrayList<Integer> currentLevel = new ArrayList<>();

				// Process All Nodes in current level
				for (int i = 0; i < levelSize; i++) {
					Node node = queue.remove();
					currentLevel.add(node.data);

					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				}
				result.add(currentLevel);
			}
			return result;
		}
	}
}