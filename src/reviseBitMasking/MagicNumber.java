package reviseBitMasking;

public class MagicNumber {
	public static void main(String[] args) {
		int n = 9;
		System.out.println(nThMagicNumber(n));
	}

	public static int nThMagicNumber(int n) {
		int ans = 0;
		int mul = 5;
		while (n > 0) {
			if ((n & 1) != 0) {
				ans = ans + mul;
			}
			mul = mul * 5;
			n = n >> 1;
		}
		return ans;
	}
}