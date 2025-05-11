package lec21;

public class Partition_In_Array {

	public static void main(String[] args) {
		int[] arr = { 5, 7, 2, 1, 8, 3, 4 };
		partition(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void partition(int[] arr, int si, int ei) {
		int item = arr[ei];
		int idx = si;
		for (int i = si; i < ei; i++) {
			if (arr[i] < item) {
				int t = arr[i];
				arr[i] = arr[idx];
				arr[idx] = t;
				idx++;
			}
		}
		int t = arr[ei];
		arr[ei] = arr[idx];
		arr[idx] = t;
		// return idx;
	}
}