package lec13;

public class CheckPalindrome {

	public static void main(String[] args) {
		String s1 = "nitin";
		System.out.println(isPalindrom(s1));
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