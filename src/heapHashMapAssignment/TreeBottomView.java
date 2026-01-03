package heapHashMapAssignment;

import java.util.*;
import java.io.*;

public class TreeBottomView {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		BinaryTree bt = new BinaryTree(arr);

		bt.bottomView();

	}
}

class BinaryTree {
	private class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	Node root;

	BinaryTree(String[] arr) {
		Queue<Node> queue = new LinkedList<Node>();
		construct(arr, 0, queue);
	}

	public void bottomView() {
		bottomView(this.root);
	}

	private void bottomView(Node root) {
		if (root == null)
			return;

		// Map HD -> bottom-most node value
		Map<Integer, Integer> map = new HashMap<>();

		// Queue for BFS
		Queue<Node> qNode = new LinkedList<>();
		Queue<Integer> qHd = new LinkedList<>();

		qNode.add(root);
		qHd.add(0);

		int minHd = 0, maxHd = 0;

		while (!qNode.isEmpty()) {
			Node curr = qNode.poll();
			int hd = qHd.poll();

			// Always overwrite -> bottom-most node at each HD
			map.put(hd, curr.data);

			if (hd < minHd)
				minHd = hd;

			if (hd > maxHd)
				maxHd = hd;

			if (curr.left != null && curr.left.data != -1) {
				qNode.add(curr.left);
				qHd.add(hd - 1);
			}

			if (curr.right != null && curr.right.data != -1) {
				qNode.add(curr.right);
				qHd.add(hd + 1);
			}
		}

		// Print from leftmost HD to rightmost HD
		StringBuilder sb = new StringBuilder();
		for (int hd = minHd; hd <= maxHd; hd++) {
			if (map.containsKey(hd)) {
				sb.append(map.get(hd)).append(" ");
			}
		}

		System.out.println(sb.toString().trim());

	}

	private void construct(String[] arr, int ind, Queue<Node> queue) {
		if (ind >= arr.length)
			return;
		if (queue.size() == 0) {
			Node nn = new Node(Integer.parseInt(arr[ind]));
			this.root = nn;
			queue.add(nn);
		} else {
			Node parent = queue.peek();
			if (parent.data != -1) {
				if (parent.left == null) {
					parent.left = new Node(Integer.parseInt(arr[ind]));
					queue.add(parent.left);
				} else {
					if (parent.right == null) {
						parent.right = new Node(Integer.parseInt(arr[ind]));
						queue.add(parent.right);
						queue.poll();
					}
				}
			} else {
				queue.poll();
				ind--;
			}
		}
		construct(arr, ind + 1, queue);
	}

	public void display() {
		display_tree(this.root);
	}

	private void display_tree(Node root) {
		if (root == null)
			return;
		String str = root.data + "";
		if (root.left != null) {
			str = root.left.data + " <= " + str;
		} else {
			str = "END <= " + str;
		}

		if (root.right != null) {
			str = str + " => " + root.right.data;
		} else {
			str = str + " => END";
		}
		System.out.println(str);
		display_tree(root.left);
		display_tree(root.right);

	}
}