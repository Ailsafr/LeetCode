package solution.list;

/**
 * @author By RuiCUI
 * 2019-08-09
 * Medium
 * Question 86:Partition List.
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5.
 */
public class PartitionList {
	
	/**
	 * 我自己写的方法   
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param head
	 * @param x
	 * @return
	 */
	public static ListNode partition(ListNode head, int x) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode smaller = new ListNode(0);
		ListNode bigger = new ListNode(0);
		ListNode l1 = smaller;
		ListNode l2 = bigger;
		while(head!=null){
			if(head.val<x){
				smaller.next = new ListNode(head.val);
				smaller = smaller.next;
			}else{
				bigger.next = new ListNode(head.val);
				bigger = bigger.next;
			}
			head = head.next;
		}
		smaller.next = l2.next;
		return l1.next;
    }
	
	/**
	 * 答案--Two Pointer Approach
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition1(ListNode head, int x) {

        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }
	
	public static void main(String[] args) {
		ListNode l6 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(4);
		ListNode l1 = new ListNode(1);
		l5.next = l6;
		l4.next = l5;
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;
		int x = 3;
		System.out.println(partition(l1,x));
	}

}
