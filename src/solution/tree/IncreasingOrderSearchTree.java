package solution.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-03-22
 * Easy
 * Question 897:Increasing Order Search Tree.
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, 
 * and every node has no left child and only 1 right child.
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
		       5
		      / \
		    3    6
		   / \    \
		  2   4    8
		 /        / \ 
		1        7   9
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
				 1
				  \
				   2
				    \
				     3
				      \
				       4
				        \
				         5
				          \
				           6
				            \
				             7
				              \
				               8
				                \
				                 9  
 * Note:
 * 1. The number of nodes in the given tree will be between 1 and 100.
 * 2. Each node will have a unique integer value from 0 to 1000.
 */
public class IncreasingOrderSearchTree {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
	public static TreeNode increasingBST(TreeNode root) {
		List<Integer> vals = new ArrayList();
        helper(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public static void helper(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        helper(node.left, vals);
        vals.add(node.val);
        helper(node.right, vals);
    }
	
	/**
	 * 答案1--In-Order Traversal
	 * 时间复杂度：O(n) where n is the number of nodes in the given tree.
	 * 空间复杂度：O(n) where n is the number of nodes in the given tree.
	 * @param root
	 * @return
	 */
	public TreeNode increasingBST1(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }
    
    /**
	 * 答案2--Traversal with Relinking
	 * 时间复杂度：O(n) where n is the number of nodes in the given tree.
	 * 空间复杂度：O(h) in additional space complexity, where h is the height of the given tree, and the size of the implicit call stack in our in-order traversal. 
	 * @param root
	 * @return
	 */
    TreeNode cur;
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(8);
		TreeNode t7 = new TreeNode(1);
		TreeNode t8 = new TreeNode(7);
		TreeNode t9 = new TreeNode(9);
		t6.left = t8;
		t6.right = t9;
		t4.left = t7;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		t1.left = t2;
		t1.right = t3;
		System.out.println(increasingBST(t1));
	}

}
