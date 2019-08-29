package solution.tree;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-08-29
 * Medium
 * Question 106:Construct Binary Tree from Inorder and Postorder Traversal.
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
	    3
	   / \
	  9  20
	    /  \
	   15   7
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(inorder, inorder.length-1, 0, postorder, postorder.length-1);
	}
	private static TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder,
			int postStart) {
		if (postStart < 0 || inStart < inEnd)
			return null;
		//The last element in postorder is the root.
		TreeNode root = new TreeNode(postorder[postStart]);
		
		//find the index of the root from inorder. Iterating from the end.
		int rIndex = inStart;
		for (int i = inStart; i >= inEnd; i--) {
			if (inorder[i] == postorder[postStart]) {
				rIndex = i;
				break;
			}
		}
		//build right and left subtrees. Again, scanning from the end to find the sections.
		root.right = helper(inorder, inStart, rIndex + 1, postorder, postStart-1);
		root.left = helper(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
		return root;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public TreeNode buildTree1(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
		HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
		for (int i=0;i<inorder.length;++i)
			hm.put(inorder[i], i);
		return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
	                          postorder.length-1,hm);
	}
	private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, 
	                                 HashMap<Integer,Integer> hm){
		if (ps>pe || is>ie) return null;
		TreeNode root = new TreeNode(postorder[pe]);
		int ri = hm.get(postorder[pe]);
		TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
		TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
		root.left = leftchild;
		root.right = rightchild;
		return root;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public TreeNode buildTree2(int[] inorder, int[] postorder) {
	    if (inorder.length == 0 || postorder.length == 0) return null;
	    int ip = inorder.length - 1;
	    int pp = postorder.length - 1;
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode prev = null;
	    TreeNode root = new TreeNode(postorder[pp]);
	    stack.push(root);
	    pp--;
	    
	    while (pp >= 0) {
	        while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
	            prev = stack.pop();
	            ip--;
	        }
	        TreeNode newNode = new TreeNode(postorder[pp]);
	        if (prev != null) {
	            prev.left = newNode;
	        } else if (!stack.isEmpty()) {
	            TreeNode currTop = stack.peek();
	            currTop.right = newNode;
	        }
	        stack.push(newNode);
	        prev = null;
	        pp--;
	    }
	    
	    return root;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public TreeNode buildTree3(int[] inorder, int[] postorder) {
	    return buildTree(inorder, inorder.length-1, 0, postorder, postorder.length-1);
	}
	private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder,
			int postStart) {
		if (postStart < 0 || inStart < inEnd)
			return null;
		
		//The last element in postorder is the root.
		TreeNode root = new TreeNode(postorder[postStart]);
		
		//find the index of the root from inorder. Iterating from the end.
		int rIndex = inStart;
		for (int i = inStart; i >= inEnd; i--) {
			if (inorder[i] == postorder[postStart]) {
				rIndex = i;
				break;
			}
		}
		//build right and left subtrees. Again, scanning from the end to find the sections.
		root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart-1);
		root.left = buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
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
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		System.out.println(buildTree(inorder, postorder));
	}

}
