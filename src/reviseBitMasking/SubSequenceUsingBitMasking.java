package reviseBitMasking;

public class SubSequenceUsingBitMasking {

	public static void main(String[] args) {
		String s = "abc";
		printSubSequence(s);
	}

	public static void printSubSequence(String s) {
		int n = s.length();
		for (int i = 0; i < (1 << n); i++) {
			pattern(s, i);
		}
	}

	private static void pattern(String s, int i) {
		int pos = 0;
		while (i > 0) {
			if ((i & 1) != 0) {
				System.out.print(s.charAt(pos));
			}
			i >>= 1;
			pos++;
		}
		System.out.println();
	}
}