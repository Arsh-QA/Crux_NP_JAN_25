package reviseTrees;

import java.util.*;

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

	public int max() {
		return max(root);
	}

	private int max(Node nn) {
		if (nn == null)
			return Integer.MIN_VALUE;

		int lmax = max(nn.left);
		int rmax = max(nn.right);
		return Math.max(lmax, Math.max(rmax, nn.val));
	}

	public boolean find(int item) {
		return find(root, item);
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
		return ht(root);
	}

	private int ht(Node nn) {
		if (nn == null)
			return -1;
		int lh = ht(nn.left);
		int rh = ht(nn.right);
		return Math.max(lh, rh) + 1;
	}

	public void preOrder() {
		preOrder(this.root);
		System.out.println();
	}

	private void preOrder(Node nn) {
		if (nn == null)
			return;
		System.out.print(nn.val + " ");
		preOrder(nn.left);
		preOrder(nn.right);
	}

	public void postOrder() {
		postOrder(this.root);
		System.out.println();
	}

	private void postOrder(Node nn) {
		if (nn == null)
			return;
		postOrder(nn.left);
		postOrder(nn.right);
		System.out.print(nn.val + " ");
	}

	public void inOrder() {
		inOrder(this.root);
		System.out.println();
	}

	private void inOrder(Node nn) {
		if (nn == null)
			return;
		inOrder(nn.left);
		System.out.print(nn.val + " ");
		inOrder(nn.right);
	}

	public void levelOrder() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node r = q.poll();
			System.out.print(r.val + " ");
			if (r.left != null)
				q.add(r.left);
			if (r.right != null)
				q.add(r.right);
		}
		System.out.println();
	}
}