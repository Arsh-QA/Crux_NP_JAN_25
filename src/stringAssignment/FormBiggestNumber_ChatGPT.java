package stringAssignment;

import java.util.Scanner;

public class FormBiggestNumber_ChatGPT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.next();
			}
			System.out.println(formBiggestNumber(arr));
			t--;
		}
		sc.close();

	}

	public static String formBiggestNumber(String[] arr) {
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			if ((result + arr[i]).compareTo(arr[i] + result) >= 0) {
				result += arr[i];
			} else {
				result = arr[i] + result;
			}
		}

		// Edge case: If largest number starts with "0", return "0"
		if (arr[0].equals("0")) {
			return "0";
		}

		return result;
	}
}