package heapHashMapAssignment;

import java.util.*;

public class MappedStrings {

	static List<String> result = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine().trim();

		decode(num, 0, new StringBuilder());

		Collections.sort(result);

		for (String s : result) {
			System.out.println(s);
		}

		sc.close();

	}

	static void decode(String num, int index, StringBuilder sb) {
		if (index == num.length()) {
			result.add(sb.toString());
			return;
		}

		// Option 1 : take single digit
		int one = num.charAt(index) - '0';
		if (one >= 1 && one <= 9) {
			sb.append((char) ('A' + one - 1));
			decode(num, index + 1, sb);
			sb.deleteCharAt(sb.length() - 1);// backtrack
		}

		// Option 2 : take two digits
		if (index + 1 < num.length()) {
			int two = Integer.parseInt(num.substring(index, index + 2));
			if (two >= 10 && two <= 26) {
				sb.append((char) ('A' + two - 1));
				decode(num, index + 2, sb);
				sb.deleteCharAt(sb.length() - 1); // backtrack
			}
		}
	}
}