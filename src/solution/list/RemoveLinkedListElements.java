package solution.list;

/**
 * @author By RuiCUI
 * 2018-05-18
 * Easy
 * Question 203:Remove Linked List Elements.
 * Remove all elements from a linked list of integers that have value val.
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
	
	/**
	 * 我自己写的方法 -- 参考了别人写的
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param head
	 * @param val
	 * @return
	 */
	public static ListNode removeElements(ListNode head, int val) {
		if(head==null){
			return null;
		}
		head.next = removeElements(head.next,val);
		return head.val==val?head.next:head;
	}

	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @param val
	 * @return
	 */
	public static ListNode removeElements1(ListNode head, int val) {
	        if (head == null) return null;
	        head.next = removeElements(head.next, val);
	        return head.val == val ? head.next : head;
	}
	 
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements2(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements3(ListNode head, int val) {
	    if (head == null) return null;
	    ListNode pointer = head;
	    while (pointer.next != null) {
	        if (pointer.next.val == val) pointer.next = pointer.next.next;
	        else pointer = pointer.next;
	    }
	    return head.val == val ? head.next : head;
	}
	 
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		System.out.println(removeElements1(l1,4));
	}

}
