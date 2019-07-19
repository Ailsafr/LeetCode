package solution.list;

import java.util.LinkedList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-07-19
 * Medium
 * Question 61:Rotate List.
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL.
 * rotate 2 steps to the right: 1->2->0->NULL.
 * rotate 3 steps to the right: 0->1->2->NULL.
 * rotate 4 steps to the right: 2->0->1->NULL.
 */
public class RotateList {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode tmp = head;
		int len = 0;
		while(head!=null){
			len++;
			head = head.next;
		}
		k = k % len;
		if(k==0){
			return tmp;
		}else{
			List<Integer> list = new LinkedList<Integer>();
			int num = len - k;
			while(num>0){
				list.add(tmp.val);
				num--;
				tmp = tmp.next;
			}
			ListNode result = tmp;
			while(tmp.next!=null){
				tmp = tmp.next;
			}
			while(list.size()>0){
				tmp.next = new ListNode(list.remove(0));
				tmp = tmp.next;
			}
			return result;
		}
    }

	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode rotateRight1(ListNode head, int k) {
	    if (head==null||head.next==null) return head;
	    ListNode dummy=new ListNode(0);
	    dummy.next=head;
	    ListNode fast=dummy,slow=dummy;

	    int i;
	    for (i=0;fast.next!=null;i++)//Get the total length 
	    	fast=fast.next;
	    
	    for (int j=i-k%i;j>0;j--) //Get the i-n%i th node
	    	slow=slow.next;
	    
	    fast.next=dummy.next; //Do the rotation
	    dummy.next=slow.next;
	    slow.next=null;
	    
	    return dummy.next;
	}
	 
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode rotateRight2(ListNode head, int k) {
	    if(head == null || k == 0) {
	        return head;
	    }
	    ListNode p = head;
	    int len = 1;
	    while(p.next != null) {
	        p = p.next;
	        len++;
	    }
	    p.next = head;
	    k %= len;
	    for(int i = 0; i < len - k; i++) {
	        p = p.next;
	    }
	    head = p.next;
	    p.next = null;
	    return head;
	}
	 
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		int k = 2;
		System.out.println(rotateRight(l1,k));
	}

}
