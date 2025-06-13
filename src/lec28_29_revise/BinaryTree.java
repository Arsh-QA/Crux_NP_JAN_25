package lec28_29_revise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
	class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root;

	Scanner sc = new Scanner(System.in);

	public BinaryTree() {
		root = createTree();
	}

	private Node createTree() {
		int item = sc.nextInt();
		Node nn = new Node();
		nn.val = item;
		boolean hlc = sc.nextBoolean();
		if (hlc) {
			nn.left = createTree();
		}
		boolean hrc = sc.nextBoolean();
		if (hrc) {
			nn.right = createTree();
		}
		return nn;
	}

	public void display() {
		display(root);
	}

	private void display(Node nn) {
		if (nn == null)
			return;
		String s = "";
		s = "<--" + nn.val + "-->";
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

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		int lmax = max(node.left);
		int rmax = max(node.right);
		return Math.max(node.val, Math.max(lmax, rmax));
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node nn, int item) {
		if (nn == null)
			return false;
		if (nn.val == item)
			return true;
		boolean left = find(nn.left, item);
		boolean right = find(nn.right, item);
		return left || right;
	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {
		if (node == null)
			return -1;
		int lh = ht(node.left);
		int rh = ht(node.right);
		return Math.max(lh, rh) + 1;
	}

	public void preOrder() {
		preOrder(root);
		System.out.println();
	}

	private void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder() {
		inOrder(root);
		System.out.println();
	}

	private void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}

	public void postOrder() {
		postOrder(root);
		System.out.println();
	}

	private void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val + " ");
	}

	public void levelOrder() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node rv = q.remove();// remove first
			System.out.print(rv.val + " ");
			if (rv.left != null) {
				q.add(rv.left);
			}
			if (rv.right != null) {
				q.add(rv.right);
			}
		}
		System.out.println();
	}

}
