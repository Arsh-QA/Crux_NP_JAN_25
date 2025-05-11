package lec11;

public class SearchIn2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(search(matrix, 17));
		System.out.println("=======================");
		System.out.println(search2(matrix, 17));
	}

	public static boolean search(int[][] arr, int item) {
		int row = 0;
		int col = arr[0].length - 1;
		while (row < arr.length && col >= 0) {
			if (arr[row][col] == item) {
				System.out.println("row = " + row + " and col = " + col);
				return true;
			} else if (arr[row][col] > item) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}

	public static boolean search2(int[][] arr, int item) {
		int row = arr.length - 1;
		int col = 0;
		while (row >= 0 && col < arr[0].length) {
			if (arr[row][col] == item) {
				System.out.println("row = " + row + " and col = " + col);
				return true;
			} else if (arr[row][col] > item) {
				row--;
			} else {
				col++;
			}
		}
		return false;
	}
}