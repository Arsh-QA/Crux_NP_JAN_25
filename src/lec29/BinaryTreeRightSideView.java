package lec29;

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
		int maximumDepth = 0;

		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> ll = new ArrayList<>();
			rightView(root, 1, ll);
			return ll;
		}

		public void rightView(TreeNode root, int currLevel, List<Integer> ll) {
			if (root == null)
				return;
			if (maximumDepth < currLevel) {
				ll.add(root.val);
				maximumDepth = currLevel;
			}
			rightView(root.right, currLevel + 1, ll);
			rightView(root.left, currLevel + 1, ll);
		}
	}
}