package dpAssignment;

import java.util.*;

public class UniqueNumberI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int xor = 0;

		for (int i = 0; i < n; i++) {
			xor ^= sc.nextInt();
		}

		System.out.println(xor);

		sc.close();

	}
}