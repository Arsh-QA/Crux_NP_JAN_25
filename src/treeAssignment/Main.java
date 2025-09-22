package treeAssignment;

import java.util.*;

public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		int n = scn.nextInt();
		int[] pre = takeInput(n);
		int[] in = takeInput(n);
		BinaryTree bt = m.new BinaryTree(pre, in);
		bt.display();
	}

	public static int[] takeInput(int n) {

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree(int[] pre, int[] in) {
			this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
		}

		private Node construct(int[] preOrder, int plo, int phi, int[] inOrder, int ilo, int ihi) {
			if (ilo > ihi || plo > phi)
				return null;
			Node nn = new Node();
			nn.data = preOrder[plo];
			int idx = search(inOrder, ilo, ihi, preOrder[plo]); // 5
			int ne = idx - ilo;
			nn.left = construct(preOrder, plo + 1, plo + ne, inOrder, ilo, idx - 1);
			nn.right = construct(preOrder, plo + ne + 1, phi, inOrder, idx + 1, ihi);
			return nn;
		}

		public int search(int[] in, int si, int ei, int item) {
			for (int i = si; i <= ei; i++) {
				if (in[i] == item)
					return i;
			}
			return -1;
		}

		public void display() {
			this.display(this.root);
		}

		private void display(Node nn) {
			Queue<Node> q = new LinkedList<>();
			q.add(nn);
			System.out.print(nn.data + " ");
			while (!q.isEmpty()) {
				Node rv = q.poll();
				if (rv.left != null) {
					q.add(rv.left);
					System.out.print(rv.left.data + " ");
				}
				if (rv.right != null) {
					q.add(rv.right);
					System.out.print(rv.right.data + " ");
				}

			}
		}
	}
}