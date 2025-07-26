package treeAssignment;

public class BinarySearchTree {

	public class Node {
		public int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}

		public Node() {

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

	public void LCA(int p, int q) {

		Node pn = new Node();
		pn.val = p;

		Node qn = new Node();
		qn.val = q;

		System.out.println(lowestCommonAncestor(root, pn, qn).val);

//		return lowestCommonAncestor(root, pn, qn);
	}

	public Node lowestCommonAncestor(Node root, Node p, Node q) {
		if (root == null)
			return root;
		if (root == p || root == q) {
			return root;
		}

		Node left = lowestCommonAncestor(root.left, p, q);
		Node right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		} else if (left == null) {
			return right;
		} else {
			return left;
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
}