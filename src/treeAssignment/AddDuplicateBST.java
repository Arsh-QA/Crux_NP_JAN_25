package treeAssignment;

import java.util.Scanner;

public class AddDuplicateBST {

	public static void main(String[] args) {
		AddDuplicateBST ad = new AddDuplicateBST();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		ad.createTree(arr);
		ad.duplicate();
		ad.display();

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

	public void duplicate() {
		this.duplicate(this.root);
	}

	private void duplicate(Node node) {
		if(node == null)
			return;
		Node nn = new Node();
		nn.val = node.val;
		nn.left = node.left;
		node.left = nn;

		duplicate(node.left.left);
		duplicate(node.right);

	}

	public void display() {
		display(root);
	}

	private void display(Node nn) {
		if (nn == null)
			return;
		String s = " => " + nn.val + " <= ";
		if (nn.left != null) {
			s = nn.left.val + s;
		} else {
			s = "END" + s;
		}
		if (nn.right != null) {
			s = s + nn.right.val;
		} else {
			s = s + "END";
		}
		System.out.println(s);
		display(nn.left);
		display(nn.right);
	}
}