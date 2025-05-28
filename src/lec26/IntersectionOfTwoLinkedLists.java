package lec26;

public class IntersectionOfTwoLinkedLists {
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

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode d = headA;
		ListNode e = headB;
		while (d != e) {
			if (d == null) {
				d = headB;
			} else {
				d = d.next;
			}
			if (e == null) {
				e = headA;
			} else {
				e = e.next;
			}
		}
		return d;
	}
}