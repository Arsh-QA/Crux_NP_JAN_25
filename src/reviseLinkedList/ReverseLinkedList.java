package reviseLinkedList;

public class ReverseLinkedList {
	class ListNode {
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

	class Solution {
		public ListNode reverseList(ListNode head) {
			ListNode prev = null;
			ListNode curr = head;
			ListNode ahead = curr;
			while (curr != null) {
				ahead = curr.next;
				curr.next = prev;
				prev = curr;
				curr = ahead;
			}
			return prev;
		}

		public ListNode reverseListRecursion(ListNode head) {
			return reverse(head, null);
		}

		public ListNode reverse(ListNode curr, ListNode prev) {
			if (curr == null)
				return prev;
			ListNode temp = reverse(curr.next, curr);
			curr.next = prev;
			return temp;
		}
	}
}
