package reviseBitMasking;

public class SingleNumberIII {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 2, 5 };
		int[] a = singleNumber(arr);
		System.out.println(a[0] + " " + a[1]);
	}

	public static int[] singleNumber(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans ^= arr[i];
		}

		int mask = (ans & (~(ans - 1)));
		int a = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & mask) != 0) {
				a ^= arr[i];
			}
		}
		int b = ans ^ a;

		return new int[] { a, b };
	}

}