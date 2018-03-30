package solution.list;

/**
 * @author By RuiCUI
 * 2018-01-04
 * Easy
 * Question 021:Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
	
	/**
	 * 我自己写的方法  错误的  想不通怎么用next 感觉链表没学好  笨笨的
	 * 时间复杂度：O(n2) n的平方
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = null;
		if(l1==null){
			return l2;
		}else if(l2==null){
			return l1;
		}
		if(l1.val>=l2.val){
			result = new ListNode(l2.val);
			l2 = l2.next;
		}else{
			result = new ListNode(l1.val);
			l2 = l1.next;
		}
		do{
			if(l1==null){
				result.next = l2;
				break;
			}else if(l2==null){
				result.next = l1;
				break;
			}else if(l1.val>=l2.val){
				result.next = new ListNode(l2.val);
				l2 = l2.next;
			}else{
				result.next = new ListNode(l1.val);
				l1 = l1.next;
			}
		}while(l1!=null||l2!=null);
		return result;
    }
	
	
	/**
	 * 答案1--递归
	 * 时间复杂度：O(n+m)
	 * 空间复杂度：O(n+m)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        
    }
	
	/**
	 * 答案2--迭代
	 * 时间复杂度：O(n+m)
	 * 空间复杂度：O(1)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        
        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		//ListNode l1 = null;
		//ListNode l2 = null;
		System.out.println(mergeTwoLists(l1,l2));
	}

}
