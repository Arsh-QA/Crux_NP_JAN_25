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
		BinarySearchTree bst = new BinarySearchTree();
		for (int i = 0; i < arr.length; i++) {
			bst.insertIntoBST(null, arr[i]);
		}

		bst.display();
		sc.close();
	}
}