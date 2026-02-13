package interviewQuestions;

import java.util.*;

public class FrequenceAndDescendingOrder {

	public static void main(String[] args) {
		String s = "ababbabcdc";
		System.out.println(frequencySort(s));
	}

	public static String frequencySort(String s) {

		// Step 1 : Count Frequence
		Map<Character, Integer> freqMap = new HashMap<>();
		for (char c : s.toCharArray()) {
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}

		// Step 2 : Sort Characters by frequency (descending)
		List<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());

		list.sort((a, b) -> {
			if (!b.getValue().equals(a.getValue())) {
				return b.getValue() - a.getValue(); // descending frequency
			}
			return a.getKey() - b.getKey();
		});

		System.out.println(list);

		// Step 3 : Build result string
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : list) {
			for (int i = 0; i < entry.getValue(); i++) {
				result.append(entry.getKey());
			}
		}

		return result.toString();
	}
}