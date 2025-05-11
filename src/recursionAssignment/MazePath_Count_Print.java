package recursionAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazePath_Count_Print {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<String> al = new ArrayList<>();
		mazePath(0, 0, n - 1, m - 1, "", al);
		System.out.println();
		System.out.println(al.size());
		sc.close();
	}

	public static void mazePath(int cr, int cc, int n, int m, String ans, List<String> al) {
		if (cr == n && cc == m) {
			System.out.print(ans + " ");
			al.add(ans);
			return;
		}
		if (cr > n || cc > m)
			return;
		mazePath(cr + 1, cc, n, m, ans + "V", al);
		mazePath(cr, cc + 1, n, m, ans + "H", al);
	}
}