package reviseTries;

import java.util.HashMap;

public class Trie {
	private class Node {
		char data;
		HashMap<Character, Node> child = new HashMap<>();
		boolean isTermial;
	}

	private Node root;

	public Trie() {
		Node nn = new Node();
		nn.data = '*';
		root = nn;
	}

	public void insert(String word) {
		Node temp = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (temp.child.containsKey(ch)) {
				temp = temp.child.get(ch);
			} else {
				Node nn = new Node();
				nn.data = ch;
				temp.child.put(ch, nn);
				temp = nn;
			}
		}
		temp.isTermial = true;
	}

	public boolean search(String word) {
		Node temp = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!temp.child.containsKey(ch)) {
				return false;
			} else {
				temp = temp.child.get(ch);
			}
		}
		return temp.isTermial;
	}

	public boolean startsWith(String prefix) {
		Node temp = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if (!temp.child.containsKey(ch)) {
				return false;
			} else {
				temp = temp.child.get(ch);
			}
		}
		return true;
	}
}