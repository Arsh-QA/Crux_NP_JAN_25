package leetcodeQuestions1;

public class BinaryTreeCameras {
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

		private int cameraCount = 0;

		public int minCameraCover(TreeNode root) {
			if (dfs(root) == 0) {
				cameraCount++;
			}
			return cameraCount;
		}

		// Returns :
		// 0 : Node needs Camera
		// 1 : Node is covered
		// 2 : Node has camera
		private int dfs(TreeNode node) {
			if (node == null)
				return 1;// null nodes are considered covered

			int left = dfs(node.left);
			int right = dfs(node.right);

			if (left == 0 || right == 0) {
				cameraCount++;
				return 2;// install camera at current node
			}

			if (left == 2 || right == 2) {
				return 1;// current node is covered
			}

			return 0;// Node needs camera
		}
	}
}