package treeAssignment;

import java.util.*;

public class SiblingBinaryTree {

	public static void main(String[] args) {
		SiblingBinaryTree st = new SiblingBinaryTree();
		st.display();
		st.siblingTree();
	}

	class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root;

	Scanner sc = new Scanner(System.in);

	public void siblingTree() {
		siblingBinaryTree(root);
	}

	private void siblingBinaryTree(Node node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null)
			return;
		if (node.left != null && node.right == null)
			System.out.print(node.left.val + " ");
		if (node.left == null && node.right != null)
			System.out.print(node.right.val + " ");
		siblingBinaryTree(node.left);
		siblingBinaryTree(node.right);
	}

	public SiblingBinaryTree() {
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