package arrayAssignment;

import java.util.Scanner;

public class HowManyQuestions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = 0;
		while (n > 0) {
			int i = 3;
			int[] arr = new int[i];
			for (int j = 0; j < i; j++) {
				arr[j] = sc.nextInt();
			}
			c += problems(arr);
			n--;
		}
		System.out.println(c);
		sc.close();
	}

	public static int problems(int[] arr) {
		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1)
				c++;
		}
		if (c >= 2)
			return 1;
		else
			return 0;
	}
}