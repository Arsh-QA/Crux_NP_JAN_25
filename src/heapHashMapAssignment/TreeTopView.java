package heapHashMapAssignment;

import java.util.*;
import java.io.*;

public class TreeTopView {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		TreeTopView tp = new TreeTopView();
		TreeTopView.BinaryTree bt = tp.new BinaryTree(arr);
		//bt.display();
		bt.topview();

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

		public void topview() {
			verticalTraversalTop(this.root);
		}

		private void verticalTraversalTop(Node root) {
			if (root == null)
				return;

			// Map HD -> First node at that HD (top view)
			HashMap<Integer, Integer> map = new HashMap<>();

			// BFS Queues
			Queue<Node> nq = new LinkedList<>();
			Queue<Integer> hq = new LinkedList<>();

			nq.add(root);
			hq.add(0);

			int minHD = 0, maxHD = 0;

			while (!nq.isEmpty()) {
				Node curr = nq.poll();
				int hd = hq.poll();

				// Only take First node for each HD (top view)
				if (!map.containsKey(hd)) {
					map.put(hd, curr.data);
				}

				// Track range of HDs
				if (hd < minHD) {
					minHD = hd;
				}
				if (hd > maxHD) {
					maxHD = hd;
				}

				// Left Child -> hd - 1
				if (curr.left != null && curr.left.data != -1) {
					nq.add(curr.left);
					hq.add(hd - 1);
				}

				// Right Child -> hd + 1
				if (curr.right != null && curr.right.data != -1) {
					nq.add(curr.right);
					hq.add(hd + 1);
				}
			}

			// Print from Leftmost HD -> Rightmost HD
			StringBuilder sb = new StringBuilder();
			for (int hd = minHD; hd <= maxHD; hd++) {
				if (map.containsKey(hd)) {
					sb.append(map.get(hd)).append(" ");
				}
			}

			// Print final result
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
}