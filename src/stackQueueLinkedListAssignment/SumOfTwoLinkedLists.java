package stackQueueLinkedListAssignment;

public class SumOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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

	public static ListNode reverseList(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			ListNode ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		return prev;
	}

//	public static ListNode sumOfLinkedLists(ListNode head1, ListNode head2) {
//		ListNode curr = new ListNode();
//		ListNode head = curr;
//		int total = head1.val + head2.val;
//		int nodeVal = 0;
//		int carry = 0;
//		if (total > 9) {
//			nodeVal = total % 10;
//			carry = total / 10;
//		}
//		if (carry != 0) {
//			curr.val = carry;
//			curr.next.val = total;
//			curr = curr.next;
//		} else
//			curr.val = nodeVal;
//		ListNode c = sumOfLinkedLists(head1.next, head2.next);
//		curr.next = c;
//		return head;
//	}

}
