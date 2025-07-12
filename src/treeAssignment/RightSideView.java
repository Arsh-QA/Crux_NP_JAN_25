package treeAssignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RightSideView {

	public static void main(String[] args) {
		RightSideView rsv = new RightSideView();
		Node root2 = rsv.root;
		rsv.display();
		System.out.println(root2.left.val);
		System.out.println(root2.right.val);
		List<Integer> ll = rsv.rightSideView(root2);
		for (int v : ll) {
			System.out.print(v + " ");
		}
	}

	class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root;

	Scanner sc = new Scanner(System.in);

	public RightSideView() {
		createTree();
	}

	private void createTree() {
		int item = sc.nextInt();
		Node nn = new Node();
		nn.val = item;
		root = nn;
		Queue<Node> q = new LinkedList<>();
		q.add(nn);
		while (!q.isEmpty()) {
			Node rn = q.poll();
			int c1 = sc.nextInt();
			System.out.println(c1);
			int c2 = sc.nextInt();
			System.out.println(c2);
			if (c1 != -1) {
				Node leftNode = new Node();
				leftNode.val = c1;
				rn.left = leftNode;
				q.add(leftNode);
			}
			if (c2 != -1) {
				Node rightNode = new Node();
				rightNode.val = c1;
				rn.left = rightNode;
				q.add(rightNode);
			}
		}
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

	public List<Integer> rightSideView(Node root) {
		List<Integer> ll = new ArrayList<>();
		rightSide(root, 1, ll);
		return ll;
	}

	int maxDepth = 0;

	public void rightSide(Node root, int cl, List<Integer> ll) {
		if (root == null)
			return;
		if (maxDepth < cl) {
			ll.add(root.val);
			maxDepth = cl;
		}
		rightSide(root.right, cl + 1, ll);
		rightSide(root.left, cl + 1, ll);
	}
}