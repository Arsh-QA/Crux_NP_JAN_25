package reviseTrees;

public class ConstructBinaryTreeFromInorderPreorder {

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
		public TreeNode buildTree(int[] preOrder, int[] inOrder) {
			return create(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
		}

		public TreeNode create(int[] preOrder, int plo, int phi, int[] inOrder, int ilo, int ihi) {
			if (ilo > ihi || plo > phi)
				return null;
			TreeNode node = new TreeNode(preOrder[plo]);
			int idx = search(inOrder, ilo, ihi, preOrder[plo]); // 5
			int ne = idx - ilo;
			node.left = create(preOrder, plo + 1, plo + ne, inOrder, ilo, idx - 1);
			node.right = create(preOrder, plo + ne + 1, phi, inOrder, idx + 1, ihi);
			return node;
		}

		public int search(int[] in, int si, int ei, int item) {
			for (int i = si; i <= ei; i++) {
				if (in[i] == item)
					return i;
			}
			return -1;
		}
	}
}