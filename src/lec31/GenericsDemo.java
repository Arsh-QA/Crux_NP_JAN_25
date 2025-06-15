package lec31;

public class GenericsDemo {

	public static void main(String[] args) {
		Integer[] arr = { 10, 2, 4, 5, 6 };
		display(arr);
		String[] arr1 = { "Raj", "Ankit", "Ankita", "Anku" };
		display(arr1);
		System.out.println(get(arr));
		System.out.println(get(arr1));
	}

	private static <T> void display(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static <T> T get(T[] arr) {
		return arr[0];
	}
}