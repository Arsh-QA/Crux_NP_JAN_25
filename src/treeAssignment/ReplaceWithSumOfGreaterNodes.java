package treeAssignment;

import java.util.*;

public class ReplaceWithSumOfGreaterNodes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ReplaceWithSumOfGreaterNodes m = new ReplaceWithSumOfGreaterNodes();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		BinarySearchTree bst = m.new BinarySearchTree(arr);
		bst.replaceWLS();
		bst.display();
		sc.close();
	}

	public class BinarySearchTree {
		class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinarySearchTree(int[] arr) {
			this.root = createTree(arr, 0, arr.length - 1);
		}

		private Node createTree(int[] arr, int si, int ei) {
			if (si > ei)
				return null;
			int mid = (si + ei) / 2;
			Node nn = new Node();
			nn.data = arr[mid];
			nn.left = createTree(arr, si, mid - 1);
			nn.right = createTree(arr, mid + 1, ei);
			return nn;
		}

		private int sum = 0;

		public void replaceWLS() {
			sum = 0;
			replaceWLS(root);
		}

		private void replaceWLS(Node node) {
			if (node == null)
				return;
			replaceWLS(node.right);
			int ii = node.data;
			node.data += sum;
			sum += ii;
			replaceWLS(node.left);
		}

		public void display() {
			display(root);
		}

		private void display(Node nn) {
			if (nn == null)
				return;
			System.out.print(nn.data + " ");
			display(nn.left);
			display(nn.right);
		}
	}
}