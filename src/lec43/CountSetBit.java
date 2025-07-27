package lec43;

public class CountSetBit {

	public static void main(String[] args) {
		int n = 84;
		System.out.println(setBit(n));
		System.out.println(fastSetBit(n));
	}

	public static int fastSetBit(int n) {
		int c = 0;
		while (n > 0) {
			c++;
			n = (n & (n - 1));
		}
		return c;
	}

	public static int setBit(int n) {
		int c = 0;
		while (n > 0) {
			if ((n & 1) != 0)
				c++;
			n >>= 1; // n = n >> 1;
		}
		return c;
	}
}