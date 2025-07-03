package lec35;

import java.util.ArrayList;

public class HashMap<K, V> {

	class Node {
		K key;
		V value;
		Node next;
	}

	@Override
	public String toString() {
		String s = "{";
		for (Node node : bukt) {
			while (node != null) {
				s = s + node.key + "=" + node.value + ",";
				node = node.next;
			}
		}
		return s + "}";
	}

	ArrayList<Node> bukt;
	private int size;// HashMap Size

	public HashMap() {
		this(4);
	}

	public HashMap(int n) {
		bukt = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			bukt.add(null);
		}
	}

	public int hashFun(K key) {
		int idx = key.hashCode() % bukt.size();
		if (idx < 0) {
			idx += bukt.size();
		}
		return idx;
	}

	public void put(K key, V value) {
		int idx = hashFun(key);
		// ------------------------------------//
		Node curr = bukt.get(idx);
		while (curr != null) {
			if (curr.key.equals(key)) {
				curr.value = value;
				return;
			}
			curr = curr.next;
		}
		// ------------------------------------//

		Node nn = new Node();
		nn.key = key;
		nn.value = value;
		size++;
		curr = bukt.get(idx);
		nn.next = curr;
		bukt.set(idx, nn);
		double thf = 2.0;
		double lf = (1.0 * size) / bukt.size();
		if (lf > thf) {
			rehashing();
		}
	}

	public void rehashing() {
		ArrayList<Node> newBukt = new ArrayList<>();
		for (int i = 0; i < 2 * bukt.size(); i++) {
			newBukt.add(null);
		}
		ArrayList<Node> oba = bukt;
		bukt = newBukt;
		size = 0;
		for (Node node : oba) {
			while (node != null) {
				put(node.key, node.value);
				node = node.next;
			}
		}
	}

	public V get(K key) {
		int idx = hashFun(key);
		Node curr = bukt.get(idx);
		while (curr != null) {
			if (curr.key.equals(key)) {
				return curr.value;
			}
			curr = curr.next;
		}
		return null;
	}

	public boolean containsKey(K key) {
		int idx = hashFun(key);
		Node curr = bukt.get(idx);
		while (curr != null) {
			if (curr.key.equals(key)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public V remove(K key) {
		int idx = hashFun(key);
		Node curr = bukt.get(idx);
		Node prev = null;
		while (curr != null) {
			if (curr.key.equals(key)) {
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		if (curr == null)
			return null;
		if (prev == null) {
			bukt.set(idx, curr.next);
		} else {
			prev.next = curr.next;
		}
		curr.next = null;
		size--;
		return curr.value;
	}
}