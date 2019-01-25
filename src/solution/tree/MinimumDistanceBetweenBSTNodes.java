package solution.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-01-25
 * Easy
 * Question 783:Minimum Distance Between BST Nodes.
 * Given a Binary Search Tree (BST) with the root node root, 
 * return the minimum difference between the values of any two different nodes in the tree.
 * Example :
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
          4
         / \
        2   6
       / \    
      1   3  
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, 
 * also between node 3 and node 2.
 * Note:
 * 1.The size of the BST will be between 2 and 100.
 * 2.The BST is always valid, each node's value is an integer, and each node's value is different.
 */
public class MinimumDistanceBetweenBSTNodes {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static int minDiffInBST(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		helper(list,root);
		Collections.sort(list);
		int result = Integer.MAX_VALUE;
		int len = list.size();
		for(int i=0;i<len-1;i++){
			result = Math.min(list.get(i+1)-list.get(i), result);
		}
		return result;
    }
	private static void helper(List<Integer> list,TreeNode root){
		if(root==null){
			return;
		}
		list.add(root.val);
		if(root.left!=null){
			helper(list,root.left);
		}
		if(root.right!=null){
			helper(list,root.right);
		}
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param root
	 * @return
	 */
	int min = Integer.MAX_VALUE;
	Integer pre = null;
	public int minDiffInBST1(TreeNode root) {
	    check(root);
	    return min;
	}
	private void check(TreeNode node) {
	    if (node == null) return;
	    check(node.left);
	    if (pre != null)
	        min = Math.min(min, node.val - pre);
	    pre = node.val;
	    check(node.right);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,DFS递归
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public int minDiffInBST2(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int[] min = {Integer.MAX_VALUE};
		traverse(root.left, root.val, root.val, min);
		traverse(root.right, root.val, root.val, min);
		return min[0];
	}
	private void traverse(TreeNode root, int lower, int higher, int[] min) {
		if (root == null) {
			return;
		}
		int diff1 = Math.abs(root.val - lower);
		int diff2 = Math.abs(root.val - higher);
		min[0] = Math.min(min[0], diff1);
		min[0] = Math.min(min[0], diff2);
		traverse(root.left, lower, root.val, min);
		traverse(root.right, root.val, higher, min);
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		t2.left = t4;
		t2.right = t5;
		t1.left = t2;
		t1.right = t3;
		System.out.println(minDiffInBST(t1));
	}

}
