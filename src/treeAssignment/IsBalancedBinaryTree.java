package treeAssignment;

import java.util.*;

public class IsBalancedBinaryTree {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		IsBalancedBinaryTree m = new IsBalancedBinaryTree();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.isBalanced());
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

		public boolean isBalanced() {
			return this.isBalanced(this.root).isBalanced;
		}

		private BalancedPair isBalanced(Node node) {
			if (node == null) {
				BalancedPair newPair = new BalancedPair();
				newPair.height = -1;
				newPair.isBalanced = true;
				return newPair;
			}
			int lHt = isBalanced(node.left).height;
			int rHt = isBalanced(node.right).height;

			BalancedPair pair = new BalancedPair();
			pair.height = Math.max(lHt, rHt) + 1;
			if (Math.abs(lHt - rHt) <= 1) {
				pair.isBalanced = true;
			}
			return pair;
		}

		private class BalancedPair {
			int height;
			boolean isBalanced;
		}
	}
}