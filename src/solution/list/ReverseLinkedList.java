package solution.list;

/**
 * @author By RuiCUI
 * 2018-05-23
 * Easy
 * Question 206:Reverse Linked List.
 * Reverse a singly linked list.
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
	
	/**
	 * ���Լ�д�ķ���--����1һ��
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
	    ListNode curr = head;
	    while (curr != null) {
	        ListNode nextTemp = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr = nextTemp;
	    }
	    return prev;
    }
	
	/**
	 * ��1--Iterative
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param head
	 * @return
	 */
	public ListNode reverseList1(ListNode head) {
	    ListNode prev = null;
	    ListNode curr = head;
	    while (curr != null) {
	        ListNode nextTemp = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr = nextTemp;
	    }
	    return prev;
	}
	
	/**
	 * ��1--Recursive
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param head
	 * @return
	 */
	public static ListNode reverseList2(ListNode head) {
	    if (head == null || head.next == null) return head;
	    ListNode p = reverseList2(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		System.out.println(reverseList2(l1));
	}

}
