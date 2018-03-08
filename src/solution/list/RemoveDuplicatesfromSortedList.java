package solution.list;

/**
 * @author By RuiCUI
 * 2018-03-08
 * Easy
 * Question 083:Remove Duplicates from Sorted List.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {

	/**
	 * Definition for singly-linked list.
	 */
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	 
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) n的平方
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode result = new ListNode(head.val);
		ListNode prev = new ListNode(head.val);
		boolean first = true;
		while(head.next!=null){
			if(head.val!=head.next.val){
				if(first){
					result = prev;
					first = false;
				}
				prev.next = new ListNode(head.next.val);
				prev = prev.next;
			}else{
				prev.next = null;
			}
			head = head.next;
		}
		return result;
	}
	
	/**
	 * 答案--直接的方法（比我的思维简单）
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates1(ListNode head) {
	    ListNode current = head;
	    while (current != null && current.next != null) {
	        if (current.next.val == current.val) {
	            current.next = current.next.next;
	        } else {
	            current = current.next;
	        }
	    }
	    return head;
	}
	
	/**
	 * 讨论里的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
	}
	
	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(1);
		list.next.next = new ListNode(2);
		//list.next.next.next = new ListNode(3);
		//list.next.next.next.next = new ListNode(3);
		//list.next.next.next.next.next = new ListNode(3);
		System.out.println(deleteDuplicates(list));
	}
}
