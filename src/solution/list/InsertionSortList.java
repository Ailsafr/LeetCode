package solution.list;

/**
 * @author By RuiCUI
 * 2019-10-29
 * Medium
 * Question 147:Insertion Sort List.
 * Sort a linked list using insertion sort.
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 * Algorithm of Insertion Sort:
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5.
 */
public class InsertionSortList {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 */
	public static ListNode insertionSortList(ListNode head) {
		if (head==null || head.next==null) {
			return head;
		}
		ListNode ln = new ListNode(Integer.MIN_VALUE);
		ln.next = new ListNode(head.val);
		head = head.next;
		ListNode first = ln;
		ListNode second = ln.next;
		while (head!=null) {
			int value = head.val;
			ListNode tmp = new ListNode(value);
			while (second!=null) {
				if (second.val>value) {
					first.next = tmp;
					tmp.next = second;
					first = ln;
					second = ln.next;
					break;
				} else{
					first = first.next;
					second = second.next;
				}
			}
			if (second==null) {
				first.next = tmp;
				first = ln;
				second = ln.next;
			}
			head = head.next;
		}
		return ln.next;
    }

	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList2(ListNode head) {
	    ListNode helper=new ListNode(0);
	    ListNode pre=helper;
	    ListNode current=head;
	    while(current!=null) {
	        pre=helper;
	        while(pre.next!=null&&pre.next.val<current.val) {
	            pre=pre.next;
	        }
	        ListNode next=current.next;
	        current.next=pre.next;
	        pre.next=current;
	        current=next;
	    }
	    return helper.next;
	}
	 
	public static void main(String[] args) {
		ListNode l1 = new ListNode(-1);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(0);
		System.out.println(insertionSortList(l1));
	}

}