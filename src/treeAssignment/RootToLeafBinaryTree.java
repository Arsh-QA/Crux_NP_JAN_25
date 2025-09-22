package treeAssignment;

import java.util.*;

public class RootToLeafBinaryTree {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		RootToLeafBinaryTree b1 = new RootToLeafBinaryTree();
		int k = scn.nextInt();
		b1.rootToLeaf(k);
		scn.close();
	}

	class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root;

	Scanner sc = new Scanner(System.in);

//	public RootToLeafBinaryTree() {
//		root = createTree();
//	}

	@SuppressWarnings("unused")
	private Node createTree(Scanner sc) {
		int item = sc.nextInt();
		Node nn = new Node();
		nn.val = item;
		boolean hlc = sc.nextBoolean();
		if (hlc) {
			nn.left = createTree(sc);
		}
		boolean hrc = sc.nextBoolean();
		if (hrc) {
			nn.right = createTree(sc);
		}
		return nn;
	}

	public void rootToLeaf(int k) {
		List<Integer> al = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		sumRootToLeaf(root, k, al, result);
		for (List<Integer> innerList : result) {
			for (int num : innerList) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	private void sumRootToLeaf(Node nn, int k, List<Integer> al, List<List<Integer>> result) {
		if (nn.left == null && nn.right == null) {
			if (k - nn.val == 0) {
				al.add(nn.val);
				result.add(new ArrayList<>(al));
				return;
			} else {
				return;
			}
		}
		al.add(nn.val);
		sumRootToLeaf(nn.left, k - nn.val, al, result);
		sumRootToLeaf(nn.right, k - nn.val, al, result);
	}

	public void display() {
		display(root);
	}

	private void display(Node nn) {
		if (nn == null)
			return;
		String s = "<--" + nn.val + "-->";
		if (nn.left != null) {
			s = nn.left.val + s;
		} else {
			s = "." + s;
		}
		if (nn.right != null) {
			s = s + nn.right.val;
		} else {
			s = s + ".";
		}
		System.out.println(s);
		display(nn.left);
		display(nn.right);
	}
}