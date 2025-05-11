package lec16prefix;

public class SubSequence2 {

	public static void main(String[] args) {
		subSequence("abc", "");
	}

	public static void subSequence(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result + "?");
			return;
		}
		char ch = str.charAt(0);
		subSequence(str.substring(1), result);
		subSequence(str.substring(1), result + ch);
	}
}