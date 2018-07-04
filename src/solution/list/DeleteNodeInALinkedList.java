package solution.list;

/**
 * @author By RuiCUI
 * 2018-07-04
 * Easy
 * Question 237:Delete Node in a Linked List
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * 4 -> 5 -> 1 -> 9
 * Example 1:
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list
 * should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list
 * should become 4 -> 5 -> 9 after calling your function.
 * Note:
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 */
public class DeleteNodeInALinkedList {
	
	/**
	 * 我自己写的方法   只有node怎么做呢？~看了答案恍然大悟~
	 * 时间复杂度：O(1) 
	 * 空间复杂度：O(1)
	 * @param node
	 * @return
	 */
	public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
	
	/**
	 * 答案1--Swap with Next Node
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param node
	 * @return
	 */
	public void deleteNode1(ListNode node) {
	    node.val = node.next.val;
	    node.next = node.next.next;
	}
	
	public static void main(String[] args) {
		
	}

}
