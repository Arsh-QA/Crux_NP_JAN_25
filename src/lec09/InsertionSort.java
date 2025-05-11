package lec09;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 9, 4, 4, 5, 6, 8 };
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			insertLastElement(arr, i);
		}
	}

	public static void insertLastElement(int[] arr, int i) {
		int item = arr[i];
		int j = i - 1;
		while (j >= 0 && arr[j] > item) {
			arr[j + 1] = arr[j];
			arr[j] = item;
			j--;
		}
		// Index bola hota toh j+1 return karenge
	}
}