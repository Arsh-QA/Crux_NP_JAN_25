package lec30;

public class ValidateBinarySearchTree {
	public class TreeNode {
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
			BSTPair bstPair = validBST(root);
			return bstPair.isBST;
		}

		public BSTPair validBST(TreeNode root) {
			if (root == null)
				return new BSTPair();
			BSTPair lbp = validBST(root.left);
			BSTPair rbp = validBST(root.right);
			BSTPair sbp = new BSTPair();
			sbp.max = Math.max(lbp.max, Math.max(rbp.max, root.val));
			sbp.min = Math.min(lbp.min, Math.min(rbp.min, root.val));
			sbp.isBST = lbp.isBST && rbp.isBST && lbp.max < root.val && rbp.min > root.val;
			return sbp;
		}

		class BSTPair {
			boolean isBST = true;
			long max = Long.MIN_VALUE;
			long min = Long.MAX_VALUE;
		}
	}
}
