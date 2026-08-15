package reviseBitMasking;

public class SingleNumber1 {
	public static void main(String[] args) {
		int[] arr = { 4, 1, 2, 1, 2 };
		System.out.println(singleNumber(arr));
	}

	public static int singleNumber(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans ^= arr[i];// ans = ans ^ arr[i]
		}
		return ans;
	}
}