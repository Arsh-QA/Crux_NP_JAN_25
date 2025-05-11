package lec11;

public class WavePrint {

	public static void main(String[] args) {
		int[][] arr = { { 2, 3, 4, 1 }, { 21, 12, 6, 8 }, { 10, 20, 30, 40 } };// hard code array
		print(arr);
	}

	public static void print(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + " ");
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col] + " ");
				}
			}
		}
	}
}