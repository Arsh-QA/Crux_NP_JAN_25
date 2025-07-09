package lec34_35_revise;

import java.util.*;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		// add
		map.put("Raj", 89);
		map.put("Ankit", 79);
		map.put("Kaju", 99);
		map.put("Ankita", 59);
		map.put("Vishal", 77);
		map.put("Pooja", 88);
		map.put("Anku", 82);
		map.put("Puneet", 73);
		map.put("Ankita", 38);
		map.put(null, 99);
		System.out.println(map);

		Set<String> set = map.keySet();
		System.out.print(set);
		for (String key : set) {
			System.out.println(key + " " + map.get(key));
		}

		// Contains
		System.out.println(map.containsKey("Aniket"));
		System.out.println(map.containsKey("Anku"));

		// Get
		System.out.println(map.get("Aniket"));
		System.out.println(map.get("Anku"));

		// Remove
		System.out.println(map.remove("Aniket"));
		System.out.println(map.remove("Anku"));

		System.out.println(map);

		// Size
		System.out.println(map.size());
	}
}