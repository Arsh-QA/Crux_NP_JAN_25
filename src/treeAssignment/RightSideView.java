package treeAssignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RightSideView {

	public static void main(String args[]) {
		List<Integer> ll = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		ll.add(sc.nextInt());
		System.out.println(ll);
		sc.close();
	}

	class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root;

	Scanner sc = new Scanner(System.in);

	public void createTreeUsingLevelOrder() {
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
			int c2 = sc.nextInt();
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