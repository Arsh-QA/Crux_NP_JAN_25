package stackQueueLinkedListAssignment;

import java.util.Scanner;
import java.util.Stack;

public class FormMinimumNumberFromGivenSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(formMinimumNumberFromGivenSequence(arr[i]));
		}
		sc.close();
	}

	private static String formMinimumNumberFromGivenSequence(String s) {
		int[] arr = new int[s.length() + 1];
		Stack<Integer> st = new Stack<>();
		int count = 1;
		for (int i = 0; i <= s.length(); i++) {
			if (i == s.length() || s.charAt(i) == 'I') {
				arr[i] = count;
				count++;
				while (!st.isEmpty()) {
					arr[st.pop()] = count;
					count++;
				}
			} else {
				st.push(i);
			}
		}
		String ans = "";
		for (int i = 0; i < arr.length; i++) {
			ans = ans + arr[i];
		}
		return ans;
	}
}