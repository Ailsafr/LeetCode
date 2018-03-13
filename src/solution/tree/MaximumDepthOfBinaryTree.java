package solution.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author By RuiCUI
 * 2018-03-13
 * Easy
 * Question 104:Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * return its depth = 3.
 */
public class MaximumDepthOfBinaryTree {

	/**
	 * Definition for a binary tree node.
	 */
	public static class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		if(root.left==null&&root.right==null){
			return 1;
		}
		int left = 0;
		int right = 0;
		if(root.left!=null||root.right!=null){
			left = 1 + maxDepth(root.left);
			right = 1 + maxDepth(root.right);
		}
		return left>right?left:right;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的思路一样,少了些判断
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public int maxDepth1(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth1(root.left),maxDepth1(root.right));
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,用了迭代而不是递归
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public int maxDepth2(TreeNode root) {
		if (root == null)
			return 0;
		
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		
		stack.push(root);
		int count = 0;
		
		while (!stack.isEmpty()) {
			int size = stack.size();
			while (size-- > 0) {
				TreeNode cur = stack.pop();
				if (cur.left != null)
					stack.addLast(cur.left);
				if (cur.right != null)
					stack.addLast(cur.right);
			}
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(7);
		t3.left = t4;
		t3.right = t5;
		t4.left = t6;
		t1.left = t2;
		t1.right = t3;
		System.out.println(maxDepth(t1));
	}

}
