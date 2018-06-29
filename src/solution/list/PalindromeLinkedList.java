package solution.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2018-06-29
 * Easy
 * Question 234:Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.
 * Example 1:
 * Input: 1->2
 * Output: false
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
	
	/**
	 * 我自己写的方法   
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode head) {
		if(head==null||head.next==null){
			return true;
		}
		List<Integer> list = new ArrayList<Integer>();
		while(head!=null){
			list.add(head.val);
			head = head.next;
		}
		int len = list.size();
		for(int i=0;i<len/2;i++){
			if(list.get(i).intValue()!=list.get(len-i-1).intValue()){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public boolean isPalindrome1(ListNode head) {
	    ListNode fast = head, slow = head;
	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    if (fast != null) { // odd nodes: let right half smaller
	        slow = slow.next;
	    }
	    slow = reverse(slow);
	    fast = head;
	    
	    while (slow != null) {
	        if (fast.val != slow.val) {
	            return false;
	        }
	        fast = fast.next;
	        slow = slow.next;
	    }
	    return true;
	}

	public ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public boolean isPalindrome2(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = p1.next;
        ListNode pre = p1;
        //find mid pointer, and reverse head half part
        while(p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            pre = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = pre;
        }

        //odd number of elements, need left move p1 one step
        if(p2.next == null) {
            p1 = p1.next;
        }
        else {   //even number of elements, do nothing
            
        }
        //compare from mid to head/tail
        while(p3 != null) {
            if(p1.val != p3.val) {
                return false;
            }
            p1 = p1.next;
            p3 = p3.next;
        }
        return true;
        
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode root;
	public boolean isPalindrome3(ListNode head) {
	    root = head;
	    return (head == null) ? true : _isPalindrome(head);
	}

	public boolean _isPalindrome(ListNode head) {
	    boolean flag = true;
	    if (head.next != null) {
	        flag = _isPalindrome(head.next);
	    }
	    if (flag && root.val == head.val) {
	        root = root.next;
	        return true;
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(-129);
		l1.next = new ListNode(-129);
		//l1.next.next = new ListNode(-2);
		//l1.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(l1));
	}

}
