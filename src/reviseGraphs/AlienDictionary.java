package reviseGraphs;

import java.util.*;

public class AlienDictionary {
	HashMap<Character, HashMap<Character, Integer>> map = new HashMap<>();
	int[] indegree = new int[26];

	public String alienOrder(String[] words) {
		for (int i = 0; i < words.length; i++) {
			for (char ch : words[i].toCharArray()) {
				if (!map.containsKey(ch)) {
					map.put(ch, new HashMap<>());
				}
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];

			if (word1.startsWith(word2) && word1.length() > word2.length()) {
				return "";
			}

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					HashMap<Character, Integer> nbrs = map.get(word1.charAt(j));

					if (!nbrs.containsKey(word2.charAt(j))) {
						nbrs.put(word2.charAt(j), 0);
						indegree[word2.charAt(j) - 'a']++;
					}
					break;
				}
			}
		}

		Queue<Character> qq = new LinkedList<>();

		for (char key : map.keySet()) {
			if (indegree[key - 'a'] == 0) {
				qq.add(key);
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!qq.isEmpty()) {

			char ch = qq.poll();
			sb.append(ch);

			for (char nbrs : map.get(ch).keySet()) {
				indegree[nbrs - 'a']--;
				if (indegree[nbrs - 'a'] == 0) {
					qq.add(nbrs);
				}
			}

		}

		return sb.toString().length() < map.size() ? "" : sb.toString();
	}

	public static void main(String[] args) {
		AlienDictionary ad = new AlienDictionary();
		String word[] = { "bacd", "ab", "lp", "mo", "za" };
		System.out.println(ad.alienOrder(word));
	}
}