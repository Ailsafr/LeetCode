package solution.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-10-23
 * Medium
 * Question 142:Linked List Cycle II.
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * Note: Do not modify the linked list.
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * Follow-up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public static ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				ListNode slow2 = head; 
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
			}
		}
		return null;
    }

	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode detectCycle1(ListNode head) {
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				while (head != slow) {
					head = head.next;
					slow = slow.next;
				}
				return slow;				
			}
		}			
		return null;
	}
	 
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 */
	public ListNode detectCycle2(ListNode head) {
        Set<ListNode> h=new HashSet<>();
        ListNode temp=head;
        while(temp!=null){
            if(h.contains(temp)){
                return temp;
            }
            h.add(temp);
            temp=temp.next;
        }
        return null;
    }
	 
	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(0);
		l1.next.next.next = new ListNode(-4);
		System.out.println(detectCycle(l1));
	}

}
