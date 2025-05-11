package lec19;

public class AxisOrbit {

	public static void main(String[] args) {
		String s = "naan";
		palindromeAllSubString(s);
		System.out.println(palindromicSubstrings(s));
	}

	public static int palindromicSubstrings(String s) {
		// odd
		int odd = 0;
		for (int axis = 0; axis < s.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
				if (s.charAt(axis - orbit) != s.charAt(axis + orbit)) {
					break;
				}
				odd++;
			}
		}

		// even
		int even = 0;
		for (double axis = 0.5; axis < s.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
				if (s.charAt((int) (axis - orbit)) != s.charAt((int) (axis + orbit))) {
					break;
				}
				even++;
			}
		}
		return odd + even;
	}

	public static void palindromeAllSubString(String s) {
		for (int len = 1; len <= s.length(); len++) {
			for (int j = len; j <= s.length(); j++) {
				int i = j - len;
				if (isPalindrome(s.substring(i, j))) {
					System.out.println(s.substring(i, j));
				}
//				else {
//					System.out.println(s.substring(i, j) + " is not a palindrome");
//				}
			}
		}
	}

	public static boolean isPalindrome(String s) {
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