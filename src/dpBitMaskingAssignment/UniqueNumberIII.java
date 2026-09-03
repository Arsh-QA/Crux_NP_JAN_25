package dpBitMaskingAssignment;

import java.util.Scanner;

public class UniqueNumberIII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		// Take Input
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int unique = 0;

		// Check All 32 bits
		for (int bit = 0; bit < 32; bit++) {
			int count = 0;

			// check this bit in every number
			for (int num : arr) {

				// If current bit is 1
				if ((num & (1 << bit)) != 0) {
					count++;
				}
			}

			// Number appearing 3 times contributes
			// a multiple of 3
			// Any remaining 1 belongs to the unique number
			if (count % 3 != 0) {
				unique = unique | (1 << bit);
			}
		}
		System.out.println(unique);
		sc.close();
	}
}