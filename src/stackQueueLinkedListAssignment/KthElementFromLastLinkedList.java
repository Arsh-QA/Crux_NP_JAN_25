package stackQueueLinkedListAssignment;

import java.util.Scanner;
import java.util.Stack;

public class KthElementFromLastLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		Stack<ListNode> st = new Stack<>();
		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		ListNode A = head;
		while (head != null) {
			int t = k;
			while (head != null && t > 0) {
				st.push(head);
				t--;
				head = head.next;
			}
			if (t == 0) {
				A = head;
				while (!st.isEmpty()) {
					ListNode rv = st.pop();
					dummy.next = rv;
					dummy = dummy.next;
				}
				dummy.next = null;
			} else {
				dummy.next = A;
			}
		}
		return temp.next;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList ll = new LinkedList();
		while (n != -1) {
			ll.addLast(n);
		}
		ll.display();
		sc.close();
	}
}