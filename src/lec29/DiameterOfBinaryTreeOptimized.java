package lec29;

public class DiameterOfBinaryTreeOptimized {
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
		public int diameterOfBinaryTree(TreeNode root) {
			return diameter(root).dt;
		}

		public DiaPair diameter(TreeNode root) {
			if (root == null) {
				return new DiaPair();
			}
			DiaPair ldp = diameter(root.left);
			DiaPair rdp = diameter(root.right);
			int sd = ldp.ht + rdp.ht + 2;
			DiaPair sdp = new DiaPair();
			sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;
			sdp.dt = Math.max(sd, Math.max(rdp.dt, ldp.dt));
			return sdp;
		}

		class DiaPair {
			int dt = 0;// base case value
			int ht = -1;// base case value

		}
	}
}