package lec30;

import lec30.ValidateBinarySearchTree.TreeNode;
import lec30.ValidateBinarySearchTree.Solution.BSTPair;

public class MaximumSumBSTInBinaryTree {
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
		public int maxSumBST(TreeNode root) {
			return maxBST(root).ans;
		}

		public BSTPair maxBST(TreeNode root) {
			if (root == null)
				return new BSTPair();
			BSTPair lbp = maxBST(root.left);
			BSTPair rbp = maxBST(root.right);
			BSTPair sbp = new BSTPair();
			sbp.max = Math.max(lbp.max, Math.max(rbp.max, root.val));
			sbp.min = Math.min(lbp.min, Math.min(rbp.min, root.val));
			sbp.sum = lbp.sum + rbp.sum + root.val;
			sbp.isBST = lbp.isBST && rbp.isBST && lbp.max < root.val && rbp.min > root.val;
			if (sbp.isBST) {
				sbp.ans = Math.max(lbp.ans, Math.max(rbp.ans, sbp.sum));
			} else {
				sbp.ans = Math.max(lbp.ans, rbp.ans);
			}
			return sbp;
		}

		class BSTPair {
			boolean isBST = true;
			long max = Long.MIN_VALUE;
			long min = Long.MAX_VALUE;
			int sum = 0;
			int ans = 0;
		}
	}
}
