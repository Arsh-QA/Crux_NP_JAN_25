package stackQueueLinkedListAssignment;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(balanceParanthesis(s));
		sc.close();
	}

	private static boolean balanceParanthesis(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else {
				if (st.isEmpty())
					return false;
				else if (ch == ')' && (st.peek() != '(')) {
					return false;
				} else if (ch == '}' && (st.peek() != '{')) {
					return false;
				} else if (ch == '[' && (st.peek() != ']')) {
					return false;
				}
				st.pop();
			}
		}
		return st.isEmpty();
	}
}