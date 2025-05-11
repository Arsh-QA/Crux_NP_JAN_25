package lec07;

public class SwapDemo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40, 50 };
//		int[] arr1 = new int []{ 10, 20, 30, 40, 50 };
		System.out.println(arr[0] + " " + arr[1]);// 10 20
		Swap(arr[0], arr[1]);
		System.out.println(arr[0] + " " + arr[1]);// ??

	}

	public static void Swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

}