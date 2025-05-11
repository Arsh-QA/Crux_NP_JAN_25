package lec15;

public class IsSortedArray2 {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 5, 5, 7, 9 };
		System.out.println(isSortedArray(arr, 0));
	}

	public static boolean isSortedArray(int[] arr, int idx) {
		if (idx == arr.length - 1)
			return true;
		if (arr[idx] > arr[idx + 1])
			return false;
		return isSortedArray(arr, idx + 1);
	}
}