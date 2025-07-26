package treeAssignment;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int val) {
		this.val = val;
	}
}

public class LevelOrderTraversalNewLine {
	public static TreeNode buildTree(List<Integer> values) {
		if (values.isEmpty() || values.get(0) == -1)
			return null;

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(values.get(0));
		queue.add(root);
		int index = 1;

		while (!queue.isEmpty() && index < values.size()) {
			TreeNode node = queue.poll();

			if (index < values.size() && values.get(index) != -1) {
				node.left = new TreeNode(values.get(index));
				queue.add(node.left);
			}
			index++;

			if (index < values.size() && values.get(index) != -1) {
				node.right = new TreeNode(values.get(index));
				queue.add(node.right);
			}
			index++;
		}

		return root;
	}

// You need to implement this function to return a list of lists representing 
	public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
		List<List<Integer>> ll = new ArrayList<>();
		if (root == null)
			return ll;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size(); // number of nodes at current level
			List<Integer> level = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				level.add(curr.val);

				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			}
			ll.add(level);
		}
		return ll;
	}

	// You need to implement this function to return a list of lists representing
	public static void levelOrderTraversalMonuBhaiya(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> help = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode rv = queue.remove();
			System.out.println(root.val + " ");
			if (rv.left != null) {
				help.add(rv.left);
			}
			if (rv.right != null) {
				help.add(rv.right);
			}
			if (queue.isEmpty()) {
				queue = help;
				System.out.println();
				help = new LinkedList<>();
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> values = new ArrayList<>();

		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				values.add(scanner.nextInt());
			} else if (scanner.next().equalsIgnoreCase("done")) {
				break;
			}
		}

		TreeNode root = buildTree(values);
		List<List<Integer>> levels = levelOrderTraversal(root);

		for (List<Integer> level : levels) {
			for (int n : level) {
				System.out.print(n + " ");
			}
			System.out.println();
		}

		scanner.close();
	}
}