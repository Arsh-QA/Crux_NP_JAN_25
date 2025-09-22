package treeAssignment;

import java.util.Scanner;

public class CreateTreeUsingPostorderAndInorder {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		CreateTreeUsingPostorderAndInorder m = new CreateTreeUsingPostorderAndInorder();
		int[] post = takeInput();
		int[] in = takeInput();
		BinaryTree bt = m.new BinaryTree(post, in);
		bt.display();
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

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

		public BinaryTree(int[] post, int[] in) {
			this.root = this.construct(post, 0, post.length - 1, in, 0, in.length - 1);
		}

		private Node construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {
			if (ilo > ihi || plo > phi)
				return null;
			Node node = new Node();
			node.data = post[phi];
			int idx = search(in, ilo, ihi, post[phi]);
			int ne = ihi - idx;
			node.right = construct(post, phi - ne, phi - 1, in, idx + 1, ihi);
			node.left = construct(post, plo, phi - ne - 1, in, ilo, idx - 1);
			return node;
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

		private void display(Node node) {
			if (node == null) {
				return;
			}

			String str = "";

			if (node.left != null) {
				str += node.left.data;
			} else {
				str += "END";
			}

			str += " => " + node.data + " <= ";

			if (node.right != null) {
				str += node.right.data;
			} else {
				str += "END";
			}

			System.out.println(str);

			this.display(node.left);
			this.display(node.right);
		}
	}
}