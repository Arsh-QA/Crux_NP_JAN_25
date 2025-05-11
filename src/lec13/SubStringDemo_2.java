package lec13;

public class SubStringDemo_2 {
	public static void main(String[] args) {
		String s = "codingblocks";
		printAllSubStrings(s);
	}

	public static void printAllSubStrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				System.out.println(s.substring(i, j));
				count++;
			}
			System.out.println();
		}
		System.out.println("The total number of substrings are : " + count);
	}
}