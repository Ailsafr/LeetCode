package solution.tree;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-03-10
 * Easy
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * Example 1:
 * Input:  1         1
          / \       / \
         2   3     2   3
        [1,2,3],   [1,2,3]
 * Output: true
 * 
 * Example 2:
 * Input:  1         1
          /           \
         2             2
        [1,2],     [1,null,2]
 * Output: false
 * 
 * Example 3:
 * Input:  1         1
          / \       / \
         2   1     1   2
        [1,2,1],   [1,1,2]
 * Output: false
 */
public class SameTree {

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
	 * 我自己写的方法--刚开始被例子里的input给误导了，完全不需要多写一个方法出来
	 * 时间复杂度：*
	 * 空间复杂度：O(1)
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null){
			return true;
		}else if((p==null&&q!=null)||(p!=null&&q==null)){
			return false;
		}
		String str1 = transTree(p);
		String str2 = transTree(q);
		if(str1.equals(str2)){
			return true;
		}
		return false;
	}
	
	private static String transTree(TreeNode tree){
		String result = "";
		result += tree.val;
		if(tree.left!=null){
			result += transTree(tree.left);
		}else{
			result += "null";
		}
		if(tree.right!=null){
			result += transTree(tree.right);
		}else{
			result += "null";
		}
		return result;
	}
	
	/**
	 * 我自己写的方法--刚开始被例子里的input给误导了，完全不需要多写一个方法出来
	 * 时间复杂度：*
	 * 空间复杂度：O(1)
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean isSameTree1(TreeNode p, TreeNode q) {
		if(p==null&&q==null){
			return true;
		}else if((p==null&&q!=null)||(p!=null&&q==null)){
			return false;
		}
		if(p.val==q.val){
			return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
		}else{
			return false;
		}
	}
	 
	/**
	 * 官网没有solution,这是其他人的答案,跟我的思路一样，简便在最开始的判断
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree2(TreeNode p, TreeNode q) {
	    if(p == null && q == null) return true;
	    if(p == null || q == null) return false;
	    if(p.val == q.val)
	        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	    return false;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,利用栈，没有用递归
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree3(TreeNode p, TreeNode q) {
	    Stack<TreeNode> stack_p = new Stack <> ();       
	    Stack<TreeNode> stack_q = new Stack <> ();
	    if (p != null) stack_p.push( p ) ;
	    if (q != null) stack_q.push( q ) ;
	    while (!stack_p.isEmpty() && !stack_q.isEmpty()) {
	    	TreeNode pn = stack_p.pop() ;
	    	TreeNode qn = stack_q.pop() ;	    	
	    	if (pn.val != qn.val) return false ;
	    	if (pn.right != null) stack_p.push(pn.right) ;
	    	if (qn.right != null) stack_q.push(qn.right) ;
	    	if (stack_p.size() != stack_q.size()) return false ;
	    	if (pn.left != null) stack_p.push(pn.left) ;	    	 	    	 
	    	if (qn.left != null) stack_q.push(qn.left) ;
	    	if (stack_p.size() != stack_q.size()) return false ;
	    }		     
	    return stack_p.size() == stack_q.size() ;	 
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t3 = new TreeNode(1);
		t1.left = t2;
		t1.right = t4;
		t3.left = t2;
		t3.right = t2;
		System.out.println(isSameTree(t1,t3));
	}

}
