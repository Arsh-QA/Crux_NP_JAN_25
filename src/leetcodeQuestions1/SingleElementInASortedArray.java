package leetcodeQuestions1;

public class SingleElementInASortedArray {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		System.out.println(singleNonDuplicate(nums));
	}

	public static int singleNonDuplicate(int[] nums) {
		return nonDuplicate(nums, 0, nums.length - 1);
	}

	public static int nonDuplicate(int[] nums, int low, int high) {
		if (low == high) {
			return nums[low];
		}
		int mid = low + (high - low) / 2;

		if (mid % 2 == 1) {
			mid--;
		}

		if (nums[mid] == nums[mid + 1]) {
			return nonDuplicate(nums, mid + 2, high);
		} else {
			return nonDuplicate(nums, low, mid);
		}
	}

	public static int method2(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;

			// Ensure mid is even for proper pairing
			if (mid % 2 == 1)
				mid--;

			// Pair is valid, so single element is on the right
			if (nums[mid] == nums[mid + 1]) {
				low = mid + 2;
			} else {
				// Single element is on the left, including mid
				high = mid;
			}
		}

		return nums[low];
	}
}