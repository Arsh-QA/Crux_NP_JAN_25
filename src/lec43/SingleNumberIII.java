package lec43;

import java.util.Arrays;

public class SingleNumberIII {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 3, 2, 5 };
		int[] result = singleNumber(nums);
		System.out.println(Arrays.toString(result));
	}

	public static int[] singleNumber(int[] nums) {
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor = xor ^ nums[i];
		}
		int mask = (xor & (-xor));
		int a = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((mask & nums[i]) != 0) {
				a ^= nums[i];
			}
		}
		int b = (xor ^ a);
		return new int[] { a, b };
	}
}