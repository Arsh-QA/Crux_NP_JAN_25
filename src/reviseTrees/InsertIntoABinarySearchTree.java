package reviseTrees;

public class InsertIntoABinarySearchTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {
		public TreeNode insertIntoBST(TreeNode root, int value) {
			if (root == null) {
				return new TreeNode(value);
			}
			TreeNode nn = new TreeNode(value);
			if (root.val < value) {
				insertIntoBST(root.right, value);
			} else {
				insertIntoBST(root.left, value);
			}
			return root;
		}
	}
}