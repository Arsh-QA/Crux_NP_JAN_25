package heapHashMapAssignment;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExistORNot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int L = sc.nextInt();
			Set<Integer> set = new HashSet<Integer>();

			// Read Array elements
			for (int i = 0; i < L; i++) {
				set.add(sc.nextInt());
			}

			int Q = sc.nextInt();

			// Process each query
			for (int i = 0; i < Q; i++) {
				int num = sc.nextInt();
				if (set.contains(num)) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
		sc.close();
	}
}