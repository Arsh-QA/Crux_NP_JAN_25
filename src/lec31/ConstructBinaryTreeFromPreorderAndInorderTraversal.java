package lec31;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			return build(preorder, inorder, 0, inorder.length - 1, 0, preorder.length - 1);
		}

		public TreeNode build(int[] pre, int[] in, int ilo, int ihi, int plo, int phi) {
			if(ilo > ihi || plo > phi) {
				return null;
			}
			TreeNode node = new TreeNode(pre[plo]);// 10
			int idx = search(in, ilo, ihi, pre[plo]);
			int count = idx - ilo;
			node.left = build(pre, in, ilo, idx - 1, plo + 1, plo + count);
			node.right = build(pre, in, idx + 1, ihi, plo + count + 1, phi);
			return node;
		}

		public int search(int[] in, int si, int ei, int item) {
			for (int i = si; i <= ei; i++) {
				if (in[i] == item) {
					return i;
				}
			}
			return -1;
		}
	}
}