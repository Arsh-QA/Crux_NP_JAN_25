package treeAssignment;

import java.util.Scanner;

public class LargestBSTInABinaryTreeMonuBhaiya {

	public static void main(String[] args) {
		LargestBSTInABinaryTreeMonuBhaiya lbt = new LargestBSTInABinaryTreeMonuBhaiya();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] preOrder = new int[n];
		int[] inOrder = new int[n];
		for (int i = 0; i < preOrder.length; i++) {
			preOrder[i] = sc.nextInt();
		}
		for (int i = 0; i < inOrder.length; i++) {
			inOrder[i] = sc.nextInt();
		}
		lbt.buildTree(preOrder, inOrder);
		System.out.println(lbt.validBST());
		sc.close();
	}

	public class Node {
		int val;
		Node left;
		Node right;

		Node() {
		}

		Node(int val) {
			this.val = val;
		}

		Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;

	public void buildTree(int[] preorder, int[] inorder) {
		this.root = build(preorder, inorder, 0, inorder.length - 1, 0, preorder.length - 1);
	}

	public Node build(int[] pre, int[] in, int ilo, int ihi, int plo, int phi) {
		if (ilo > ihi || plo > phi) {
			return null;
		}
		Node node = new Node(pre[plo]);// 10
		int idx = search(in, ilo, ihi, pre[plo]);
		int count = idx - ilo;
		node.left = build(pre, in, ilo, idx - 1, plo + 1, plo + count);
		node.right = build(pre, in, idx + 1, ihi, plo + count + 1, phi);
		return node;
	}

	public int search(int[] in, int si, int ei, int item) {
		for (int i = si; i <= ei; i++) {
			if (in[i] == item) {
				return i;
			}
		}
		return -1;
	}

	public int validBST() {
		return validBST(root).size;
	}

	class BSTPair {
		boolean isBST = true;
		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;
		int size = 0;
	}

	public BSTPair validBST(Node root) {
		if (root == null)
			return new BSTPair();
		BSTPair lbp = validBST(root.left);
		BSTPair rbp = validBST(root.right);
		BSTPair sbp = new BSTPair();
		sbp.max = Math.max(lbp.max, Math.max(rbp.max, root.val));
		sbp.min = Math.min(lbp.min, Math.min(rbp.min, root.val));
		sbp.isBST = lbp.isBST && rbp.isBST && lbp.max < root.val && rbp.min > root.val;
		if (sbp.isBST)
			sbp.size = lbp.size + rbp.size + 1;
		else
			sbp.size = Math.max(lbp.size, rbp.size);
		return sbp;
	}
}