package lec30;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CreateTreeUsingLevelOrder {

	class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root;

	Scanner sc = new Scanner(System.in);

	public CreateTreeUsingLevelOrder() {
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
				rightNode.val = c2;
				rn.left = rightNode;
				q.add(rightNode);
			}
		}
	}
}