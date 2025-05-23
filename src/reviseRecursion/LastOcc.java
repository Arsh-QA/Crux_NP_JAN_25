package reviseRecursion;

public class LastOcc {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 3, 5, 6, 3, 7, 3, 56, 3, 11 };
		int item = 3;
		System.out.println(lastOcc(arr, item, arr.length - 1));
	}

	public static int lastOcc(int[] arr, int item, int i) {
		if (i < 0) {
			return -1;
		}
		if (arr[i] == item)
			return i;
		return lastOcc(arr, item, i - 1);
	}
}