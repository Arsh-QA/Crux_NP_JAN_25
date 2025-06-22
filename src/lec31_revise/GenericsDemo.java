package lec31_revise;

public class GenericsDemo {

	public static void main(String[] args) {
		String[] arr = { "Raj", "Ankit", "Ankita", "Anku" };
		display(arr);
		Integer[] arr1 = { 1, 2, 3, 4, 5 };
		display(arr1);
	}

	public static <T> void display(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}