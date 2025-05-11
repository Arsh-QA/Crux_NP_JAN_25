package lec08HW;

public class PartitionArrayIntoDisjointIntervals {
	public static void main(String[] args) {
		int[] num = { 90, 47, 69, 10, 43, 92, 31, 73, 61, 97 };
		System.out.println(partitionArrayDisjoint(num));
	}

	// 1st Solution :
	public static int partitionArrayDisjoint(int[] arr) {
		int partitionIdx = 0;
		int maxLeft = arr[0];
		int globalMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < maxLeft) {
				partitionIdx = i;
				maxLeft = globalMax;
			} else {
				globalMax = Math.max(globalMax, arr[i]);
			}
		}
		return partitionIdx + 1;
	}

	// 2nd Solution :
	public static int partitionDisjoints(int[] arr) {
		int n = arr.length;
		int[] maxLeft = new int[n];
		int[] minRight = new int[n];

		// Construct maxLeft Array
		maxLeft[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
		}

		// Construct minRight Array
		minRight[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			minRight[i] = Math.min(minRight[i + 1], arr[i]);
		}

		// Find partition Index
		for (int i = 0; i < n - 1; i++) {
			if (maxLeft[i] <= minRight[i + 1]) {
				return i + 1;
			}
		}
		return -1;// Should never reach here
	}

}