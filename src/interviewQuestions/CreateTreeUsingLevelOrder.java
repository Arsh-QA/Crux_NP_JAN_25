package interviewQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CreateTreeUsingLevelOrder {

	public static void main(String[] args) {
		CreateTreeUsingLevelOrder cl = new CreateTreeUsingLevelOrder();
		cl.postOrder();
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	TreeNode root;
	Scanner sc = new Scanner(System.in);

	public CreateTreeUsingLevelOrder() {
		root = buildTree();
	}

	public TreeNode buildTree() {
		int item = sc.nextInt();
		TreeNode node = new TreeNode();
		node.val = item;
		root = node;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
			TreeNode rv = q.poll();
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			if (c1 != -1) {
				TreeNode n = new TreeNode();
				n.val = c1;
				rv.left = n;
				q.add(n);
			}
			if (c2 != -1) {
				TreeNode n = new TreeNode();
				n.val = c2;
				rv.right = n;
				q.add(n);
			}
		}
		return root;
	}

	public void postOrder() {
		postOrder(this.root);
		System.out.println();
	}

	public void postOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val + " ");
	}

}