package lec28_29_revise;

public class BinaryTreeClient {

	public static void main(String[] args) {
//10 true 20 true 40 false false true 50 false false true 30 false true 60 true 70 false false false		
		BinaryTree bt = new BinaryTree();
		bt.display();
		System.out.println(bt.max());
		System.out.println(bt.find(70));
		System.out.println(bt.ht());
		bt.preOrder();
		bt.inOrder();
		bt.postOrder();
		bt.levelOrder();
	}
}