package solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-10-25
 * Medium
 * Question 144:Binary Tree Preorder Traversal.
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Example:
 * Input: [1,null,2,3]
	   1
	    \
	     2
	    /
	   3
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.left != null) {
				stack.add(node.left);
			}
		}
		return list;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的答案一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal1(TreeNode node) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> rights = new Stack<TreeNode>();
		while(node != null) {
			list.add(node.val);
			if (node.right != null) {
				rights.push(node.right);
			}
			node = node.left;
			if (node == null && !rights.isEmpty()) {
				node = rights.pop();
			}
		}
	    return list;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,DFS递归
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		if(root==null) return pre;
		Stack<TreeNode> tovisit = new Stack<TreeNode>();
		tovisit.push(root);
		while(!tovisit.empty()) {
			TreeNode visiting = tovisit.pop();
			pre.add(visiting.val);
			if(visiting.right!=null) tovisit.push(visiting.right);
			if(visiting.left!=null) tovisit.push(visiting.left);
		}
		return pre;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t2.left = t3;
		t1.right = t2;
		System.out.println(preorderTraversal(t1));
	}

}
