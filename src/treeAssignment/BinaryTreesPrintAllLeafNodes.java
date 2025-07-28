package treeAssignment;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BinaryTreesPrintAllLeafNodes {

	public static void main(String[] args) {
		BinaryTreesPrintAllLeafNodes bt = new BinaryTreesPrintAllLeafNodes();
		bt.createTree();
		bt.display();
	}
	
	class Node{
		int val;
		Node left;
		Node right;
	}
	
	private Node root;
	
	Scanner sc = new Scanner(System.in);
	
	public void display() {
		display(root);
	}

	private void display(Node nn) {
		if (nn == null)
			return;
		String s = "<--" + nn.val + "-->";
		if (nn.left.val != -1) {
			s = nn.left.val + s;
		} else {
			s = "." + s;
		}
		if (nn.right.val != -1) {
			s = s + nn.right.val;
		} else {
			s = s + ".";
		}
		System.out.println(s);
		display(nn.left);
		display(nn.right);
	}
	
	
	public void createTree() {
		int item = sc.nextInt();
		Node nn = new Node();
		nn.val = item;
		root = nn;
		Queue<Node> q = new LinkedList<>();
		q.add(nn);
		while (!q.isEmpty()) {
			Node rn = q.poll();
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			if (c1 != -1) {
				Node leftNode = new Node();
				leftNode.val = c1;
				rn.left = leftNode;
				q.add(leftNode);
			}
			if (c2 != -1) {
				Node rightNode = new Node();
				rightNode.val = c2;
				rn.left = rightNode;
				q.add(rightNode);
			}
		}
	}
}