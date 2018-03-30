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
	 * ���Լ�д�ķ���   ���һ�´��ܵ���������֮ǰ��ôҲ�벻ͨ><
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(n)
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
	 * ��1--Hash Table
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
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
	 * ��2--Two Pointers
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
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
