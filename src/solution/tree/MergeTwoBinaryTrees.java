package solution.tree;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-11-22
 * Easy
 * Question 617:Merge Two Binary Trees.
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. 
 * Otherwise, the NOT null node will be used as the node of new tree.
 * Example 1:
 * Input: 
	   Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
 * Output: 
 * Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 * Note:The merging process must start from the root nodes of both trees.
 */
public class MergeTwoBinaryTrees {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1==null){
			return t2;
		}
		if(t2==null){
			return t1;
		}
		TreeNode t = new TreeNode(0);
		t.val = t1.val + t2.val;
		t.left = mergeTrees(t1.left,t2.left);
		t.right = mergeTrees(t1.right,t2.right);
		return t;
    }
	
	/**
	 * 答案1--Using Recursion[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param t1
	 * @param t2
	 * @return
	 */
	public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
	
	/**
	 * 答案2--Iterative Method[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param t1
	 * @param t2
	 * @return
	 */
	public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack < TreeNode[] > stack = new Stack < > ();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(5);
		t2.left = t4;
		t1.left = t2;
		t1.right = t3;
		TreeNode s1 = new TreeNode(2);
		TreeNode s2 = new TreeNode(1);
		TreeNode s3 = new TreeNode(3);
		TreeNode s4 = new TreeNode(4);
		TreeNode s5 = new TreeNode(7);
		s2.right = s4;
		s3.right = s5;
		s1.left = s2;
		s1.right = s3;
		System.out.println(mergeTrees(t1,s1));
	}

}
