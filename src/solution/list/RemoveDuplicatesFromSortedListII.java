package solution.list;

/**
 * @author By RuiCUI
 * 2019-08-08
 * Medium
 * Question 82:Remove Duplicates from Sorted List II.
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }

	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates1(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }
	 
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates2(ListNode head) {
	    if (head == null) return null;
	    
	    if (head.next != null && head.val == head.next.val) {
	        while (head.next != null && head.val == head.next.val) {
	            head = head.next;
	        }
	        return deleteDuplicates2(head.next);
	    } else {
	        head.next = deleteDuplicates2(head.next);
	    }
	    return head;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates3(ListNode head) {
		//use two pointers, slow - track the node before the dup nodes, 
		// fast - to find the last node of dups.
	    ListNode dummy = new ListNode(0), fast = head, slow = dummy;
	    slow.next = fast;
	    while(fast != null) {
	    	while (fast.next != null && fast.val == fast.next.val) {
	     		fast = fast.next;    //while loop to find the last node of the dups.
	    	}
	    	if (slow.next != fast) { //duplicates detected.
	    		slow.next = fast.next; //remove the dups.
	    		fast = slow.next;     //reposition the fast pointer.
	    	} else { //no dup, move down both pointer.
	    		slow = slow.next;
	    		fast = fast.next;
	    	}
	    	
	    }
	    return dummy.next;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates4(ListNode head) {
	    ListNode dummy = new ListNode(0);
	    ListNode d = dummy;
	    while (head != null) {
	        if (head.next != null && head.val == head.next.val) {
	            while (head.next != null && head.val == head.next.val)
	                head = head.next;
	        } else {
	            d.next = head;
	            d = d.next;
	        }
	        head = head.next;
	    }
	    d.next = null;
	    return dummy.next;
	}
	 
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(3);
		l1.next.next.next.next = new ListNode(4);
		l1.next.next.next.next.next = new ListNode(4);
		l1.next.next.next.next.next.next = new ListNode(5);
		System.out.println(deleteDuplicates(l1));
	}

}