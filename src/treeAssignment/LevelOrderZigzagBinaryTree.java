package treeAssignment;

import java.util.*;

public class LevelOrderZigzagBinaryTree {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		LevelOrderZigzagBinaryTree m = new LevelOrderZigzagBinaryTree();
		BinaryTree bt = m.new BinaryTree();
		bt.levelOrderZZ();
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

		public void levelOrderZZ() {
			Queue<Node> q = new LinkedList<>();
			Deque<Node> deque = new LinkedList<>();
			int level = 1;
			q.add(root);
			deque.addLast(root);
			while (!q.isEmpty()) {
				level++;
				Node r = q.poll();
				System.out.print(r.data + " ");
				if (r.left != null && level % 2 == 0) {
					deque.addFirst(r.left);
				} else if (r.left != null && level % 2 != 0) {
					deque.addLast(r.left);
				}
				if (r.right != null && level % 2 == 0) {
					deque.addFirst(r.right);
				} else if (r.right != null && level % 2 != 0) {
					deque.addLast(r.right);
				}
			}
			System.out.println();
		}
	}
}