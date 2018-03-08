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
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n) n��ƽ��
	 * �ռ临�Ӷȣ�O(1)
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
	 * ��--ֱ�ӵķ��������ҵ�˼ά�򵥣�
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
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
	 * ������Ĵ�
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
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
