package solution.tree;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-03-20
 * Easy
 * Question 112:Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param sum
	 * @return
	 */
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root==null){
			return false;
		}
		if(root.left==null&&root.right==null&&sum==root.val){
			return true;
		}
		sum = sum - root.val;
		return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的答案一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum1(TreeNode root, int sum) {
        if(root == null) return false;
    
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
    
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,利用栈
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum2(TreeNode root, int sum) {
	    Stack <TreeNode> stack = new Stack<> ();	    
	    stack.push(root) ;	    
	    while (!stack.isEmpty() && root != null){
	    	TreeNode cur = stack.pop() ;	
	    	if (cur.left == null && cur.right == null){	    		
	    		if (cur.val == sum ) return true ;
	    	}
	    	if (cur.right != null) {
	    		cur.right.val = cur.val + cur.right.val ;
	    		stack.push(cur.right) ;
	    	}
	    	if (cur.left != null) {
	    		cur.left.val = cur.val + cur.left.val;
	    		stack.push(cur.left);
	    	}
	    }	    
	    return false ;
	 }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(11);
		TreeNode t5 = new TreeNode(13);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(2);
		TreeNode t9 = new TreeNode(1);
		t4.left = t7;
		t4.right = t8;
		t6.right = t9;
		t2.left = t4;
		t3.left = t5;
		t3.right = t2;
		t1.left = t2;
		t1.right = t3;
		System.out.println(hasPathSum(t1,22));
	}

}
