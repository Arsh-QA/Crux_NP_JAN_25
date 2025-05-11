package lec11;

public class TransposeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 2, 3, 1, 4 }, { 5, 6, 7, 9 }, { 8, 12, 11, 10 }, { 16, 15, 14, 13 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		transpose(arr);
		System.out.println("Transposed Array : ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void transpose(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}
}