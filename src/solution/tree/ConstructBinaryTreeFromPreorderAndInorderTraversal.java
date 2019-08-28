package solution.tree;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2019-08-28
 * Medium
 * Question 105:Construct Binary Tree from Preorder and Inorder Traversal.
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
	    3
	   / \
	  9  20
	    /  \
	   15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}
	private static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	        }
	    }
	    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree1(int[] preorder, int[] inorder) {
	    return helper1(0, 0, inorder.length - 1, preorder, inorder);
	}
	public TreeNode helper1(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	        }
	    }
	    root.left = helper1(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helper1(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		if(preorder==null || inorder==null || inorder.length==0 || preorder.length==0) return null;
		TreeNode root = new TreeNode(preorder[0]);
		if(preorder.length==1) return root;
		int breakindex = -1;
		for(int i=0;i<inorder.length;i++) { if(inorder[i]==preorder[0]) { breakindex=i; break;} }
		int[] subleftpre  = Arrays.copyOfRange(preorder,1,breakindex+1);
		int[] subleftin   = Arrays.copyOfRange(inorder,0,breakindex);
		int[] subrightpre = Arrays.copyOfRange(preorder,breakindex+1,preorder.length);
		int[] subrightin  = Arrays.copyOfRange(inorder,breakindex+1,inorder.length);
		root.left  = buildTree2(subleftpre,subleftin);
		root.right = buildTree2(subrightpre,subrightin);
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		t3.left = t4;
		t3.right = t5;
		t1.left = t2;
		t1.right = t3;
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		System.out.println(buildTree(preorder, inorder));
	}

}
