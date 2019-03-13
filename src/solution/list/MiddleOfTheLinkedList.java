package solution.list;

/**
 * @author By RuiCUI
 * 2019-03-13
 * Easy
 * Question 876:Middle of the Linked List.
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * Note:
 * The number of nodes in the given list will be between 1 and 100.
 */
public class MiddleOfTheLinkedList {
	
	/**
	 * 我自己写的方法   
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public static ListNode middleNode(ListNode head) {
		ListNode tmpList = head;
		int len = 1;
		while(tmpList.next!=null){
			len += 1;
			tmpList = tmpList.next;
		}
		int i = 0;
		while(i<len/2){
			head = head.next;
			i++;
		}
		return head;
    }
	
	/**
	 * 答案1--Output to Array
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 */
	public ListNode middleNode1(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head.next != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }
	
	/**
	 * 答案2--Fast and Slow Pointer
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
	
	public static void main(String[] args) {
		ListNode l6 = new ListNode(6);
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);
		l5.next = l6;
		l4.next = l5;
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;
		System.out.println(middleNode(l1));
	}

}
