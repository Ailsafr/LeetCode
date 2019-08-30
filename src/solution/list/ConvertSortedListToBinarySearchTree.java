package solution.list;

import java.util.ArrayList;
import java.util.List;

import solution.tree.TreeNode;

/**
 * @author By RuiCUI
 * 2019-08-30
 * Medium
 * Question 109:Convert Sorted List to Binary Search Tree.
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example:
 * Given the sorted linked list: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
	      0
	     / \
	   -3   9
	   /   /
	 -10  5
 */
public class ConvertSortedListToBinarySearchTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 */
	public static TreeNode sortedListToBST(ListNode head) {
	    if (head == null) {
	      return null;
	    }
	    ListNode mid = helper(head);
	    TreeNode node = new TreeNode(mid.val);
	    if (head == mid) {
	      return node;
	    }
	    node.left = sortedListToBST(head);
	    node.right = sortedListToBST(mid.next);
	    return node;
	}
	private static ListNode helper(ListNode head) {
	    ListNode prevPtr = null;
	    ListNode slowPtr = head;
	    ListNode fastPtr = head;
	    while (fastPtr != null && fastPtr.next != null) {
	      prevPtr = slowPtr;
	      slowPtr = slowPtr.next;
	      fastPtr = fastPtr.next.next;
	    }
	    if (prevPtr != null) {
	      prevPtr.next = null;
	    }
	    return slowPtr;
	}
	
	/**
	 * 答案1--Recursion
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(logn)
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBST1(ListNode head) {
	    // If the head doesn't exist, then the linked list is empty
	    if (head == null) {
	      return null;
	    }
	    // Find the middle element for the list.
	    ListNode mid = this.findMiddleElement(head);
	    // The mid becomes the root of the BST.
	    TreeNode node = new TreeNode(mid.val);
	    // Base case when there is just one element in the linked list
	    if (head == mid) {
	      return node;
	    }
	    // Recursively form balanced BSTs using the left and right halves of the original list.
	    node.left = this.sortedListToBST1(head);
	    node.right = this.sortedListToBST1(mid.next);
	    return node;
	}
	private ListNode findMiddleElement(ListNode head) {
	    // The pointer used to disconnect the left half from the mid node.
	    ListNode prevPtr = null;
	    ListNode slowPtr = head;
	    ListNode fastPtr = head;
	    // Iterate until fastPr doesn't reach the end of the linked list.
	    while (fastPtr != null && fastPtr.next != null) {
	      prevPtr = slowPtr;
	      slowPtr = slowPtr.next;
	      fastPtr = fastPtr.next.next;
	    }
	    // Handling the case when slowPtr was equal to head.
	    if (prevPtr != null) {
	      prevPtr.next = null;
	    }
	    return slowPtr;
	}
	
	/**
	 * 答案2--Recursion + Conversion to Array
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(logn)
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBST2(ListNode head) {
	    // Form an array out of the given linked list and then
	    // use the array to form the BST.
	    this.mapListToValues(head);
	    // Convert the array to
	    return convertListToBST(0, this.values.size() - 1);
	}
	private List<Integer> values;
	public ConvertSortedListToBinarySearchTree() {
	    this.values = new ArrayList<Integer>();
	}
	private void mapListToValues(ListNode head) {
	    while (head != null) {
	    	this.values.add(head.val);
	    	head = head.next;
	    }
	}
	private TreeNode convertListToBST(int left, int right) {
	    // Invalid case
	    if (left > right) {
	      return null;
	    }
	    // Middle element forms the root.
	    int mid = (left + right) / 2;
	    TreeNode node = new TreeNode(this.values.get(mid));

	    // Base case for when there is only one element left in the array
	    if (left == right) {
	      return node;
	    }
	    // Recursively form BST on the two halves
	    node.left = convertListToBST(left, mid - 1);
	    node.right = convertListToBST(mid + 1, right);
	    return node;
	}
	
	/**
	 * 答案3--Inorder Simulation
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(logn)
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBST3(ListNode head) {
	    // Get the size of the linked list first
	    int size = this.findSize(head);
	    this.head = head;
	    // Form the BST now that we know the size
	    return convertListToBST1(0, size - 1);
	}
	private ListNode head;
	private int findSize(ListNode head) {
	    ListNode ptr = head;
	    int c = 0;
	    while (ptr != null) {
	      ptr = ptr.next;  
	      c += 1;
	    }
	    return c;
	}
	private TreeNode convertListToBST1(int l, int r) {
	    // Invalid case
	    if (l > r) {
	      return null;
	    }
	    int mid = (l + r) / 2;

	    // First step of simulated inorder traversal. Recursively form
	    // the left half
	    TreeNode left = this.convertListToBST1(l, mid - 1);
	    // Once left half is traversed, process the current node
	    TreeNode node = new TreeNode(this.head.val);
	    node.left = left;
	    // Maintain the invariance mentioned in the algorithm
	    this.head = this.head.next;
	    // Recurse on the right hand side and form BST out of them
	    node.right = this.convertListToBST1(mid + 1, r);
	    return node;
	}

	public static void main(String[] args) {
		ListNode l5 = new ListNode(9);
		ListNode l4 = new ListNode(5);
		ListNode l3 = new ListNode(0);
		ListNode l2 = new ListNode(-3);
		ListNode l1 = new ListNode(-10);
		l4.next = l5;
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;
		System.out.println(sortedListToBST(l1));
	}

}
