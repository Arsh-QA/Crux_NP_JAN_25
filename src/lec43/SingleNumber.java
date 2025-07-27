package lec43;

public class SingleNumber {
	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2 };
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans = ans ^ nums[i];
		}
		System.out.println(ans);
	}
}
