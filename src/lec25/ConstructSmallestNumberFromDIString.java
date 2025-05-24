package lec25;

import java.util.Stack;

public class ConstructSmallestNumberFromDIString {

	public static void main(String[] args) {
		String str = "IIIDIDDD";
		System.out.println(constructSmallestNumber(str));
	}

	public static String constructSmallestNumber(String s) {
		int[] arr = new int[s.length() + 1];
		Stack<Integer> st = new Stack<>();
		int count = 1;
		for (int i = 0; i <= s.length(); i++) {
			if (i == s.length() || s.charAt(i) == 'I') {
				arr[i] = count++;
				while (!st.isEmpty()) {
					arr[st.pop()] = count++;
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