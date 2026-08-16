package reviseTries;

public class TrieClient {
	
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("apple");
		t.insert("shivani");
		t.insert("raju");
		t.insert("raja");
		t.insert("mango");
		t.insert("go");
		System.out.println(t.search("app"));
		System.out.println(t.startsWith("app"));
	}

}
