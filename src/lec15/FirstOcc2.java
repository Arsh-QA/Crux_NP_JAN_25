package lec15;

public class FirstOcc2 {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 5, 4, 7, 6 };
		int item = 4;
		System.out.println(firstOcc(arr, item, 0));
	}

	public static int firstOcc(int[] arr, int item, int idx) {
		if (idx == arr.length)
			return -1;
		if (item == arr[idx])
			return idx;
		return firstOcc(arr, item, idx + 1);
	}
}