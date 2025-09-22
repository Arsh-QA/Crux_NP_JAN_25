package treeAssignment;

import java.util.*;

public class LowestCommonAncestorOfABinarySearchTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int p = sc.nextInt();
		int q = sc.nextInt();
		LowestCommonAncestorOfABinarySearchTree bst = new LowestCommonAncestorOfABinarySearchTree();
		bst.createTree(arr);
		Node nn = bst.LCA(p, q);
		System.out.println(nn.val);
		sc.close();
	}

	public Node LCA(int p, int q) {
		return lowestCommonAncestora(root, p, q);
	}

	public Node lowestCommonAncestora(Node nn, int p, int q) {
		if (nn == null)
			return null;
		if (nn.val == p || nn.val == q) {
			return nn;
		}

		Node left = lowestCommonAncestora(nn.left, p, q);
		Node right = lowestCommonAncestora(nn.right, p, q);

		if (left != null && right != null) {
			return nn;
		} else if (left == null) {
			return right;
		} else {
			return left;
		}
	}

	public class Node {
		public int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}

		public Node() {

		}
	}

	private Node root;

	public void createTree(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			this.root = addBST(root, arr[i]);
		}
	}

	private Node addBST(Node node, int val) {
		if (node == null)
			return new Node(val);
		if (node.val < val) {
			node.right = addBST(node.right, val);
		} else {
			node.left = addBST(node.left, val);
		}
		return node;
	}

	public void display() {
		display(root);
	}

	private void display(Node nn) {
		if (nn == null)
			return;
		String s = "<--" + nn.val + "-->";
		if (nn.left != null) {
			s = nn.left.val + s;
		} else {
			s = "." + s;
		}
		if (nn.right != null) {
			s = s + nn.right.val;
		} else {
			s = s + ".";
		}
		System.out.println(s);
		display(nn.left);
		display(nn.right);
	}
}