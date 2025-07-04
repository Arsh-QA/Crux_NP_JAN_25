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

	public Node insertIntoBST(Node root, int val) {
		if (root == null)
			return new Node(val);
		if (root.val < val) {
			root.right = insertIntoBST(root.right, val);
		} else {
			root.left = insertIntoBST(root.left, val);
		}
		return root;
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