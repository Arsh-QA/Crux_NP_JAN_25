package arrayAssignment;

import java.util.Scanner;

public class PatientsSeverityLevel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		dutchNationalFlag(arr);
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
		sc.close();
	}

	public static void dutchNationalFlag(int[] arr) {
		int w = 0;
		int p = arr.length - 1;
		int i = 0;
		while (i <= p) {
			if (arr[i] == 0) {
				int temp = arr[w];
				arr[w] = arr[i];
				arr[i] = temp;
				w++;
				i++;
			} else if (arr[i] == 2) {
				int temp = arr[p];
				arr[p] = arr[i];
				arr[i] = temp;
				p--;
			} else {
				i++;
			}
		}
	}
}