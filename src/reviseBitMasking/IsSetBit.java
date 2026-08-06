package reviseBitMasking;

public class IsSetBit {
	public static void main(String[] args) {

		int n = 87;
		int pos = 4;
		System.out.println(isSet(n, pos));

	}

	public static boolean isSet(int n, int pos) {
		int mask = (1 << pos);
		if ((n & mask) != 0) {
			return true;
		} else {
			return false;
		}
	}
}