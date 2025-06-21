package leetcodeQuestions1;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = { 2 };
		int[] nums2 = {};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1); // ensure nums1 is shorter
		}
		int x = nums1.length;
		int y = nums2.length;

		int low = 0;
		int high = x;

		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX, minRightX, maxLeftY, minRightY;

			if (partitionX == 0) {
				maxLeftX = Integer.MIN_VALUE;
			} else {
				maxLeftX = nums1[partitionX - 1];
			}

			if (partitionX == x) {
				minRightX = Integer.MAX_VALUE;
			} else {
				minRightX = nums1[partitionX];
			}

			if (partitionY == 0) {
				maxLeftY = Integer.MIN_VALUE;
			} else {
				maxLeftY = nums2[partitionY - 1];
			}

			if (partitionY == y) {
				minRightY = Integer.MAX_VALUE;
			} else {
				minRightY = nums2[partitionY];
			}

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				// correct partition
				if ((x + y) % 2 == 0) {
					return ( Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
				} else {
					return Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) {
				// Too Far Right -> Move Left
				high = partitionX - 1;
			} else {
				// Too Far Left -> Move Right
				low = partitionX + 1;
			}
		}
		throw new IllegalArgumentException("Input arrays are not sorted properly.");
	}
	
	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
	    if (nums1.length > nums2.length) {
	        return findMedianSortedArrays(nums2, nums1); // ensure nums1 is shorter
	    }

	    int x = nums1.length;
	    int y = nums2.length;
	    int low = 0, high = x;

	    while (low <= high) {
	        int partitionX = (low + high) / 2;
	        int partitionY = (x + y + 1) / 2 - partitionX;

	        int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
	        int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

	        int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
	        int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

	        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
	            if ((x + y) % 2 == 0) {
	                return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
	            } else {
	                return Math.max(maxLeftX, maxLeftY);
	            }
	        } else if (maxLeftX > minRightY) {
	            high = partitionX - 1;
	        } else {
	            low = partitionX + 1;
	        }
	    }

	    throw new IllegalArgumentException("Input arrays are not sorted correctly.");
	}

}