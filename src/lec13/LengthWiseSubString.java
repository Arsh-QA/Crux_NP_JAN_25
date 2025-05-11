package lec13;

public class LengthWiseSubString {

	public static void main(String[] args) {
		String s = "hello";
		printAllSubString(s);
		System.out.println("=================================");
		pallindromAllSubString(s);
	}

	public static void printAllSubString(String s) {
		for (int len = 1; len <= s.length(); len++) {
			for (int j = len; j <= s.length(); j++) {
				int i = j - len;
				System.out.println(s.substring(i, j));
			}
		}
	}

	public static void pallindromAllSubString(String s) {
		for (int len = 1; len <= s.length(); len++) {
			for (int j = len; j <= s.length(); j++) {
				int i = j - len;
				if (isPalindrom(s.substring(i, j))) {
					System.out.println(s.substring(i, j) + " is palindrom");
				} else {
					System.out.println(s.substring(i, j) + " is not a palindrom");
				}
			}
		}
	}

	public static boolean isPalindrom(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}