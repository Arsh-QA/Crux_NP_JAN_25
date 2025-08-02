package lec44;

import java.util.*;

public class TriesContacts {
	class Node {
		char ch;
		HashMap<Character, Node> child = new HashMap<>();
		boolean isTerminal = false;
		int count = 1;
	}

	private Node root;

	public TriesContacts() {
		root = new Node();
		root.ch = '*';
	}

	public void insert(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.child.containsKey(ch)) {
				curr = curr.child.get(ch);
				curr.count++;
			} else {
				Node nn = new Node();
				nn.ch = ch;
				curr.child.put(ch, nn);
				curr = nn;
			}
		}
		curr.isTerminal = true;
	}

	public int startsWith(String prefix) {
		Node curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if (curr.child.containsKey(ch)) {
				curr = curr.child.get(ch);
			} else {
				return 0;
			}
		}
		return curr.count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		TriesContacts tc = new TriesContacts();
		while (t-- > 0) {
			String s1 = sc.next();
			String s2 = sc.next();
			if (s1.equals("add"))
				tc.insert(s2);
			else
				System.out.println(tc.startsWith(s2));
		}
		sc.close();
	}
}