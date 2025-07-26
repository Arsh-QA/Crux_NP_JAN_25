package treeAssignment;

import java.util.Scanner;

public class LowestCommonAncestorOfABinarySearchTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int p = sc.nextInt();
		int q = sc.nextInt();
		BinarySearchTree bst = new BinarySearchTree();
		bst.createTree(arr);
		bst.display();
		bst.LCA(p, q);
		sc.close();
	}
}