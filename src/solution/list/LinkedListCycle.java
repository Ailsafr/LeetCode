package solution.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2018-03-30
 * Easy
 * Question 141:Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {
	
	/**
	 * 我自己写的方法   瞟了一下答案受到的启发，之前怎么也想不通><
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head) {
		if(head==null||head.next==null){
			return false;
		}
		Map<Object,Object> map = new HashMap<Object,Object>();
		while(head.next!=null){
			if(map.get(head)!=null){
				return true;
			}
			map.put(head, head);
			head = head.next;
		}
		return false;
	}
	
	/**
	 * 答案1--Hash Table
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 */
	public boolean hasCycle1(ListNode head) {
	    Set<ListNode> nodesSeen = new HashSet<>();
	    while (head != null) {
	        if (nodesSeen.contains(head)) {
	            return true;
	        } else {
	            nodesSeen.add(head);
	        }
	        head = head.next;
	    }
	    return false;
	}
	
	/**
	 * 答案2--Two Pointers
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public boolean hasCycle2(ListNode head) {
	    if (head == null || head.next == null) {
	        return false;
	    }
	    ListNode slow = head;
	    ListNode fast = head.next;
	    while (slow != fast) {
	        if (fast == null || fast.next == null) {
	            return false;
	        }
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = l1;
		System.out.println(hasCycle(l1));
	}

}
