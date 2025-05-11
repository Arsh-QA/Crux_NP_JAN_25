package lec07;

public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a;
//		System.out.println(a);
		int arr[] = new int[5];
		System.out.println(arr);
		System.out.println(arr[2]);// 0
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 4;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		// System.out.println(arr[5]);
		System.out.println(arr.length);
	}

}
