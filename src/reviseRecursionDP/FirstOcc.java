package reviseRecursionDP;

public class FirstOcc {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 3, 5, 6, 3, 7, 3, 56, 3, 11 };
		int item = 3;
		System.out.println(firstOcc(arr, item, 0));
	}

	public static int firstOcc(int arr[], int item, int idx) {
		if (idx == arr.length)
			return -1;
		if (arr[idx] == item)
			return idx;
		return firstOcc(arr, item, idx + 1);
	}
}