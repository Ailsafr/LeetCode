package solution.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-08-23
 * Medium
 * Question 98:Validate Binary Search Tree.
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
	    2
	   / \
	  1   3
 * Input: [2,1,3]
 * Output: true
 * Example 2:
	    5
	   / \
	  1   4
	     / \
	    3   6
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}
	private static boolean helper(TreeNode node, Integer lower, Integer upper) {
	    if (node == null) return true;

	    int val = node.val;
	    if (lower != null && val <= lower) return false;
	    if (upper != null && val >= upper) return false;

	    if (! helper(node.right, val, upper)) return false;
	    if (! helper(node.left, lower, val)) return false;
	    return true;
	}
	
	/**
	 * 答案1--Recursion
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public boolean isValidBST1(TreeNode root) {
	    return helper(root, null, null);
	}
	public boolean helper1(TreeNode node, Integer lower, Integer upper) {
	    if (node == null) return true;

	    int val = node.val;
	    if (lower != null && val <= lower) return false;
	    if (upper != null && val >= upper) return false;

	    if (! helper1(node.right, val, upper)) return false;
	    if (! helper1(node.left, lower, val)) return false;
	    return true;
	}
	
	/**
	 * 答案2--Iteration
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public boolean isValidBST2(TreeNode root) {
	    Integer lower = null, upper = null, val;
	    update(root, lower, upper);

	    while (!stack.isEmpty()) {
	    	root = stack.poll();
	    	lower = lowers.poll();
	    	upper = uppers.poll();

	    	if (root == null) continue;
	    	val = root.val;
	    	if (lower != null && val <= lower) return false;
	    	if (upper != null && val >= upper) return false;
	    	update(root.right, val, upper);
	    	update(root.left, lower, val);
	    }
	    return true;
	}
	LinkedList<TreeNode> stack = new LinkedList();
	LinkedList<Integer> uppers = new LinkedList(),lowers = new LinkedList();
	public void update(TreeNode root, Integer lower, Integer upper) {
	    stack.add(root);
	    lowers.add(lower);
	    uppers.add(upper);
	}
	
	/**
	 * 答案3--Inorder traversal
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public boolean isValidBST3(TreeNode root) {
	    Stack<TreeNode> stack = new Stack();
	    double inorder = - Double.MAX_VALUE;

	    while (!stack.isEmpty() || root != null) {
	    	while (root != null) {
	    		stack.push(root);
	    		root = root.left;
	    	}
	    	root = stack.pop();
	    	// If next element in inorder traversal
	    	// is smaller than the previous one
	    	// that's not BST.
	    	if (root.val <= inorder) 
	    		return false;
    		inorder = root.val;
    		root = root.right;
    	}
	    return true;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		System.out.println(isValidBST(t1));
	}

}
