package solution.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-04-10
 * Easy
 * Question 160:Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 → a2
                   		↘
                     	c1 → c2 → c3
                   		↗            
   B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns. 
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {

	/**
	 * 我自己写的方法   
	 * 时间复杂度：O(nm) 【Time Limit Exceeded】 
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode la = headA;
		ListNode lb = headB;
		while(la!=null){
			while(lb!=null){
				if(la==lb){
					return la;
				}
				lb = lb.next;
			}
			la = la.next;
			lb = headB;
		}
		return la;
    }
	
	/**
	 * 我自己写的方法   
	 * 时间复杂度：O(n+m) 
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 */
	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		ListNode la = headA;
		ListNode lb = headB;
		Map<ListNode,ListNode> map = new HashMap<ListNode,ListNode>();
		while(la!=null){
			map.put(la, la);
			la = la.next;
		}
		while(lb!=null){
			if(map.containsKey(lb)){
				return lb;
			}
			lb = lb.next;
		}
		return lb;
    }
	
	/**
	 * 别人写的--利用长度差
	 * 时间复杂度：O(n+m)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
	    int lenA = length(headA), lenB = length(headB);
	    // move headA and headB to the same start point
	    while (lenA > lenB) {
	        headA = headA.next;
	        lenA--;
	    }
	    while (lenA < lenB) {
	        headB = headB.next;
	        lenB--;
	    }
	    // find the intersection until end
	    while (headA != headB) {
	        headA = headA.next;
	        headB = headB.next;
	    }
	    return headA;
	}

	private int length(ListNode node) {
	    int length = 0;
	    while (node != null) {
	        node = node.next;
	        length++;
	    }
	    return length;
	}
	
	/**
	 * 答案3--答案1和2就是我写的前两个
	 * 时间复杂度：O(n+m)
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 */
	public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
	    //boundary check
	    if(headA == null || headB == null) return null;
	    
	    ListNode a = headA;
	    ListNode b = headB;
	    
	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }
	    
	    return a;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(8);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = l3;
		l2.next = l3;
		System.out.println(getIntersectionNode1(l1,l2));
	}

}
