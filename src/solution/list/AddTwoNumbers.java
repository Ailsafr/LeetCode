package solution.list;

import solution.list.ListNode;

/**
 * @author By RuiCUI
 * 2019-05-27
 * Medium
 * Question 2:Add Two Numbers.
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode temp = result;
		int addOne = 0;
		while(l1!=null||l2!=null){
			int m = l1==null?0:l1.val;
			int n = l2==null?0:l2.val;
			int sum = m + n + addOne;
			addOne = sum/10;
			temp.next = new ListNode(sum%10);
			temp = temp.next;
			l1 = l1==null?null:l1.next;
			l2 = l2==null?null:l2.next;
		}
		if(addOne>0){
			temp.next = new ListNode(addOne);
		}
		return result.next;
    }
	
	/**
	 * 答案--Elementary Math
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
	public static void main(String[] args) {
		ListNode l13 = new ListNode(3);
		ListNode l12 = new ListNode(4);
		ListNode l1 = new ListNode(2);
		l12.next = l13;
		l1.next = l12;
		ListNode l23 = new ListNode(4);
		ListNode l22 = new ListNode(6);
		ListNode l2 = new ListNode(5);
		l22.next = l23;
		l2.next = l22;
		System.out.println(addTwoNumbers(l1,l2));
	}

}
