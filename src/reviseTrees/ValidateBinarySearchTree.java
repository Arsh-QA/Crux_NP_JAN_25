package reviseTrees;

public class ValidateBinarySearchTree {
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
		public boolean isValidBST(TreeNode root) {
			return isValidate(root).isBST;
		}

		public BSTPair isValidate(TreeNode root) {
			if (root == null)
				return new BSTPair();
			BSTPair lbp = isValidate(root.left);
			BSTPair rbp = isValidate(root.right);
			BSTPair sbp = new BSTPair();
			sbp.max = Math.max(root.val, Math.max(lbp.max, rbp.max));
			sbp.min = Math.min(root.val, Math.min(lbp.min, rbp.min));
			sbp.isBST = lbp.isBST && rbp.isBST && lbp.max < root.val && rbp.min > root.val;
			return sbp;
		}

		class BSTPair {
			long min = Long.MAX_VALUE;
			long max = Long.MIN_VALUE;
			boolean isBST = true;
		}
	}
}