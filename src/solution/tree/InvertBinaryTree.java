package solution.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2018-06-22
 * Easy
 * Question 226:Invert Binary Tree.
 * Invert a binary tree.
 * Example:
 * Input:
	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
 * Output:
	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1
 */
public class InvertBinaryTree {

	/**
	 * 我自己写的方法，跟答案1一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static TreeNode invertTree(TreeNode root) {
		if(root==null){
			return root;
		}
		TreeNode temp = new TreeNode(0);
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
    }
	
	/**
	 * 答案1--Recursive
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public TreeNode invertTree1(TreeNode root) {
	    if (root == null) {
	        return null;
	    }
	    TreeNode right = invertTree(root.right);
	    TreeNode left = invertTree(root.left);
	    root.left = right;
	    root.right = left;
	    return root;
	}
	
	/**
	 * 答案2--Iterative
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public TreeNode invertTree2(TreeNode root) {
	    if (root == null) return null;
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        TreeNode current = queue.poll();
	        TreeNode temp = current.left;
	        current.left = current.right;
	        current.right = temp;
	        if (current.left != null) queue.add(current.left);
	        if (current.right != null) queue.add(current.right);
	    }
	    return root;
	}
	
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(7);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(9);
		t3.left = t6;
		t3.right = t7;
		t2.left = t4;
		t2.right = t5;
		t1.left = t2;
		t1.right = t3;
		System.out.println(invertTree(t1));
		TreeNode ss = t1;
		System.out.println(t1);
	}

}
