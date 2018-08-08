package solution.tree;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-08-08
 * Easy
 * Question 404:Sum of Left Leaves.
 * Find the sum of all left leaves in a given binary tree.
 * Example:
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {

	/**
	 * ���Լ�д�ķ���--�ݹ�--DFS
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param root
	 * @return
	 */
	public static int sumOfLeftLeaves(TreeNode root) {
		if(root==null){
			return 0;
		}
		if(root.left!=null&&root.left.left==null&&root.left.right==null){
			return root.left.val+sumOfLeftLeaves(root.right);
		}else{
			return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
		}
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�,���ҵ�˼·һ��--DFS solution
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param root
	 * @return
	 */
	public int sumOfLeftLeaves1(TreeNode root) {
	    if(root == null) return 0;
	    int ans = 0;
	    if(root.left != null) {
	        if(root.left.left == null && root.left.right == null) ans += root.left.val;
	        else ans += sumOfLeftLeaves(root.left);
	    }
	    ans += sumOfLeftLeaves(root.right);
	    
	    return ans;
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�--BFS solution
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param root
	 * @return
	 */
	public int sumOfLeftLeaves2(TreeNode root) {
	    if(root == null) return 0;
	    int ans = 0;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	    
	    while(!stack.empty()) {
	        TreeNode node = stack.pop();
	        if(node.left != null) {
	            if (node.left.left == null && node.left.right == null)
	                ans += node.left.val;
	            else
	                stack.push(node.left);
	        }
	        if(node.right != null) {
	            if (node.right.left != null || node.right.right != null)
	                stack.push(node.right);
	        }
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(-9);
		TreeNode t2 = new TreeNode(-3);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(0);
		TreeNode t7 = new TreeNode(-6);
		TreeNode t8 = new TreeNode(-5);
		t4.left = t7;
		t2.right = t4;
		t1.left = t2;
		t1.right = t3;
		t3.left = t5;
		t3.right = t6;
		t5.left = t8;
		System.out.println(sumOfLeftLeaves(t1));
	}
}
