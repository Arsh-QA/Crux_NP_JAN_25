package leetcodeQuestions1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		ArrayList<List<String>> result = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String sortedStr = new String(charArray);
			if (!map.containsKey(sortedStr)) {
				map.put(sortedStr, new ArrayList<>());
			}
			map.get(sortedStr).add(str);
		}
		return new ArrayList<>(map.values());
	}

	public static boolean isAnagram(String string1, String string2) {
		if (string1 == string2) {
			return true;
		}
		if (string1.length() != string2.length()) {
			return false;
		}
		char[] c1 = string1.toCharArray();
		char[] c2 = string2.toCharArray();
		int[] intArray = new int[52];

		for (int i = 0; i < c1.length; i++) {
			intArray[c1[i] - 'a']++;
		}

		for (int i = 0; i < c2.length; i++) {
			intArray[c2[i] - 'a']--;
		}

		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] != 0) {
				return false;
			}
		}
		return true;
	}
}