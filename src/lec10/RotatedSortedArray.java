package lec10;

public class RotatedSortedArray {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
		int item = 0;
		System.out.println(search(arr, item));
	}

	public static int search(int[] arr, int item) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == item) {
				return mid;
			} else if (arr[mid] >= arr[low]) {// upper line par hai
				if (arr[low] <= item && arr[mid] > item) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {// lower line par hai
				if (arr[high] >= item && arr[mid] < item) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
}