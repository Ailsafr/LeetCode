package solution.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2018-03-12
 * Easy
 * Question 101:Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {

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
	 * 时间复杂度：*
	 * 空间复杂度：O(1)
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
		TreeNode symRoot = getNewTree(root);
		return isSameTree(root,symRoot);
    }
	
	private static TreeNode getNewTree(TreeNode tree){
		if(tree==null){
			return tree;
		}
		TreeNode sym = new TreeNode(tree.val);
		if(tree.left!=null){
			sym.right = getNewTree(tree.left);
		}
		if(tree.right!=null){
			sym.left = getNewTree(tree.right);
		}
		return sym;
	}
	
	private static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null){
			return true;
		}else if(p==null||q==null){
			return false;
		}
		if(p.val==q.val){
			return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
		}else{
			return false;
		}
	}
	
	/**
	 * 答案--递归
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public boolean isSymmetric1(TreeNode root) {
	    return isMirror(root, root);
	}

	public boolean isMirror(TreeNode t1, TreeNode t2) {
	    if (t1 == null && t2 == null) return true;
	    if (t1 == null || t2 == null) return false;
	    return (t1.val == t2.val)
	        && isMirror(t1.right, t2.left)
	        && isMirror(t1.left, t2.right);
	}
	
	/**
	 * 答案--迭代
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public boolean isSymmetric3(TreeNode root) {
	    Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    while (!q.isEmpty()) {
	        TreeNode t1 = q.poll();
	        TreeNode t2 = q.poll();
	        if (t1 == null && t2 == null) continue;
	        if (t1 == null || t2 == null) return false;
	        if (t1.val != t2.val) return false;
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t5;
		t3.right = t4;
		System.out.println(isSymmetric(t1));
	}

}
