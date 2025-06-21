package lec28_29_revise;

import java.util.*;

public class BinaryTreeRightSideView {
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

		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> ll = new ArrayList<>();
			rightSide(root, 1, ll);
			return ll;
		}

		int maxDepth = 0;

		public void rightSide(TreeNode root, int cl, List<Integer> ll) {
			if (root == null)
				return;

			if (maxDepth < cl) {
				System.out.print(root.val);// condition
				maxDepth = cl;
			}
			rightSide(root.right, cl + 1, ll);
			rightSide(root.left, cl + 1, ll);
		}
	}
}