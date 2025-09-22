package reviseTrees;

import java.util.*;

public class CreateTreeUsingLevelOrder {

	// Input
	// 10 20 30 40 50 -1 70 -1 -1 60 -1 -1 -1 -1 -1

	public static void main(String[] args) {
		CreateTreeUsingLevelOrder ct = new CreateTreeUsingLevelOrder();
		ct.display();
	}

	class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}

	private Node root;

	public CreateTreeUsingLevelOrder() {
		createTree();
	}

	private void createTree() {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		Node node = new Node(e);
		root = node;
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
			Node rv = q.poll();// remove first
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			if (c1 != -1) {
				Node nn = new Node(c1);
				rv.left = nn;
				q.add(nn);
			}
			if (c2 != -1) {
				Node nn = new Node(c2);
				rv.right = nn;
				q.add(nn);
			}
		}
		sc.close();
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