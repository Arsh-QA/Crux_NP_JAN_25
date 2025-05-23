package recursionAssignment;

import java.util.Scanner;

public class TowerOfHanoi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		toh(n, "A", "C", "B");
		sc.close();
	}

	public static void toh(int n, String src, String hlp, String dest) {
		if (n == 0)
			return;
		toh(n - 1, src, dest, hlp);
		System.out.println("Moving ring " + n + " from " + src + " to " + dest);
		toh(n - 1, hlp, src, dest);
	}
}