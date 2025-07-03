package lec35;

public class HashMapClient {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Raj", 78);
		map.put("Kunal", 67);
		map.put("Komal", 55);
		map.put("Anisha", 88);
		map.put("Ankit", 78);
		map.put("Ankita", 62);
		map.put("Anisha", 58);
		System.out.println(map);
	}
}