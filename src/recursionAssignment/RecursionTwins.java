package recursionAssignment;

import java.util.Scanner;

public class RecursionTwins {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ques = sc.next();
		System.out.println(countTwins(ques, 0));
		sc.close();
	}

	public static int countTwins(String ques, int idx) {
		if (idx == ques.length() - 2) {
			return 0;
		}
		int count = 0;
		if (ques.charAt(idx) == ques.charAt(idx + 2)) {
			count++;
		}
		count += countTwins(ques, idx + 1);
		return count;
	}
}