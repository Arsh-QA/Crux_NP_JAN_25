package lec35;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };

	}

	public static List<List<String>> group(String[] str) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < str.length; i++) {
			String key = generateKey(str[i]);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str[i]);
		}
		List<List<String>> ans = new ArrayList<>();
		for (String key : map.keySet()) {
			ans.add(map.get(key));
		}
		return ans;
	}

	private static String generateKey(String string) {
		int[] freq = new int[26];
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			freq[ch - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < freq.length; i++) {
			sb.append(freq[i] + " ");
		}
		return sb.toString();
	}
}