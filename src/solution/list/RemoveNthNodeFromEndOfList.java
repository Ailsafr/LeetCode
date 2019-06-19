package solution.list;

import solution.list.ListNode;

/**
 * @author By RuiCUI
 * 2019-06-19
 * Medium
 * Question 19:Remove Nth Node From End of List.
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Follow up:
 * Could you do this in one pass?
 * Hint:
 * Maintain two pointers and update one with a delay of n steps.
 */
public class RemoveNthNodeFromEndOfList {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(n==0){
			return head;
		}
		if(head.next==null||head==null){
			return null;
		}
		int i = 1;
		ListNode temp = head;
		ListNode result = temp;
		while(head.next!=null){
			if(i>n){
				temp = temp.next;
			}
			i++;
			head = head.next;
		}
		if(i<=n){
			return result.next;
		}
		temp.next = temp.next.next;
		return result;
    }
	
	/**
	 * 答案1--Two pass algorithm
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd1(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    int length  = 0;
	    ListNode first = head;
	    while (first != null) {
	        length++;
	        first = first.next;
	    }
	    length -= n;
	    first = dummy;
	    while (length > 0) {
	        length--;
	        first = first.next;
	    }
	    first.next = first.next.next;
	    return dummy.next;
	}
	
	/**
	 * 答案2--One pass algorithm
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd2(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    // Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l4.next = l5;
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;
		int n = 2;
		System.out.println(removeNthFromEnd(l1,n));
	}

}
