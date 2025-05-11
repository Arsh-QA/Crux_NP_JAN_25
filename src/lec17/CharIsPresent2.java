package lec17;

public class CharIsPresent2 {

	public static void main(String[] args) {
		String str = "abdbhjaijai";
		char ch = 'a';
		int i = 2;
		System.out.println(isPresent(str, ch, i));
	}

	public static boolean isPresent(String str, char ch, int idx) {
		for (int i = idx; i < str.length(); i++) {
			if (str.charAt(i) == ch)
				return true;
		}
		return false;
	}
}