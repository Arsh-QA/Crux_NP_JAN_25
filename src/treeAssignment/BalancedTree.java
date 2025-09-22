package treeAssignment;

import treeAssignment.DiameterOptimized.TreeNode;

public class BalancedTree {
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
		public boolean isBalanced(TreeNode root) {
			return isBalance(root).isBalance;
		}

		public BalancedPair isBalance(TreeNode root) {
			if (root == null)
				return new BalancedPair();
			BalancedPair lbp = isBalance(root.left);
			BalancedPair rbp = isBalance(root.right);
			BalancedPair sbp = new BalancedPair();
			sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;
			boolean sb = Math.abs(lbp.ht - rbp.ht) <= 1;
			sbp.isBalance = lbp.isBalance && rbp.isBalance && sb;
			return sbp;
		}

		class BalancedPair {
			boolean isBalance = true;
			int ht = -1;
		}
	}
}
