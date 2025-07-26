package treeAssignment;

import java.util.*;

public class LevelOrderZigzagBinaryTree {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		LevelOrderZigzagBinaryTree m = new LevelOrderZigzagBinaryTree();
		BinaryTree bt = m.new BinaryTree();
		bt.levelOrderZZMonuBhaiya();
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

		public void levelOrderZZMonuBhaiya() {
			Queue<Node> queue = new LinkedList<>();
			Queue<Node> help = new LinkedList<>();
			queue.add(root);
			ArrayList<Integer> al = new ArrayList<>();
			int level = 0;
			while (!queue.isEmpty()) {
				Node rv = queue.remove();
				al.add(rv.data);
				if (rv.left != null) {
					help.add(rv.left);
				}
				if (rv.right != null) {
					help.add(rv.right);
				}
				if (queue.isEmpty()) {
					queue = help;
					help = new LinkedList<>();
					if (level % 2 == 0) {
						for (int val : al) {
							System.out.print(val + " ");
						}
					} else {
						Collections.reverse(al);
						for (int val : al) {
							System.out.print(val + " ");
						}
					}
					al = new ArrayList<>();
					level++;
				}
			}
			System.out.println();
		}

		public void levelOrder() {
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			ArrayList<Integer> al = new ArrayList<>();
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			al.add(root.data);
			al = new ArrayList<>();
			while (!queue.isEmpty()) {
				Node rv = queue.remove();
				if (rv.left != null) {
					al.add(rv.left.data);
				}
				if (rv.right != null) {
					al.add(rv.right.data);
				}
				result.add(al);
				al = new ArrayList<>();
			}
			System.out.println();
		}
	}
}