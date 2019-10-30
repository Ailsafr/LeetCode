package solution.list;

/**
 * @author By RuiCUI
 * 2019-10-30
 * Medium
 * Question 148:Sort List.
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5.
 */
public class SortList {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(nlogn) 
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public static ListNode sortList(ListNode head) {
		if (head==null || head.next==null) {
			return head;
		}
		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast!=null && fast.next!=null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		return helper(l1, l2);
    }
	private static ListNode helper(ListNode l1, ListNode l2) {
		ListNode tmp = new ListNode(0);
		ListNode result = tmp;
		while (l1!=null && l2!=null) {
			if (l1.val < l2.val) {
				tmp.next = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;
				l2 = l2.next;
			}
			tmp = tmp.next;
		}
		if (l1!=null) {
			tmp.next = l1;
		}
		if (l2!=null) {
			tmp.next = l2;
		}
		return result.next;
	}

	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode sortList1(ListNode head) {
		if (head == null || head.next == null)
		  return head;
		// step 1. cut the list to two halves
		ListNode prev = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
		  prev = slow;
		  slow = slow.next;
		  fast = fast.next.next;
		}
		prev.next = null;
		// step 2. sort each half
		ListNode l1 = sortList1(head);
		ListNode l2 = sortList1(slow);
		// step 3. merge l1 and l2
		return merge(l1, l2);
	}
	ListNode merge(ListNode l1, ListNode l2) {
	    ListNode l = new ListNode(0), p = l;
	    while (l1 != null && l2 != null) {
	    	if (l1.val < l2.val) {
	    		p.next = l1;
	    		l1 = l1.next;
	    	} else {
	    		p.next = l2;
	    		l2 = l2.next;
	    	}
	    	p = p.next;
	    }
	    if (l1 != null)
	    	p.next = l1;
	    if (l2 != null)
	    	p.next = l2;
	    return l.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(-1);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(0);
		System.out.println(sortList(l1));
	}

}